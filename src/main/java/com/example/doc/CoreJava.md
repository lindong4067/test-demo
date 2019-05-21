## 数据类型
基本类型
    byte/8
    char/16
    short/16
    int/32
    float/32
    long/64
    double/64
    boolean/~
>boolean 只有两个值：true、false，可以使用 1 bit 来存储，但是具体大小没有明确规定。JVM 会在编译时期将 boolean 类型的数据转换为 int，使用 1 来表示 true，0 表示 false。JVM 支持 boolean 数组，但是是通过读写 byte 数组来实现的。

包装类型

## 进制
1.二进制数中,两数的补码之和等于两数和的补码.
2.补码＝反码+1
3.反码＝原码除符号位外其它数值取反（即该数的绝对值取反）,即“0”变“1”,“1”变“0”.
4.任何正数的原码 反码 补码的形式完全相同（即都是自身,不变）
5.在计算机中,有符号的数都是采用补码来表示的.
6.计算的时候,符号位也参与运算.

## collection

### Vector与ArrayList

都实现了List接口
1.Vector是线程安全的集合类，ArrayList不是线程安全的集合类，Vector使用synchronized保证线程安全。
2.Vector与ArrayList本质上都是一个Object[]数组，ArrayList提供了size属性，Vector提供了elementCount属性
记录集合内有效元素的个数
3.Vector与ArrayList的扩容并不一样，Vector默认长度是增长一倍，ArrayList是增长50%的容量
4.Vector与ArrayList的remove,add(index,obj)方法都会导致内部数组进行数据拷贝的操作，
这样在大数据量时，可能会影响效率
5.Vector与ArrayList的add(obj)方法，如果新增的有效元素个数超过数组本身的长度，都会导致数组进行扩容。

### HashMap与HashTable

都实现了Map接口
1.HashMap是非线程安全的，Hashtable是线程安全的
2.HashMap可以接受键值和值为null，而Hashtable不行
3.HashMap的迭代器(Iterator)是fail-fast迭代器,而Hashtable的enumerator迭代器不是fail-fast的，
所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，
但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。
但这并不是一个一定发生的行为，要看JVM。
4.HashMap比HashTable执行效率高

### ConcurrentHashMap与Hashtable

Collections.synchronizedMap()
Collections.synchronizedList()
都可以封装同步集合，但是他们仅有单个锁，对整个集合加锁，防止ConcurrentModificationException异常要在迭代
的时候要将集合锁定一段时间。
ConcurrentHashMap与CopyOnWriteArrayList保留了线程安全的同时，也提供了更高的并发性。
不同：
1.都能用于多线程环境，但是当Hashtable
2.但是当Hashtable的大小增加到一定的时候，性能会急剧下降，因为迭代时需要被锁定很长的时间。
因为ConcurrentHashMap引入了分割(segmentation)，不论它变得多么大，仅仅需要锁定map的某个部分，
而其它的线程不需要等到迭代完成才能访问map。简而言之，在迭代的过程中，ConcurrentHashMap仅仅
锁定map的某个部分，而Hashtable则会锁定整个map

### Thread与ThreadLocal
Thread
1.线程优先级
线程执行有优先级，int priority参数表示，最高10，最低1，默认5
2.线程状态
Thread共有6种状态，new(新建),runnable(运行), blocked(阻塞), waiting(等待), timed_waiting(有时间的等待), terminated(终止)
---------------------
* RUNNABLE，对应”就绪”和”运行”两种状态，也就是说处于就绪和运行状态的线程在java.lang.Thread中都表现为”RUNNABLE”
* BLOCKED，对应”阻塞”状态，此线程需要获得某个锁才能继续执行，而这个锁目前被其他线程持有，所以进入了被动的等待状态，直到抢到了那个锁，才会再次进入”就绪”状态
* WAITING，对应”阻塞”状态，代表此线程正处于无限期的主动等待中，直到有人唤醒它，它才会再次进入就绪状态
* TIMED_WAITING，对应”阻塞”状态，代表此线程正处于有限期的主动等待中，要么有人唤醒它，要么等待够了一定时间之后，才会再次进入就绪状态
--------------------- 
3.public的方法
```java
	 Thread Thread.currentThread() //获得当前线程的引用,获得当前线程后对其进行操作。 
	 Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() //返回线程由于未捕获到异常而突然终止时调用的默认处理程序。 
	 int Thread.activeCount() //当前线程所在线程组中活动线程的数目。 
	 void dumpStack() //将当前线程的堆栈跟踪打印至标准错误流。 
	 int enumerate(Thread[] tarray) //将当前线程的线程组及其子组中的每一个活动线程复制到指定的数组中。 
	 Map<Thread,StackTraceElement[]> getAllStackTraces() //返回所有活动线程的堆栈跟踪的一个映射。 
	 boolean holdsLock(Object obj) //当且仅当当前线程在指定的对象上保持监视器锁时，才返回 true。 
	 boolean interrupted() //测试当前线程是否已经中断。 
	 void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh) //设置当线程由于未捕获到异常而突然终止，并且没有为该线程定义其他处理程序时所调用的默认处理程序, 
	 void sleep(long millis) //休眠指定时间 
	 void sleep(long millis, int nanos) //休眠指定时间 
	 void yield() //暂停当前正在执行的线程对象，并执行其他线程,意义不太大 
	 void checkAccess() //判定当前运行的线程是否有权修改该线程。 
	 ClassLoader getContextClassLoader() //返回该线程的上下文 ClassLoader。 
	 long getId() //返回该线程的标识符。 
	 String getName() //返回该线程的名称。 
	 int getPriority() //返回线程的优先级。 
	 StackTraceElement[] getStackTrace() //返回一个表示该线程堆栈转储的堆栈跟踪元素数组。 
	 Thread.State getState() //返回该线程的状态。 
	 ThreadGroup getThreadGroup() //返回该线程所属的线程组。 
	 Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() //返回该线程由于未捕获到异常而突然终止时调用的处理程序。 
	 void interrupt() //中断线程。 
	 boolean isAlive() //测试线程是否处于活动状态。 
	 boolean isDaemon() //测试该线程是否为守护线程。 
	 boolean isInterrupted()//测试线程是否已经中断。 
	 void join() //等待该线程终止。 
	 void join(long millis) //等待该线程终止的时间最长为 millis 毫秒。 
	 void join(long millis, int nanos) //等待该线程终止的时间最长为 millis 毫秒 + nanos 纳秒。 
	 void run() //线程启动后执行的方法。 
	 void setContextClassLoader(ClassLoader cl) //设置该线程的上下文 ClassLoader。 
	 void setDaemon(boolean on) //将该线程标记为守护线程或用户线程。 
	 void start()//使该线程开始执行；Java 虚拟机调用该线程的 run 方法。 
	 String toString()//返回该线程的字符串表示形式，包括线程名称、优先级和线程组。 
```
4.守护线程
Java中有两类线程，用户线程(User Thread)和守护线程(Daemon Thread)
只要当前JVM实例中尚且存在任何一个非守护线程没有结束，守护线程就全部工作；只要当最后一个非守护线程结束时，
守护线程随着JVM一同结束工作。
Daemon的作用是为了其他线程的运行提供便利服务，守护线程最典型的应用就是GC(垃圾收集器)
(1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。
(2) 在Daemon线程中产生的新线程也是Daemon的。 
(3) 不要认为所有的应用都可以分配给Daemon来进行服务，比如读写操作或者计算逻辑。 

ThreadLocal，线程本地变量，线程本地存储，为变量在每个线程中创建一个副本，那么每个线程可以访问自己内部的副本变量。
```java
	public T get() { }
	public void set(T value) { }
	public void remove() { }
	protected T initialValue() { }
```
get()方法是用来获取ThreadLocal在当前线程中保存的变量副本，set()用来设置当前线程中变量的副本，
remove()用来移除当前线程中变量的副本，initialValue()是一个protected方法，一般是用来在
使用时进行重写的，它是一个延迟加载方法















