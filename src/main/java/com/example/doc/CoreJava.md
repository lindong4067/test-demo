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
### ArrayList
	默认容量 10
	实现了List、RandomAccess接口，可以插入空数据，也支持随机访问
	属性：elementData数组、size大小
	当调用add时，首先进行扩容校验，将插入的值放到尾部，并将size+1

### Vector
	实现List接口，结构与ArrayList类似，也是一个动态数组存放数据
	add操作是使用加锁，保证线程安全
	
### LinkedList
	实现List、Deque接口
	基于双向链表的
	add操作每次插入都是移动指针
	插入、删除都是移动指针比ArrayList效率高
	查询时遍历链表，所以效率比较低
	当查询时，利用双向链表的特性，如果index离链表头比较近就从节点头遍历，否则就从节点尾遍历，复杂度O(n/2)
	
### HashMap
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
	
### 红黑树	
	红黑树是一种平衡二叉树，具有以下特性：
	1.节点是红色或者黑色；
	2.根节点是黑色；
	3.每个叶子的节点都是黑色的空节点（Nail）；
	4.每个红色节点的两个子节点都是黑色的；
	5.从任意节点到其每个叶子节点的所有路径都包含相同的黑色节点。
	为了符合规则，左旋、右旋或者变色
	
### HashSet
	不允许存储重复元素的集合
	成员变量：
		map 用于存放最终数据的
		PRESENT 是所有写入map的value值
	add 比较关键的就是这个 add() 方法。 可以看出它是将存放的对象当做了 HashMap 的健，value 都是相同的 PRESENT 。由于 HashMap 的 key 是不能重复的，所以每当有重复的值写入到 HashSet 时，value 会被覆盖，但 key 不会受到影响，这样就保证了 HashSet 中只能存放不重复的元素。
	
### LinkedHashMap
	HashMap是无序的，遍历的顺序并不是写入的顺序
	LinkedHashMap是有序的，底层继承了HashMap，由一个双向链表构成
	排序方式有两种：
		根据写入顺序排序
		根据访问顺序排序
		
## Java多线程
### 多线程常见问题
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

### Synchronized 关键字原理
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
	
### 多线程的三大核心
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
### 对锁的一些认识 有哪些锁
	同一进程
		重入锁
			使用ReentrantLock获取锁的时候会判断当前线程是否为获取锁的线程，如果是则将同步状态+1，释放锁的时候将同步状态-1，只有同步状态为0时才会释放锁。
		读写锁
			使用ReentrantReadWriteLock同时维护一对锁，读锁与写锁，当写线程访问时其他线程都将阻塞，读线程访问则不会。通过读写锁的分离可以提高并发量和吞吐量。
	不同进程
		基于数据库
			可以创建一张表，将其中的某个字段设置为唯一索引，当多个请求过来的时候只有新建记录成功的请求才算获取到锁，当使用完毕删除这条记录的时候即释放锁。
			存在的问题:

				数据库单点问题，挂了怎么办？
				不是重入锁，同一进程无法在释放锁之前再次获得锁，因为数据库中已经存在了一条记录了。
				锁是非阻塞的，一旦 insert 失败则会立即返回，并不会进入阻塞队列只能下一次再次获取。
				锁没有失效时间，如果那个进程解锁失败那就没有请求可以再次获取锁了。

			解决方案:

				数据库切换为主从，不存在单点。
				在表中加入一个同步状态字段，每次获取锁的是加 1 ，释放锁的时候-1，当状态为 0 的时候就删除这条记录，即释放锁。
				非阻塞的情况可以用 while 循环来实现，循环的时候记录时间，达到 X 秒记为超时，break。
				可以开启一个定时任务每隔一段时间扫描找出多少 X 秒都没有被删除的记录，主动删除这条记录。
				
		基于Redis
			使用 setNX(key) setEX(timeout) 命令，只有在该 key 不存在的时候创建这个 key，就相当于获取了锁。由于有超时时间，所以过了规定时间会自动删除，这样也可以避免死锁。
			
		基于ZK
			多个客户端（jvm），同时在zk上创建相同的一个临时节点，因为临时节点路径是保证唯一，只要谁能够创建节点成功，谁就能够获取到锁，没有创建成功节点，就会进行等待，当释放锁的时候，采用事件通知给客户端重新获取锁的资源。

### ReentrantLock 实现原理
	使用synchronized来做同步处理，锁的获取和释放都是隐式的，实现的原理是通过编译后加上不同的机器指令来实现
	而 ReentrantLock 就是一个普通的类，它是基于 AQS(AbstractQueuedSynchronizer)来实现的。

	是一个重入锁：一个线程获得了锁之后仍然可以反复的加锁，不会出现自己阻塞自己的情况。

    AQS 是 Java 并发包里实现锁、同步的一个重要的基础框架。
	
	锁类型
		ReentrantLock分为公平锁和非公平锁，可以通过构造方法来指定具体类型：
		默认一般使用非公平锁，它的效率和吞吐量都比公平锁高的多
	获取锁
		private ReentrantLock lock = new ReentrantLock();
		public void run() {
			lock.lock();
			try {
				//do bussiness
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	释放锁
	总结

### ConcurrentHashMap 实现原理
	HashMap在容量大于总量\*负载因子发生扩容时会出现环形链表导致死循环。
		JDK1.7
			组成：Segment数组、HashEntry数组组成，和HashMap一样，仍有数组加链表组成。
			ConcurrentHashMap采用分段锁设计，其中Segment继承于ReentrantLock。不会像HashTable那样不管是put还是get操作都需要做同步处理，理论上ConcurrentHashMap支持CurrencyLevel（Segment数组数量）的线程并发，当一个线程锁占用一个Segment时，不会影响到其他的Segment。
			
			put方法
			虽然 HashEntry 中的 value 是用 volatile 关键词修饰的，但是并不能保证并发的原子性，所以 put 操作时仍然需要加锁处理。
			首先也是通过 Key 的 Hash 定位到具体的 Segment，在 put 之前会进行一次扩容校验。这里比 HashMap 要好的一点是：HashMap 是插入元素之后再看是否需要扩容，有可能扩容之后后续就没有插入就浪费了本次扩容(扩容非常消耗性能)。
			而 ConcurrentHashMap 不一样，它是在将数据插入之前检查是否需要扩容，之后再做插入操作。
			
			size 方法
			每个 Segment 都有一个 volatile 修饰的全局变量 count ,求整个 ConcurrentHashMap 的 size 时很明显就是将所有的 count 累加即可。但是 volatile 修饰的变量却不能保证多线程的原子性，所有直接累加很容易出现并发问题。
			但如果每次调用 size 方法将其余的修改操作加锁效率也很低。所以做法是先尝试两次将 count 累加，如果容器的 count 发生了变化再加锁来统计 size。
			至于 ConcurrentHashMap 是如何知道在统计时大小发生了变化呢，每个 Segment 都有一个 modCount 变量，每当进行一次 put remove 等操作，modCount 将会 +1。只要 modCount 发生了变化就认为容器的大小也在发生变化。
		JDK1.8
			1.抛弃了原有的Segment分段锁。而采用CAS + synchronized来保证并发安全性。
			2.将HashEntry改为Node，但作用都是相同的。
			3.其中val next都用了volatile修饰，保证了可见性。
			
			put方法
			    根据 key 计算出 hashcode 。
				判断是否需要进行初始化。
				f 即为当前 key 定位出的 Node，如果为空表示当前位置可以写入数据，利用 CAS 尝试写入，失败则自旋保证成功。
				如果当前位置的 hashcode == MOVED == -1,则需要进行扩容。
				如果都不满足，则利用 synchronized 锁写入数据。
				如果数量大于 TREEIFY_THRESHOLD 则要转换为红黑树。
			
			get方法
				根据计算出来的 hashcode 寻址，如果就在桶上那么直接返回值。
				如果是红黑树那就按照树的方式获取值。
				都不满足那就按照链表的方式遍历获取值。

### 如何优雅的使用和理解线程池
	前言
		使用线程池的目的：
		线程是稀缺资源，不能频繁创建
		解耦作用；线程的创建于执行分开，方便维护
		复用线程
	线程池原理
		谈到线程池就会想到池化技术，其中最核心的思想就是把宝贵的资源放到一个池子中；每次使用都从里面获取，用完之后又放回池子供其他人使用，有点吃大锅饭的意思。
		那在 Java 中又是如何实现的呢？
		在 JDK 1.5 之后推出了相关的 api，常见的创建线程池方式有以下几种：

			Executors.newCachedThreadPool()：无限线程池。
			Executors.newFixedThreadPool(nThreads)：创建固定大小的线程池。
			Executors.newSingleThreadExecutor()：创建单个线程的线程池。

		其实看这三种方式创建的源码就会发现：

			public static ExecutorService newCachedThreadPool() {
				return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
											  60L, TimeUnit.SECONDS,
											  new SynchronousQueue<Runnable>());
			}

		实际上还是利用 ThreadPoolExecutor 类实现的。

		所以我们重点来看下 ThreadPoolExecutor 是怎么玩的。
		首先是创建线程的 api：

		ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) 

		这几个核心参数的作用：

			corePoolSize 为线程池的基本大小。
			maximumPoolSize 为线程池最大线程大小。
			keepAliveTime 和 unit 则是线程空闲后的存活时间。
			workQueue 用于存放任务的阻塞队列。
			handler 当队列和最大线程池都满了之后的饱和策略。

		了解了这几个参数再来看看实际的运用。

		通常我们都是使用:

		threadPool.execute(new Job());
		
		然后看看 execute() 方法是如何处理的：

		获取当前线程池的状态。
		当前线程数量小于 coreSize 时创建一个新的线程运行。
		如果当前线程处于运行状态，并且写入阻塞队列成功。
		双重检查，再次获取线程状态；如果线程状态变了（非运行状态）就需要从阻塞队列移除任务，并尝试判断线程是否全部执行完毕。同时执行拒绝策略。
		如果当前线程池为空就新创建一个线程并执行。
		如果在第三步的判断为非运行状态，尝试新建线程，如果失败则执行拒绝策略。
		
		流程聊完了再来看看上文提到了几个核心参数应该如何配置呢？

		有一点是肯定的，线程池肯定是不是越大越好。

		通常我们是需要根据这批任务执行的性质来确定的。

			IO 密集型任务：由于线程并不是一直在运行，所以可以尽可能的多配置线程，比如 CPU 个数 * 2
			CPU 密集型任务（大量复杂的运算）应当分配较少的线程，比如 CPU 个数相当的大小。

		当然这些都是经验值，最好的方式还是根据实际情况测试得出最佳配置。
		
		有运行任务自然也有关闭任务，从上文提到的 5 个状态就能看出如何来关闭线程池。

		其实无非就是两个方法 shutdown()/shutdownNow()。

		但他们有着重要的区别：

			shutdown() 执行后停止接受新任务，会把队列的任务执行完毕。
			shutdownNow() 也是停止接受新任务，但会中断所有的任务，将线程池状态变为 stop。

			两个方法都会中断线程，用户可自行判断是否需要响应中断。

		shutdownNow() 要更简单粗暴，可以根据实际场景选择不同的方法。
		
	Spring Boot使用线程池
		使用Spring管理线程池
		```java
		@Configuration
		public class TreadPoolConfig {

			/**
			 * 消费队列线程
			 * @return
			 */
			@Bean(value = "consumerQueueThreadPool")
			public ExecutorService buildConsumerQueueThreadPool(){
				ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
						.setNameFormat("consumer-queue-thread-%d").build();

				ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
						new ArrayBlockingQueue<Runnable>(5),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

				return pool ;
			}

		}
		```
		使用时
		@Resource(name = "consumerQueueThreadPool")
		private ExecutorService consumerQueueThreadPool;

		@Override
		public void execute() {

			//消费队列
			for (int i = 0; i < 5; i++) {
				consumerQueueThreadPool.execute(new ConsumerQueueThread());
			}

		}
	监控线程池
		也可利用它 actuator 组件来做线程池的监控
		
	线程池隔离		
		如果我们很多业务都依赖于同一个线程池,当其中一个业务因为各种不可控的原因消耗了所有的线程，导致线程池全部占满。

		这样其他的业务也就不能正常运转了，这对系统的打击是巨大的。

		比如我们 Tomcat 接受请求的线程池，假设其中一些响应特别慢，线程资源得不到回收释放；线程池慢慢被占满，最坏的情况就是整个应用都不能提供服务。

		所以我们需要将线程池进行隔离。

		通常的做法是按照业务进行划分：
		比如下单的任务用一个线程池，获取数据的任务用另一个线程池。这样即使其中一个出现问题把线程池耗尽，那也不会影响其他的任务运行。
	总结

### 深入理解线程通信
	前言
		开发中不免会遇到需要所有子线程执行完毕通知主线程处理某些逻辑的场景。

		或者是线程 A 在执行到某个条件通知线程 B 执行某个操作。

		可以通过以下几种方式实现：
	
	等待通知机制
		等待通知模式是 Java 中比较经典的线程通信方式。
		两个线程通过对同一对象调用等待wait()和通知notify()方法来进行通信
		这里的线程 A 和线程 B 都对同一个对象 TwoThreadWaitNotify.class 获取锁，A 线程调用了同步对象的 wait() 方法释放了锁并进入 WAITING 状态。

		B 线程调用了 notify() 方法，这样 A 线程收到通知之后就可以从 wait() 方法中返回。

		这里利用了 TwoThreadWaitNotify.class 对象完成了通信。

		有一些需要注意:

			wait() 、notify()、notifyAll() 调用的前提都是获得了对象的锁(也可称为对象监视器)。
			调用 wait() 方法后线程会释放锁，进入 WAITING 状态，该线程也会被移动到等待队列中。
			调用 notify() 方法会将等待队列中的线程移动到同步队列中，线程状态也会更新为 BLOCKED
			从 wait() 方法返回的前提是调用 notify() 方法的线程释放锁，wait() 方法的线程获得锁。

		等待通知有着一个经典范式：
		
		线程 A 作为消费者：

			获取对象的锁。
			进入 while(判断条件)，并调用 wait() 方法。
			当条件满足跳出循环执行具体处理逻辑。

		线程 B 作为生产者:

			获取对象锁。
			更改与线程 A 共用的判断条件。
			调用 notify() 方法。

	join()
		在 t1.join() 时会一直阻塞到 t1 执行完毕，所以最终主线程会等待 t1 和 t2 线程执行完毕。
		在 join 线程完成后会调用 notifyAll() 方法，是在 JVM 实现中调用，所以这里看不出来。
	
	volatile共享内存
		这里的 flag 存放于主内存中，所以主线程和线程 A 都可以看到。
		flag 采用 volatile 修饰主要是为了内存可见性，
		
	CountDownLatch并发工具
		CountDownLatch 也是基于 AQS(AbstractQueuedSynchronizer) 实现的，更多实现参考 ReentrantLock 实现原理
		初始化一个 CountDownLatch 时告诉并发的线程，然后在每个线程处理完毕之后调用 countDown() 方法。
		该方法会将 AQS 内置的一个 state 状态 -1 。
		最终在主线程调用 await() 方法，它会阻塞直到 state == 0 的时候返回。
		
	CyclicBarrier并发工具
		CyclicBarrier 中文名叫做屏障或者是栅栏，也可以用于线程间通信。

		它可以等待 N 个线程都达到某个状态后继续运行的效果。

			首先初始化线程参与者。
			调用 await() 将会在所有参与者线程都调用之前等待。
			直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
		可以看出由于其中一个线程休眠了五秒，所有其余所有的线程都得等待这个线程调用 await() 。
		该工具可以实现 CountDownLatch 同样的功能，但是要更加灵活。
		甚至可以调用 reset() 方法重置 CyclicBarrier (需要自行捕获 BrokenBarrierException 处理) 然后重新执行。

	CountDownLatch（闭锁）与CyclicBarrier（栅格）
		CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。  
		CyclicBarrier : N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
		这样应该就清楚一点了，对于CountDownLatch来说，重点是那个“一个线程”, 是它在等待， 而另外那N的线程在把“某个事情”做完之后可以继续等待，可以终止。
		而对于CyclicBarrier来说，重点是那N个线程，他们之间任何一个没有完成，所有的线程都必须等待。
		
		CountDownLatch 是计数器, 线程完成一个就记一个, 就像 报数一样, 只不过是递减的。
		而CyclicBarrier更像一个水闸, 线程执行就想水流, 在水闸处都会堵住, 等到水满(线程到齐)了, 才开始泄流.

	线程相应中断
		可以采用中断线程的方式来通信，调用了 thread.interrupt() 方法其实就是将 thread 中的一个标志属性置为了 true。

		并不是说调用了该方法就可以中断线程，如果不对这个标志进行响应其实是没有什么作用(这里对这个标志进行了判断)。

		但是如果抛出了 InterruptedException 异常，该标志就会被 JVM 重置为 false。
	
	线程池awaitTermination()方法
		如果是用线程池来管理线程，可以使用以下方式来让主线程等待线程池中所有任务执行完毕:
		使用这个 awaitTermination() 方法的前提需要关闭线程池，如调用了 shutdown() 方法。

		调用了 shutdown() 之后线程池会停止接受新任务，并且会平滑的关闭线程池中现有的任务。
	
	管道通信
		Java 虽说是基于内存通信的，但也可以使用管道通信。

		需要注意的是，输入流和输出流需要首先建立连接。这样线程 B 就可以收到线程 A 发出的消息了。

		实际开发中可以灵活根据需求选择最适合的线程通信方式。









