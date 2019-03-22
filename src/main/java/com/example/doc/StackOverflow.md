### JVM
---
#### 1.堆溢出
```java
//Params: -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
//-verbose:gc -Xms100M -Xmx100M -XX:+PrintGCDetails
class Test {
    public static void main(String[] args) {
    
       List<TestCase> cases = new ArrayList<TestCase>();

       while(true){

           cases.add(new TestCase());

       }
    }
}
//java.lang.OutOfMemoryError
```
---
#### 2. 栈溢出
```java
//args:-Xss128k
public class StackOverFlow {
    private int i ;
    
    public void plus() {
       i++;
       plus();
    }
    
    public static void main(String[] args) {
       StackOverFlow stackOverFlow = new StackOverFlow();
       try {
           stackOverFlow.plus();
       } catch (Exception e) {
           System.out.println("Exception:stack length:"+stackOverFlow.i);
           e.printStackTrace();
       } catch (Error e) {
           System.out.println("Error:stack length:"+stackOverFlow.i);
           e.printStackTrace();
       }
    }
}
//stackOverFlowError
```
---
#### 3.常量池溢出
```java
//args : -XX:PermSize=10M -XX:MaxPermSize=10M
//-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M (JDK 1.8以后使用元空间)
public class ConstantOutOfMemory {
    
    public static void main(String[] args) {
       try {
           List<String> strings = new ArrayList<String>();
           int i = 0;
           while(true){
              strings.add(String.valueOf(i++).intern());
           }
       } catch (Exception e) {
           e.printStackTrace();
           throw e;
       }
    }
}
//
```
#### 4.方法区溢出
```java
//args : -XX:PermSize=10M -XX:MaxPermSize=10M
//-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M (JDK 1.8以后使用元空间)
public class MethodAreaOutOfMemory {
    public static void main(String[] args) {
       while(true){
           Enhancer enhancer = new Enhancer();
           enhancer.setSuperclass(TestCase.class);
           enhancer.setUseCache(false);
           enhancer.setCallback(new MethodInterceptor() {
              @Override
              public Object intercept(Object arg0, Method arg1, Object[] arg2,
                     MethodProxy arg3) throws Throwable {
                  return arg3.invokeSuper(arg0, arg2);
              }
           });
           enhancer.create();
       }
    }
}

class TestCase{
}
//
```
---
#### 5.直接内存溢出
```java
//args: -Xmx20M -XX:MaxDirectMemorySize=10M
public class DirectoryMemoryOutOfmemory {
    private static final int ONE_MB = 1024*1024;
    private static int count = 1;
    public static void main(String[] args) {
       try {
           Field field = Unsafe.class.getDeclaredField("theUnsafe");
           field.setAccessible(true);
           Unsafe unsafe = (Unsafe) field.get(null);
           while (true) {
              unsafe.allocateMemory(ONE_MB);
              count++;
           }
       } catch (Exception e) {
           System.out.println("Exception:instance created "+count);
           e.printStackTrace();
       } catch (Error e) {
           System.out.println("Error:instance created "+count);
           e.printStackTrace();
       }
    }
}
//
```