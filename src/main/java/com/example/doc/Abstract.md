abstract 修饰符

---
抽象类：

1.抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
2.一个类不能同时被 abstract 和 final 修饰。
3.如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
4.抽象类可以包含抽象方法和非抽象方法。 

---
抽象方法:

1.抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
2.抽象方法不能被声明成 final 和 static。
3.任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
4.如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。
5.抽象方法的声明以分号结尾，例如：public abstract sample();。 

---
synchronized 修饰符
synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。

---
transient 修饰符
序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。
该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。 不参与序列化

---
volatile 修饰符
volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
一个 volatile 对象引用可能是 null。 
禁止指令重排序
```java

public class MyRunnable implements Runnable
{
    private volatile boolean active;
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            // 代码
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}

```

1.通常情况下，在一个线程调用 run() 方法（在 Runnable 开启的线程），在另一个线程调用 stop() 方法。 
2.如果 第一行 中缓冲区的 active 值被使用，那么在 第二行 的 active 值为 false 时循环不会停止。
3.但是以上代码中我们使用了 volatile 修饰 active，所以该循环会停止。