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

## 集合
ArrayList
	默认容量 10
	实现了List、RandomAccess接口，可以插入空数据，也支持随机访问
	属性：elementData数组、size大小
	当调用add时，首先进行扩容校验，将插入的值放到尾部，并将size+1

Vector
	实现List接口，结构与ArrayList类似，也是一个动态数组存放数据
	add操作是使用加锁，保证线程安全
	
LinkedList
	实现List、Deque接口
	基于双向链表的
	add操作每次插入都是移动指针
	插入、删除都是移动指针比ArrayList效率高
	查询时遍历链表，所以效率比较低
	当查询时，利用双向链表的特性，如果index离链表头比较近就从节点头遍历，否则就从节点尾遍历，复杂度O(n/2)
	
HashMap
	1.7
	底层基于数组和链表
	两个重要参数：容量（默认16）、负载因子（默认0.75）
	put操作
		将传入的Key做Hash运算得出Hashcode，然后根据数组长度取模计算出数组下标
		index相同，使用链表来解决，采用头插法将数据插入链表中
		取余，遵循尽可能让商大的原则
		取模，遵循尽可能让商小的原则
	get操作
		key计算index，如果是链表遍历链表，通过equals找到对应的元素
	并发场景使用HashMap容易出现死循环，并发场景发生扩容，调用 resize() 方法里的 rehash() 时，容易出现环形链表。这样当获取一个不存在的 key 时，计算出的 index 正好是环形链表的下标时就会出现死循环。
	1.8
	优化：当Hash碰撞之后写入链表的长度超过了阀值（默认为8）并且table的长度不小于64（否则扩容一次）时，链表将会转换为红黑树。
	假设Hash冲突的非常严重，一个数组后面接了很长的链表，此时查询的时间复杂度就是O(n)。
	如果是红黑树，时间复杂度就是O(logN),大大提高了查询效率。
	
红黑树	
	红黑树是一种平衡二叉树，具有以下特性：
	1.节点是红色或者黑色；
	2.根节点是黑色；
	3.每个叶子的节点都是黑色的空节点（Nail）；
	4.每个红色节点的两个子节点都是黑色的；
	5.从任意节点到其每个叶子节点的所有路径都包含相同的黑色节点。
	为了符合规则，左旋、右旋或者变色
	
HashSet
	不允许存储重复元素的集合
	成员变量：
		map 用于存放最终数据的
		PRESENT 是所有写入map的value值
	add 比较关键的就是这个 add() 方法。 可以看出它是将存放的对象当做了 HashMap 的健，value 都是相同的 PRESENT 。由于 HashMap 的 key 是不能重复的，所以每当有重复的值写入到 HashSet 时，value 会被覆盖，但 key 不会受到影响，这样就保证了 HashSet 中只能存放不重复的元素。
	
LinkedHashMap
	HashMap是无序的，遍历的顺序并不是写入的顺序
	LinkedHashMap是有序的，底层继承了HashMap，由一个双向链表构成
	排序方式有两种：
		根据写入顺序排序
		根据访问顺序排序
		
## Java多线程
多线程常见问题
	上下文切换
		CPU通过给每个线程分配一定的时间片，CPU可以在不同的线程之间切换
		但是由于在线程切换的时候需要保存本次执行的信息(详见)，在该线程被 CPU 剥夺时间片后又再次运行恢复上次所保存的信息的过程就称为上下文切换
		上下文切换非常耗效率，通常的解决办法：
			1.采用无锁编程，比如讲数据按照Hash（id）进行取模分段，每个线程处理各自分段的数据，从而避免使用锁；
			2.采用 CAS(compare and swap) 算法，如 Atomic 包就是采用 CAS 算法
			3.合理的创建线程，避免创建了一些线程但其中大部分都是处于 waiting 状态，因为每当从 waiting 状态切换到 running 状态都是一次上下文切换
	死锁
		死锁的场景一般是：线程 A 和线程 B 都在互相等待对方释放锁，或者是其中某个线程在释放锁的时候出现异常如死循环之类的。这时就会导致系统不可用。
		常用的解决方案如下：
			1.尽量一个线程只获取一个锁。
			2.一个线程只占用一个资源。
			3.尝试使用定时锁，至少能保证锁最终会被释放。
	资源限制
		当在带宽有限的情况下一个线程下载某个资源需要 1M/S,当开 10 个线程时速度并不会乘 10 倍，反而还会增加时间，毕竟上下文切换比较耗时。
		如果是受限于资源的话可以采用集群来处理任务，不同的机器来处理不同的数据，就类似于开始提到的无锁编程。

Synchronized 关键字原理
	使用方法：
		1.同步普通方法，锁的是当前对象
		2.同步静态方法，锁的是当前Class对象
		3.同步块，锁的是（）中的对象
	实现原理：
		JVM是通过进入退出对象监视器（Monitor）来实现对方法、同步块的同步的。
		具体实现是在编译之后在同步方法调用前加入一个 monitor.enter 指令，在退出方法和异常处插入 monitor.exit 的指令。
		其本质就是对一个对象监视器( Monitor )进行获取，而这个获取过程具有排他性从而达到了同一时刻只能一个线程访问的目的。
		而对于没有获取到锁的线程将会阻塞到方法入口处，直到获取锁的线程 monitor.exit 之后才能尝试继续获取锁。
	锁优化
		synchronized 很多都称之为重量锁，JDK1.6 中对 synchronized 进行了各种优化，为了能减少获取和释放锁带来的消耗引入了偏向锁和轻量锁。
	轻量锁
		当代码进入同步块时，如果同步对象为无锁状态时，当前线程会在栈帧中创建一个锁记录(Lock Record)区域，同时将锁对象的对象头中 Mark Word 拷贝到锁记录中，再尝试使用 CAS 将 Mark Word 更新为指向锁记录的指针。
		如果更新成功，当前线程就获得了锁。
		如果更新失败 JVM 会先检查锁对象的 Mark Word 是否指向当前线程的锁记录。
		如果是则说明当前线程拥有锁对象的锁，可以直接进入同步块。
		不是则说明有其他线程抢占了锁，如果存在多个线程同时竞争一把锁，轻量锁就会膨胀为重量锁。
	偏向锁

		为了进一步的降低获取锁的代价，JDK1.6 之后还引入了偏向锁。

		偏向锁的特征是:锁不存在多线程竞争，并且应由一个线程多次获得锁。

		当线程访问同步块时，会使用 CAS 将线程 ID 更新到锁对象的 Mark Word 中，如果更新成功则获得偏向锁，并且之后每次进入这个对象锁相关的同步块时都不需要再次获取锁了。
	释放锁
		当有另外一个线程获取这个锁时，持有偏向锁的线程就会释放锁，释放时会等待全局安全点(这一时刻没有字节码运行)，接着会暂停拥有偏向锁的线程，根据锁对象目前是否被锁来判定将对象头中的 Mark Word 设置为无锁或者是轻量锁状态。
		偏向锁可以提高带有同步却没有竞争的程序性能，但如果程序中大多数锁都存在竞争时，那偏向锁就起不到太大作用。可以使用 -XX:-UseBiasedLocking 来关闭偏向锁，并默认进入轻量锁。
		其他优化
	适应性自旋

		在使用 CAS 时，如果操作失败，CAS 会自旋再次尝试。由于自旋是需要消耗 CPU 资源的，所以如果长期自旋就白白浪费了 CPU。JDK1.6加入了适应性自旋:

		如果某个锁自旋很少成功获得，那么下一次就会减少自旋。
	
多线程的三大核心
	原子性
		Java 的原子性就和数据库事务的原子性差不多，一个操作中要么全部执行成功或者失败。

		JMM 只是保证了基本的原子性，但类似于 i++ 之类的操作，看似是原子操作，其实里面涉及到:

			获取 i 的值。
			自增。
			再赋值给 i。

		这三步操作，所以想要实现 i++ 这样的原子操作就需要用到 synchronized 或者是 lock 进行加锁处理。

		如果是基础类的自增操作可以使用 AtomicInteger 这样的原子类来实现(其本质是利用了 CPU 级别的 的 CAS 指令来完成的)。	
		其逻辑就是判断当前的值是否被更新过，是否等于 current，如果等于就说明没有更新过然后将当前的值更新为 next，如果不等于则返回false 进入循环，直到更新成功为止。
		
		还有其中的 get() 方法也很关键，返回的是当前的值，当前值用了 volatile 关键词修饰，保证了内存可见性。
	可见性
		现代计算机中，由于 CPU 直接从主内存中读取数据的效率不高，所以都会对应的 CPU 高速缓存，先将主内存中的数据读取到缓存中，线程修改数据之后首先更新到缓存，之后才会更新到主内存。如果此时还没有将数据更新到主内存其他的线程此时来读取就是修改之前的数据。
		
		volatile 关键字就是用于保证内存可见性，当线程A更新了 volatile 修饰的变量时，它会立即刷新到主线程，并且将其余缓存中该变量的值清空，导致其余线程只能去主内存读取最新值。

		使用 volatile 关键词修饰的变量每次读取都会得到最新的数据，不管哪个线程对这个变量的修改都会立即刷新到主内存。
		synchronized和加锁也能能保证可见性，实现原理就是在释放锁之前其余线程是访问不到这个共享变量的。但是和 volatile 相比开销较大。
	顺序性
		正常情况下的执行顺序应该是 1>>2>>3。但是有时 JVM 为了提高整体的效率会进行指令重排导致执行的顺序可能是 2>>1>>3。但是 JVM 也不能是什么都进行重排，是在保证最终结果和代码顺序执行结果一致的情况下才可能进行重排。

		重排在单线程中不会出现问题，但在多线程中会出现数据不一致的问题。

		Java 中可以使用 volatile 来保证顺序性，synchronized 和 lock 也可以来保证有序性，和保证原子性的方式一样，通过同一段时间只能一个线程访问来实现的。

		除了通过 volatile 关键字显式的保证顺序之外， JVM 还通过 happen-before 原则来隐式的保证顺序性。

		其中有一条就是适用于 volatile 关键字的，针对于 volatile 关键字的写操作肯定是在读操作之前，也就是说读取的值肯定是最新的。
	volatile的应用
		可以用 volatile 实现一个双重检查锁的单例模式：
		这里主要利用的是 volatile 的内存可见性。
		volatile 关键字只能保证可见性，顺序性，不能保证原子性。
对锁的一些认识 有哪些锁
	同一进程
	不同进程





















