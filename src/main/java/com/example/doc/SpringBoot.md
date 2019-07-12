## 1. Spring

1.1 IOC
IOC(Inversion Of Control, 控制反转) 有两种实现方式，一种是DI(Dependency Injection), 另一种是DL(Dependency Lookup), 
前者是当前软件实体被动接受其依赖的其他组件被IOC容器注入，后者是当前软件实体主动的去某个服务注册地查找其依赖的那个服务。
1.1.1 DI
DI是IOC最常见的实现方式，共分为两个阶段：
    1 收集和注册
    2 分析和组装
    
1.1.2 作用域
1.1.2.1 Spring应用长下文的bean默认都是单例的方式创建的，也就是说，不管一个bean注入多少次，context中只存在它的一个实例。
1.1.2.2 Spring定义了多种作用域，可以基于这些作用域创建bean
    1 单例 Singleton  在整个应用中，只创建bean的一个实例
    2 原型 Prototype  每次注入或者通过spring应用上下文获取的时候，都会创建一个新的bean实例
    3 会话 Session    在web应用中，为每个会话创建一个bean实例
    4 请求 Request    在web应用中，为每个请求创建一个bean实例
    5 全局 GlobalSession  全局的web域，类似于servlet中的application
    
1.1.3 注解 Annotation
@Configuration  标注JavaConfig配置类
@Bean   任何一个标注了@Bean的方法，其返回值将作为一个bean定义注册到spring的ioc容器，方法名将默认成为该bean定义的id
@ComponentScan  @ComponentScan用于配合一些元信息Java annotation，比如@component和@repository等，将标注了这些元信息annotation的bean定义类批量采集到spring的ioc容器中。
                我们可以通过basePackages等属性来细粒度地定制@ComponentScan自动扫描的范围，如果不指定，则默认spring框架实现会从声明@ComponentScan所在类的package进行扫描。
@PropertySource与@PropertySources    @PropertySource用于从某些地方加载*.properties文件内容，并将其中的属性加载到ioc容器中，便于填充一些bean定义属性的占位符。 
@Import与@ImportResource     @Import负责引入JavaConfig形式定义的ioc容器配置，如果有一些遗留的配置或者遗留系统需要以xml的形式来配置（比如dubbo框架），
                            我们依然可以通过@ImportResource将它们一起合并到当前JavaConfig配置的容器中                  
@Qualifier("")  使用@Qualifier指定需要装配的组件的id，而不是使用属性名
@Primary        让Spring进行自动装配的时候，默认使用首选的bean；多个bean优先选这个bean

1.2 AOP
AOP(Aspect Oriented Programing, 面向切面编程)
Spring AOP使用了动态代理技术在运行期织入增强的代码, 使用两种动态代理技术，JDK和CGLIB

### 2. Spring Boot

2.1 注解

@SpringBootApplication  
是@SpringBootConfiguration，@EnableAutoConfiguration和@ComponentScan组合

@SpringBootConfiguration和@Configuration  
@SpringBootConfiguration本质上是一个@Configuration，启动类标注了@SpringBootConfiguration之后，本身其实也是一个ioc容器的配置类

@EnableAutoConfiguration
spring框架提供了各种名字以@Enable开头的annotation定义，比如@EnableScheduling、@EnableCaching、@EnableMBeanExport等，
@EnableAutoConfiguration就是借助@Import的支持，收集和注册特定场景相关的bean定义：
@EnableScheduling是通过@Import将spring调度框架相关的bean定义都加载到ioc容器。
@EnableMBeanExport是通过@Import将JMX相关的bean定义都加载到ioc容器

@ComponentScan
自动扫描并加载符合条件的组件或bean的定义，最终讲这些bean定义加载到容器中

2.2 执行流程

2.2.1 收集各种条件和回调接口，如: ApplicationContextInitializer ApplicationListener 
      通告 started()
2.2.2 创建并准备Environment
      通告 environmentPrepared()
2.2.3 创建并初始化ApplicationContext，例如：设置Environment，加载配置
      通告 contextPrepared()
      通告 contextLoaded()
2.2.4 refresh ApplicationContext, 完成程序启动
      执行 CommandLineRunner
      通告 finished()      

                                          






































