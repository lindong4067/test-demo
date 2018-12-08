package com.example.testeffective.mymvc.servlet;

import com.example.testeffective.mymvc.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//注解部署生效
//@WebServlet(name = "myDispatcherServlet", urlPatterns = "/*", loadOnStartup = 1,
//initParams = {@WebInitParam(name = "base-package", value = "com.example.testeffective.mymvc")})
@Slf4j
public class MyDispatcherServlet extends HttpServlet {
    private List<String> packageNames = new ArrayList<>();
    private Map<String, Object> instanceMap = new HashMap<>();
    private Map<String, String> nameMap = new HashMap<>();
    private Map<String, Method> urlMethodMap = new HashMap<>();
    private Map<Method, String> methodPackageMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //tomcat项目部署时生效
        //basePackage = config.getInitParameter("base-package");
        try {
            //1.扫描路径下的所有限定名
            String basePackage = "com.example.testeffective.mymvc";
            scanBasePackage(basePackage);
            //2.把带有MyController MyService MyRepository的类实例放入Map
            instance(packageNames);
            //3.String IOC注入
            springIOC();
            //4.URL地址与方法的映射
            handlerUrlMethodMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handlerUrlMethodMap() throws ClassNotFoundException {
        if (packageNames.size() < 1) {
            return;
        }
        for (String packageName : packageNames) {
            Class<?> aClass = Class.forName(packageName);
            if (aClass.isAnnotationPresent(MyController.class)) {
                Method[] methods = aClass.getMethods();
                StringBuffer baseUrl = new StringBuffer();
                if (aClass.isAnnotationPresent(MyRequestMapping.class)) {
                    MyRequestMapping requestMapping = aClass.getAnnotation(MyRequestMapping.class);
                    baseUrl.append(requestMapping.value());
                    log.debug("packageName : {}, baseUrl : {}", packageName, baseUrl);
                }
                for (Method method : methods) {
                    if (method.isAnnotationPresent(MyRequestMapping.class)) {
                        MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);
                        baseUrl.append(requestMapping.value());
                        urlMethodMap.put(baseUrl.toString(), method);
                        log.debug("Put url to urlMethodMap : {}, {}", baseUrl.toString(), method);
                        methodPackageMap.put(method, packageName);
                        log.debug("Put to methodPackageMap : {}, {}", method, packageName);
                    }
                }
            }
        }
    }

    private void springIOC() throws IllegalAccessException {
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            log.debug("springIOC entity : {}", entry.getKey());
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                log.debug("springIOC field : {}", field.getName());
                if (field.isAnnotationPresent(MyQualifier.class)) {
                    String name = field.getAnnotation(MyQualifier.class).value();
                    log.debug("springIOC Qualifier value : {}", name);
                    field.setAccessible(true);
                    field.set(entry.getValue(), instanceMap.get(name));
                    log.debug("springIOC field set : {}, {}", entry.getValue(), instanceMap.get(name));
                }
            }
        }
    }

    public void instance(List<String> packageNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (packageNames.size() < 1){
            return;
        }
        for (String name : packageNames) {
            log.debug("Get class for : {}", name);
            Class<?> aClass = Class.forName(name);
            if (aClass.isAnnotationPresent(MyController.class)) {
                MyController controller = aClass.getAnnotation(MyController.class);
                String controllerName = controller.value();
                instanceMap.put(controllerName, aClass.newInstance());
                log.debug("Put controller to instanceMap : {}, {}", controllerName, aClass.newInstance());
                nameMap.put(name, controllerName);
                log.debug("Put controller to nameMap : {}, {}", name, controllerName);
            } else if (aClass.isAnnotationPresent(MyService.class)) {
                MyService service = aClass.getAnnotation(MyService.class);
                String serviceName = service.value();
                instanceMap.put(serviceName, aClass.newInstance());
                log.debug("Put service to instanceMap : {}, {}", serviceName, aClass.newInstance());
                nameMap.put(name, serviceName);
                log.debug("Put service to nameMap : {}, {}", name, serviceName);
            } else if (aClass.isAnnotationPresent(MyRepository.class)) {
                MyRepository repository = aClass.getAnnotation(MyRepository.class);
                String repositoryName = repository.value();
                instanceMap.put(repositoryName, aClass.newInstance());
                log.debug("Put repository to instanceMap : {}, {}", repositoryName, aClass.newInstance());
                nameMap.put(name, repositoryName);
                log.debug("Put repository to nameMap : {}, {}", name, repositoryName);
            }
        }
    }

    private void scanBasePackage(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
        File basePackageFile = new File(url.getPath());
        log.debug("Scan basePackageFile : {}", basePackageFile);
        File[] childFile = basePackageFile.listFiles();
        for (File file : childFile) {
            if (file.isDirectory()){
                log.debug("Scan basePackage : {}", basePackage + "." + file.getName());
                scanBasePackage(basePackage + "." + file.getName());
            } else if (file.isFile()) {
                packageNames.add(basePackage + "." + file.getName().split("\\.")[0]);
                log.debug("Add packageNames : {}", basePackage + "." + file.getName().split("\\.")[0]);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        log.debug("doPost uri : {}", uri);

        //去除context path部分
        String contextPath = req.getContextPath();
        log.debug("contextPath : {}", contextPath);
        if (contextPath == null) {
            contextPath = "";
        }
        String path = uri.replaceAll(contextPath, "");
        log.debug("path : {}", path);

        //通过path找到method
        Method method = urlMethodMap.get(uri);
        if (method != null) {
            //通过method拿到controller对象，准备反射执行
            String packageName = methodPackageMap.get(method);
            log.debug("doPost packageName : {}", packageName);
            String controllerName = nameMap.get(packageName);
            log.debug("doPost controllerName : {}", controllerName);
            //拿到controller对象
            Object controller = instanceMap.get(controllerName);
            try {
                method.setAccessible(true);
                method.invoke(controller);
                resp.getWriter().write("This is my MVC framework!");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
