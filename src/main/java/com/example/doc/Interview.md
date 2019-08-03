一、Java基础

1. String类为什么是final的。
	1.1 为了实现字符串池，节省资源
	1.2 线程安全
	1.3 为了实现String可以创建HashCode不可变性
	## final修饰数组，仅仅是引用地址不可变（指定数组指向内存空间固定），并不代表数组本身不可变
2. HashMap的源码，实现原理，底层结构。

JDK1.7
总的来说，HashMap就是数组+链表(哈希表或者散列函数)的组合实现，每个数组元素存储一个链表的头结点，本质上来说是哈希表“拉链法”的实现。

HashMap的链表元素对应的是一个静态内部类Entry，Entry主要包含key，value，next三个元素

主要有put和get方法，put的原理是，通过hash&length-1计算index，此时记作Entry[index]=该元素。如果index相同

就是新入的元素放置到Entry[index]，原先的元素记作Entry[index].next

get就比较简单了，先遍历数组，再遍历链表元素。

null key总是放在Entry数组的第一个元素（允许存放一个空键值对的原因）

解决hash冲突的方法：链地址法

再散列rehash的过程：确定容量超过目前哈希表的容量，重新调整table 的容量大小，当超过容量的最大值时

HashMap的容量size乘以负载因子[默认0.75] = threshold 将会触发扩容

JDK1.7与JDK1.8中HashMap的不同
（1）JDK1.7用的是头插法，而JDK1.8及之后使用的都是尾插法，那么他们为什么要这样做呢？因为JDK1.7是用单链表进行的纵向延伸，当采用头插法时会容易出现逆序且环形链表死循环问题。但是在JDK1.8之后是因为加入了红黑树使用尾插法，能够避免出现逆序且链表死循环的问题。
（2）扩容后数据存储位置的计算方式也不一样：1. 在JDK1.7的时候是直接用hash值和需要扩容的二进制数进行&（这里就是为什么扩容的时候为啥一定必须是2的多少次幂的原因所在，因为如果只有2的n次幂的情况时最后一位二进制数才一定是1，这样能最大程度减少hash碰撞）（hash值 & length-1）

JDK1.7中CurrentHashMap
HashMap、CurrentHashMap 的实现原理基本都是BAT面试必考内容，阿里P8架构师谈：深入探讨HashMap的底层结构、原理、扩容机制深入谈过hashmap的实现原理以及在JDK 1.8的实现区别，今天主要谈CurrentHashMap的实现原理，以及在JDK1.7和1.8的区别。

内容目录：1.哈希表2.ConcurrentHashMap与HashMap、HashTable的区别3.CurrentHashMap在JDK1.7和JDK1.8版本的区别

哈希表

1.介绍

哈希表就是一种以 键-值(key-indexed) 存储数据的结构，我们只要输入待查找的值即key，即可查找到其对应的值。

哈希的思路很简单，如果所有的键都是整数，那么就可以使用一个简单的无序数组来实现：将键作为索引，值即为其对应的值，这样就可以快速访问任意键的值。这是对于简单的键的情况，我们将其扩展到可以处理更加复杂的类型的键。

2.链式哈希表

链式哈希表从根本上说是由一组链表构成。每个链表都可以看做是一个“桶”，我们将所有的元素通过散列的方式放到具体的不同的桶中。插入元素时，首先将其键传入一个哈希函数（该过程称为哈希键），函数通过散列的方式告知元素属于哪个“桶”，然后在相应的链表头插入元素。查找或删除元素时，用同们的方式先找到元素的“桶”，然后遍历相应的链表，直到发现我们想要的元素。因为每个“桶”都是一个链表，所以链式哈希表并不限制包含元素的个数。然而，如果表变得太大，它的性能将会降低。

3.应用场景

我们熟知的缓存技术（比如redis、memcached）的核心其实就是在内存中维护一张巨大的哈希表，还有大家熟知的HashMap、CurrentHashMap等的应用。

ConcurrentHashMap与HashMap等的区别

1.HashMap

我们知道HashMap是线程不安全的，在多线程环境下，使用Hashmap进行put操作会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。

2.HashTable

HashTable和HashMap的实现原理几乎一样，差别无非是

HashTable不允许key和value为null HashTable是线程安全的但是HashTable线程安全的策略实现代价却太大了，简单粗暴，get/put所有相关操作都是synchronized的，这相当于给整个哈希表加了一把大锁。

多线程访问时候，只要有一个线程访问或操作该对象，那其他线程只能阻塞，相当于将所有的操作串行化，在竞争激烈的并发场景中性能就会非常差。

3.ConcurrentHashMap

主要就是为了应对hashmap在并发环境下不安全而诞生的，ConcurrentHashMap的设计与实现非常精巧，大量的利用了volatile，final，CAS等lock-free技术来减少锁竞争对于性能的影响。

我们都知道Map一般都是数组+链表结构（JDK1.8该为数组+红黑树）。

ConcurrentHashMap避免了对全局加锁改成了局部加锁操作，这样就极大地提高了并发环境下的操作速度，由于ConcurrentHashMap在JDK1.7和1.8中的实现非常不同，接下来我们谈谈JDK在1.7和1.8中的区别。

JDK1.7版本的CurrentHashMap的实现原理

在JDK1.7中ConcurrentHashMap采用了数组+Segment+分段锁的方式实现。

1.Segment(分段锁)

ConcurrentHashMap中的分段锁称为Segment，它即类似于HashMap的结构，即内部拥有一个Entry数组，数组中的每个元素又是一个链表,同时又是一个ReentrantLock（Segment继承了ReentrantLock）。

2.内部结构

ConcurrentHashMap使用分段锁技术，将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问，能够实现真正的并发访问。如下图是ConcurrentHashMap的内部结构图：

从上面的结构我们可以了解到，ConcurrentHashMap定位一个元素的过程需要进行两次Hash操作。

第一次Hash定位到Segment，第二次Hash定位到元素所在的链表的头部。

3.该结构的优劣势

坏处

这一种结构的带来的副作用是Hash的过程要比普通的HashMap要长

好处

写操作的时候可以只对元素所在的Segment进行加锁即可，不会影响到其他的Segment，这样，在最理想的情况下，ConcurrentHashMap可以最高同时支持Segment数量大小的写操作（刚好这些写操作都非常平均地分布在所有的Segment上）。

所以，通过这一种结构，ConcurrentHashMap的并发能力可以大大的提高。

JDK1.8版本的CurrentHashMap的实现原理

JDK8中ConcurrentHashMap参考了JDK8 HashMap的实现，采用了数组+链表+红黑树的实现方式来设计，内部大量采用CAS操作，这里我简要介绍下CAS。

CAS是compare and swap的缩写，即我们所说的比较交换。cas是一种基于锁的操作，而且是乐观锁。在java中锁分为乐观锁和悲观锁。悲观锁是将资源锁住，等一个之前获得锁的线程释放锁之后，下一个线程才可以访问。而乐观锁采取了一种宽泛的态度，通过某种方式不加锁来处理资源，比如通过给记录加version来获取数据，性能较悲观锁有很大的提高。

CAS 操作包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)。如果内存地址里面的值和A的值是一样的，那么就将内存里面的值更新成B。CAS是通过无限循环来获取数据的，若果在第一轮循环中，a线程获取地址里面的值被b线程修改了，那么a线程需要自旋，到下次循环才有可能机会执行。

JDK8中彻底放弃了Segment转而采用的是Node，其设计思想也不再是JDK1.7中的分段锁思想。

Node：保存key，value及key的hash值的数据结构。其中value和next都用volatile修饰，保证并发的可见性。

classNode<K,V>implementsMap.Entry<K,V>{finalint hash;final K key;volatile V val;volatileNode<K,V> next;//... 省略部分代码}</strong>

Java8 ConcurrentHashMap结构基本上和Java8的HashMap一样，不过保证线程安全性。

在JDK8中ConcurrentHashMap的结构，由于引入了红黑树，使得ConcurrentHashMap的实现非常复杂，我们都知道，红黑树是一种性能非常好的二叉查找树，其查找性能为O（logN），但是其实现过程也非常复杂，而且可读性也非常差，DougLea的思维能力确实不是一般人能比的，早期完全采用链表结构时Map的查找时间复杂度为O（N），JDK8中ConcurrentHashMap在链表的长度大于某个阈值的时候会将链表转换成红黑树进一步提高其查找性能。

总结

其实可以看出JDK1.8版本的ConcurrentHashMap的数据结构已经接近HashMap，相对而言，ConcurrentHashMap只是增加了同步的操作来控制并发，从JDK1.7版本的ReentrantLock+Segment+HashEntry，到JDK1.8版本中synchronized+CAS+HashEntry+红黑树。

1.数据结构：取消了Segment分段锁的数据结构，取而代之的是数组+链表+红黑树的结构。
2.保证线程安全机制：JDK1.7采用segment的分段锁机制实现线程安全，其中segment继承自ReentrantLock。JDK1.8采用CAS+Synchronized保证线程安全。
3.锁的粒度：原来是对需要进行数据操作的Segment加锁，现调整为对每个数组元素加锁（Node）。
4.链表转化为红黑树:定位结点的hash算法简化会带来弊端,Hash冲突加剧,因此在链表节点数量大于8时，会将链表转化为红黑树进行存储。
5.查询时间复杂度：从原来的遍历链表O(n)，变成遍历红黑树O(logN)。

高并发设计方案：
	* 缓存
	* 消息队列
	* 高峰削流
	* 异地容灾
	* 负载均衡
	* 分库分表
	* NoSQL
	* 微服务

3. 说说你知道的几个Java集合类：list、set、queue、map实现类咯。。。
	
queue的实现类： 
AbstractQueue, 
ArrayBlockingQueue, 
ConcurrentLinkedQueue, 
LinkedBlockingQueue, 
DelayQueue, 
LinkedList, 
PriorityBlockingQueue, 
PriorityQueue,
ArrayDqueue

4. 描述一下ArrayList和LinkedList各自实现和区别
 1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。 
 2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。 
 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。 

5. Java中的队列都有哪些，有什么区别。

Queue： 基本上，一个队列就是一个先入先出（FIFO）的数据结构

Queue接口与List、Set同一级别，都是继承了Collection接口。LinkedList实现了Deque接 口。

Queue的实现
1、没有实现的阻塞接口的LinkedList： 实现了java.util.Queue接口和java.util.AbstractQueue接口
　　内置的不阻塞队列： PriorityQueue 和 ConcurrentLinkedQueue
　　PriorityQueue 和 ConcurrentLinkedQueue 类在 Collection Framework 中加入两个具体集合实现。 
　　PriorityQueue 类实质上维护了一个有序列表。加入到 Queue 中的元素根据它们的天然排序（通过其 java.util.Comparable 实现）或者根据传递给构造函数的 java.util.Comparator 实现来定位。
　　ConcurrentLinkedQueue 是基于链接节点的、线程安全的队列。并发访问不需要同步。因为它在队列的尾部添加元素并从头部删除它们，所以只要不需要知道队列的大 小，　　　　    　　ConcurrentLinkedQueue 对公共集合的共享访问就可以工作得很好。收集关于队列大小的信息会很慢，需要遍历队列。


2)实现阻塞接口的：
　　java.util.concurrent 中加入了 BlockingQueue 接口和五个阻塞队列类。它实质上就是一种带有一点扭曲的 FIFO 数据结构。不是立即从队列中添加或者删除元素，线程执行操作阻塞，直到有空间或者元素可用。
五个队列所提供的各有不同：
　　* ArrayBlockingQueue ：一个由数组支持的有界队列。
　　* LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。
　　* PriorityBlockingQueue ：一个由优先级堆支持的无界优先级队列。
　　* DelayQueue ：一个由优先级堆支持的、基于时间的调度队列。
　　* SynchronousQueue ：一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制。

6. 反射中，Class.forName和classloader的区别

class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。
而classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。

Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象

7. Java7、Java8的新特性(baidu问的,好BT)


java7有一些比较重要的更新，如异常处理增加了被抑制的异常、捕获多异常、try-with-resource自动释放资源等，还有应用了G1垃圾回收器、switch可以使用String类型、泛型自动判断类型、fork/join框架把任务细分并使用多处理器处理、支持二进制字面量等

毫无疑问，Java 8是自Java 5（2004年）发布以来Java语言最大的一次版本升级，Java 8带来了很多的新特性，比如编译器、类库、开发工具和JVM（Java虚拟机）。在这篇教程中我们将会学习这些新特性，并通过真实例子演示说明它们适用的场景。

最最重要的是Java8开始支持了Lambda表达式

8. Java数组和链表两种结构的操作效率，在哪些情况下(从开头开始，从结尾开始，从中间开始)，哪些操作(插入，查找，删除)的效率高

9. Java内存泄露的问题调查定位：jmap，jstack的使用等等
	jmap 查看内存
	jstack 查看线程
	jstat 性能分析
	9.1 为什么会发生内存泄漏
	java 如何检测内在泄漏呢？我们需要一些工具进行检测，并发现内存泄漏问题，不然很容易发生down机问题。

	编写java程序最为方便的地方就是我们不需要管理内存的分配和释放，一切由jvm来进行处理，当java对象不再被应用时，等到堆内存不够用时，jvm会进行垃圾回收，清除这些对象占用的堆内存空间，如果对象一直被应用，jvm无法对其进行回收，创建新的对象时，无法从Heap中获取足够的内存分配给对象，这时候就会导致内存溢出。而出现内存泄露的地方，一般是不断的往容器中存放对象，而容器没有相应的大小限制或清除机制。容易导致内存溢出。
	当服务器应用占用了过多内存的时候，如何快速定位问题呢？现在，Eclipse MAT的出现使这个问题变得非常简单。EclipseMAT是著名的SAP公司贡献的一个工具，可以在Eclipse网站下载到它，完全免费的。
	要定位问题，首先你需要获取服务器jvm某刻内存快照。jdk自带的jmap可以获取内存某一时刻的快照，导出为dmp文件后，就可以用Eclipse MAT来分析了，找出是那个对象使用内存过多。

	9.2 内存泄漏的现象
	
	9.3 发现内存泄漏

10. string、stringbuilder、stringbuffer区别

11. hashtable和hashmap的区别

    HashMap是非线程同步的，HashTable是线程同步的。
    HashMap允许null作为键或者值，HashTable不允许
    HashTable中有个一个contains方法，HashMap去掉了此方法
    效率上来讲，HashMap因为是非线程安全的，因此效率比HashTable高
    hashTable继承Dictionary，而HashMap继承Abstract


13 .异常的结构，运行时异常和非运行时异常，各举个例子
	Throwable throwable; 
	所有异常的父类
	
	Error error; 程序无法处理的错误，表示运行应用程序中较严重的问题。大多数错误与代码编写者执行的操作无关，而表示代码运行时JVM   （Java虚拟机）出现的问题。例如。Java虚拟机运行错误（Virtual MachineError），当JVM不再有继续执行操作所需要的内存资源时，将出现  OutOfMemoryError 。这些异常发生时，Java虚拟机（JVM）一般会选择线程终止。
	
	Exception exception;
	程序本身可以处理的异常。 Exception可以分为checked exceptions和unchecked exceptions:
	unchecked exceptions(运行时异常)都是RuntimeException类及其子类异常，就是我们在开发中测试功能时程序终止，控制台出现的异常，比如：
	NullPointerException(空指针异常)、 
	IndexOutOfBoundsException(下标越界异常) 
	StringIndexOutOfBoundsException
	ArrayIndexOutOfBoundsException
	ClassCastException(类转换异常) 
	ArrayStoreException(数据存储异常，操作数组时类型不一致) 
	IllegalArgumentException
	BufferOverflowException异常
	NumberFormatException
	
	checked   exceptions，非运行时异常（编译异常）：是RuntimeException以外的异常，类型上都属于Exception类及其子类。从程序语法角度讲是必须进行处理的异常，如果不处理，程序就不能编译通过。如IOException、SQLException等以及用户自定义的Exception异常，一般情况下不自定义检查异常。
	FileNotFoundException
	ParseException
	ClassNotFoundException
	CloneNotSupportedException
	InstantiationException
	InterruptedException
	NoSuchMethodException
	NoSuchFieldException
	

14. String a= “abc” String b = “abc” String c = new String(“abc”) String d = “ab” + “c” .他们之间用 == 比较的结果

     编译时优化

15. String 类的常用方法

16. Java 的引用类型有哪几种

  对象的强、软、弱和虚引用（四种引用）

在JDK 1.2以前的版本中，若一个对象不被任何变量引用，那么程序就无法再使用这个对象。也就是说，只有对象处于可触及（reachable）状态，程序才能使用它。从JDK 1.2版本开始，把对象的引用分为4种级别，从而使程序能更加灵活地控制对象的生命周期。这4种级别由高到低依次为：强引用、软引用、弱引用和虚引用。
⑴强引用（StrongReference）

强引用是使用最普遍的引用。如果一个对象具有强引用，那垃圾回收器绝不会回收它。当内存空间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足的问题。  ps：强引用其实也就是我们平时A a = new A()这个意思。
⑵软引用（SoftReference）
如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存（下文给出示例）。
软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收器回收，Java虚拟机就会把这个软引用加入到与之关联的引用队列中。
⑶弱引用（WeakReference）
弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。
弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
⑷虚引用（PhantomReference）
“虚引用”顾名思义，就是形同虚设，与其他几种引用都不同，虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
虚引用主要用来跟踪对象被垃圾回收器回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列 （ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之 关联的引用队列中。

ReferenceQueue queue = new ReferenceQueue ();

PhantomReference pr = new PhantomReference (object, queue); 
程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动。

17. 抽象类和接口的区别

18. java的基础类型和字节大小。

19. Hashtable,HashMap,ConcurrentHashMap 底层实现原理与线程安全问题（建议熟悉 jdk 源码，才能从容应答）

20. 如果不让你用Java Jdk提供的工具，你自己实现一个Map，你怎么做。说了好久，说了HashMap源代码，如果我做，就会借鉴HashMap的原理，说了一通HashMap实现

21. Hash冲突怎么办？哪些解决散列冲突的方法？

开放地址法  插入元素时，如果发生冲突，算法会简单的从该槽位置向后循环遍历hash表，直到找到表中的下一个空槽，并将该元素放入该槽中（会导致相同hash值的元素挨在一起和其他hash值对应的槽被占用）。查找元素时，首先散列值所指向的槽，如果没有找到匹配，则继续从该槽遍历hash表，直到：（1）找到相应的元素；（2）找到一个空槽，指示查找的元素不存在，（所以不能随便删除元素）；（3）整个hash表遍历完毕（指示该元素不存在并且hash表是满的）

拉链法（hashMap采用的是该种方法）
再散列（双重散列，多重散列） 
   建立一个公共溢出区

22. HashMap冲突很厉害，最差性能，你会怎么解决?从O（n）提升到log（n）咯，用二叉排序树的思路说了一通

23. rehash

24. hashCode() 与 equals() 生成算法、方法怎么重写

如何重写equals()方法
如果你决定要重写equals()方法，那么你一定要明确这么做所带来的风险，并确保自己能写出一个健壮的equals()方法．一定要注意的一点是，在重写equals()后，一定要重写hashCode()方法．具体原因稍候再进行说明．
我们先看看 JavaSE 7 Specification中对equals()方法的说明：

    It is reflexive: for any non-null reference value x, x.equals(x) should return true.
    It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
    It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
    It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
    For any non-null reference value x, x.equals(null) should return false.

这段话用了很多离散数学中的术数．简单说明一下：
1. 自反性：A.equals(A)要返回true.
2. 对称性：如果A.equals(B)返回true, 则B.equals(A)也要返回true.
3. 传递性：如果A.equals(B)为true, B.equals(C)为true, 则A.equals(C)也要为true. 说白了就是 A = B , B = C , 那么A = C.
4. 一致性：只要A,B对象的状态没有改变，A.equals(B)必须始终返回true.
5. A.equals(null) 要返回false.

相信只要不是专业研究数学的人，都对上面的东西不来电．在实际应用中我们只需要按照一定的步骤重写equals()方法就可以了．为了说明方便，我们先定义一个程序员类(Coder):
[java] view plain copy

    class Coder {  
        private String name;  
        private int age;  
        // getters and setters  
    } 

我们想要的是，如果２个程序员对象的name和age都是相同的，那么我们就认为这两个程序员是一个人．这时候我们就要重写其equals()方法．因为默认的equals()实际是判断两个引用是否指向内在中的同一个对象，相当于 == ．　重写时要遵循以下三步：
1. 判断是否等于自身.
[java] view plain copy

    if(other == this)  
                return true;  

2. 使用instanceof运算符判断 other 是否为Coder类型的对象.
[java] view plain copy

    if(!(other instanceof Coder))  
                return false;  

3. 比较Coder类中你自定义的数据域，name和age，一个都不能少.
[java] view plain copy

    Coder o = (Coder)other;  
            return o.name.equals(name) && o.age == age;  

看到这有人可能会问，第3步中有一个强制转换，如果有人将一个Integer类的对象传到了这个equals中，那么会不会扔ClassCastException呢？这个担心其实是多余的．因为我们在第二步中已经进行了instanceof 的判断，如果other是非Coder对象，甚至other是个null, 那么在这一步中都会直接返回false, 从而后面的代码得不到执行的机会．
上面的三步也是＜Effective Java＞中推荐的步骤，基本可保证万无一失．
如何重写hashCode()方法
在JavaSE 7 Specification中指出，＂Note that it is generally necessary to override the hashCode method whenever this method（equals） is overridden, so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.＂

如果你重写了equals()方法，那么一定要记得重写hashCode()方法．我们在大学计算机数据结构课程中都已经学过哈希表(hash table)了，hashCode()方法就是为哈希表服务的．
当我们在使用形如HashMap, HashSet这样前面以Hash开头的集合类时，hashCode()就会被隐式调用以来创建哈希映射关系．稍后我们再对此进行说明．这里我们先重点关注一下hashCode()方法的写法．

＜Effective Java＞中给出了一个能最大程度上避免哈希冲突的写法，但我个人认为对于一般的应用来说没有必要搞的这么麻烦．如果你的应用中HashSet中需要存放上万上百万个对象时，那你应该严格遵循书中给定的方法．如果是写一个中小型的应用，那么下面的原则就已经足够使用了：
要保证Coder对象中所有的成员都能在hashCode中得到体现．
对于本例，我们可以这么写：
[java] view plain copy

    @Override  
        public int hashCode() {  
            int result = 17;  
            result = result * 31 + name.hashCode();  
            result = result * 31 + age;  
              
            return result;  
        }  


其中int result = 17你也可以改成20, 50等等都可以．看到这里我突然有些好奇，想看一下String类中的hashCode()方法是如何实现的．查文档知：

"Returns a hash code for this string. The hash code for a String object is computed as

     s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     

using int arithmetic, where s[i] is the ith character of the string, n is the length of the string, and ^ indicates exponentiation. (The hash value of the empty string is zero.)"
对每个字符的ASCII码计算n - 1次方然后再进行加和，可见Sun对hashCode的实现是很严谨的. 这样能最大程度避免２个不同的String会出现相同的hashCode的情况．

重写equals()而不重写hashCode()的风险
在Oracle的Hash Table实现中引用了bucket的概念．如下图所示：


从上图中可以看出，带bucket的hash table大致相当于哈希表与链表的结合体．即在每个bucket上会挂一个链表，链表的每个结点都用来存放对象．Java通过hashCode()方法来确定某个对象应该位于哪个bucket中，然后在相应的链表中进行查找．在理想情况下，如果你的hashCode()方法写的足够健壮，那么每个bucket将会只有一个结点，这样就实现了查找操作的常量级的时间复杂度．即无论你的对象放在哪片内存中，我都可以通过hashCode()立刻定位到该区域，而不需要从头到尾进行遍历查找．这也是哈希表的最主要的应用．

如：
当我们调用HashSet的put(Object o)方法时，首先会根据o.hashCode()的返回值定位到相应的bucket中，如果该bucket中没有结点，则将 o 放到这里，如果已经有结点了, 则把 o 挂到链表末端．同理，当调用contains(Object o)时，Java会通过hashCode()的返回值定位到相应的bucket中，然后再在对应的链表中的结点依次调用equals()方法来判断结点中的对象是否是你想要的对象．

下面我们通过一个例子来体会一下这个过程：
我们先创建２个新的Coder对象：
[java] view plain copy

    Coder c1 = new Coder("bruce", 10);  
            Coder c2 = new Coder("bruce", 10);  


假定我们已经重写了Coder的equals()方法而没有重写hashCode()方法：
[java] view plain copy

    @Override  
        public boolean equals(Object other) {  
            System.out.println("equals method invoked!");  
              
            if(other == this)  
                return true;  
            if(!(other instanceof Coder))  
                return false;  
              
            Coder o = (Coder)other;  
            return o.name.equals(name) && o.age == age;  
        }  


然后我们构造一个HashSet，将c1对象放入到set中：
[java] view plain copy

    Set<Coder> set = new HashSet<Coder>();  
            set.add(c1);  


再执行：
[java] view plain copy

    System.out.println(set.contains(c2));  


我们期望contains(c2)方法返回true, 但实际上它返回了false.
c1和c2的name和age都是相同的，为什么我把c1放到HashSet中后，再调用contains(c2)却返回false呢？这就是hashCode()在作怪了．因为你没有重写hashCode()方法，所以HashSet在查找c2时，会在不同的bucket中查找．比如c1放到05这个bucket中了，在查找c2时却在06这个bucket中找，这样当然找不到了．因此，我们重写hashCode()的目的在于，在A.equals(B)返回true的情况下，A, B 的hashCode()要返回相同的值．
我让hashCode()每次都返回一个固定的数行吗
有人可能会这样重写：
[java] view plain copy

    @Override  
        public int hashCode() {  
            return 10;  
      
        } 

如果这样的话，HashMap, HashSet等集合类就失去了其 "哈希的意义"．用<Effective Java>中的话来说就是，哈希表退化成了链表．如果hashCode()每次都返回相同的数，那么所有的对象都会被放到同一个bucket中，每次执行查找操作都会遍历链表，这样就完全失去了哈希的作用．所以我们最好还是提供一个健壮的hashCode()为妙．

二、Java IO

1. 讲讲IO里面的常见类，字节流、字符流、接口、实现类、方法阻塞。

2. 讲讲NIO。

3. String 编码UTF-8 和GBK的区别?

4. 什么时候使用字节流、什么时候使用字符流?

5. 递归读取文件夹下的文件，代码怎么实现

三、Java Web

1. session和cookie的区别和联系，session的生命周期，多个服务部署时session管理。

2. servlet的一些相关问题

3. webservice相关问题

4. jdbc连接，forname方式的步骤，怎么声明使用一个事务。举例并具体代码

5. 无框架下配置web.xml的主要配置内容

6. jsp和servlet的区别

四、JVM

1. Java的内存模型以及GC算法

2. jvm性能调优都做了什么

3. 介绍JVM中7个区域，然后把每个区域可能造成内存的溢出的情况说明

4. 介绍GC 和GC Root不正常引用。

5. 自己从classload 加载方式，加载机制说开去，从程序运行时数据区，讲到内存分配，讲到String常量池，讲到JVM垃圾回收机制，算法，hotspot。反正就是各种扩展

6. jvm 如何分配直接内存， new 对象如何不分配在堆而是栈上，常量池解析

7. 数组多大放在 JVM 老年代（不只是设置 PretenureSizeThreshold ，问通常多大，没做过一问便知）

8. 老年代中数组的访问方式

9. GC 算法，永久代对象如何 GC ， GC 有环怎么处理

10. 谁会被 GC ，什么时候 GC

11. 如果想不被 GC 怎么办

12. 如果想在 GC 中生存 1 次怎么办

五、开源框架

1. hibernate和ibatis的区别

2. 讲讲mybatis的连接池。

3. spring框架中需要引用哪些jar包，以及这些jar包的用途

4. springMVC的原理

5. springMVC注解的意思

6. spring中beanFactory和ApplicationContext的联系和区别

 BeanFactory特点
BeanFactory常用的实现类是DefaultListableBeanFactory，调用者只需要使用getBean()方法就可以获得指定的引用，无须关心Bean的实例化过程。创建Spring容器的实例时，必须提供Spring容器管理的Bean的详细配置信息。Spring的配置信息通常采用XML配置文件来设置，因此，创建BeanFactory实例时，应该提供XML配置文件作为参数。XML配置文件通常使用Resource对象传入。

Resource isr = new ClassPathResource("beans.xml");
//Resource isr = new FileSystemResource("beans.xml");
DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
new XmlBeanDefinitionReader(beanFactory).loadBeanDefinition(isr);

ApplicationContext特点
ApplicationContext常用的实现类是FileSystemXmlApplicationContext、ClassPathXmlApplicationContext和AnnotationConfigApplicationContext。如果在Web应用中使用Spring容器，则通常使用XmlWebApplicationContext、AnnotationConfigApplicationContext两个实现类。如果需要使用多个XML配置文件创建Spring容器，可以使用FileSystemXmlApplicationContext或者是ClassPathXmlApplicationContext。
除了提供BeanFactory所支持的所有功能外，ApplicationContext还有额外的功能

    默认初始化所有的Singleton，也可以通过配置取消预初始化。
    继承MessageSource，因此支持国际化。
    资源访问，比如访问URL和文件。
    事件机制。
    同时加载多个配置文件。
    以声明式方式启动并创建Spring容器。

由于ApplicationContext会预先初始化所有的Singleton Bean，于是在系统创建前期会有较大的系统开销，但一旦ApplicationContext初始化完成，程序后面获取Singleton Bean实例时候将有较好的性能。也可以为bean设置lazy-init属性为true，即Spring容器将不会预先初始化该bean。

7. spring注入的几种方式（循环注入）

8. spring如何实现事物管理的

 set注入(通常也叫属性注入)，构造函数注入，接口注入(这个现在基本不用)，注解注入(@Autowire)

9. springIOC

10. spring AOP的原理

11. hibernate中的1级和2级缓存的使用方式以及区别原理（Lazy-Load的理解）

 

12. Hibernate的原理体系架构，五大核心接口，Hibernate对象的三种状态转换，事务管理。

六、多线程

1. Java创建线程之后，直接调用start()方法和run()的区别

2. 常用的线程池模式以及不同线程池的使用场景

3. newFixedThreadPool此种线程池如果线程数达到最大值后会怎么办，底层原理。

4. 多线程之间通信的同步问题，synchronized锁的是对象，衍伸出和synchronized相关很多的具体问题，例如同一个类不同方法都有synchronized锁，一个对象是否可以同时访问。或者一个类的static构造方法加上synchronized之后的锁的影响。

5. 了解可重入锁的含义，以及Lock 和synchronized的区别

1. lock是一个接口，而synchronized是java的一个关键字，synchronized是内置的语言实现；（具体实现上的区别在《Java虚拟机》中有讲解底层的CAS不同，以前有读过现在又遗忘了。）
2. synchronized在发生异常时候会自动释放占有的锁，因此不会出现死锁；而lock发生异常时候，不会主动释放占有的锁，必须手动unlock来释放锁，可能引起死锁的发生。（所以最好将同步代码块用try catch包起来，finally中写入unlock，避免死锁的发生。）
3. lock等待锁过程中可以用interrupt来终端等待，而synchronized只能等待锁的释放，不能响应中断；
4. lock可以通过trylock来知道有没有获取锁，而synchronized不能；
5. Lock可以提高多个线程进行读操作的效率。（可以通过readwritelock实现读写分离）

6. 同步的数据结构，例如concurrentHashMap的源码理解以及内部实现原理，为什么他是同步的且效率高

7. atomicinteger和Volatile等线程安全操作的关键字的理解和使用

8. 线程间通信，wait和notify

9. 定时线程的使用

10. 场景：在一个主线程中，要求有大量(很多很多)子线程执行完之后，主线程才执行完成。多种方式，考虑效率。

11. 进程和线程的区别

12. 什么叫线程安全？举例说明

13. 线程的几种状态

14. 并发、同步的接口或方法

15. HashMap 是否线程安全，为何不安全。 ConcurrentHashMap，线程安全，为何安全。底层实现是怎么样的。

16. J.U.C下的常见类的使用。 ThreadPool的深入考察； BlockingQueue的使用。（take，poll的区别，put，offer的区别）；原子类的实现。

17. 简单介绍下多线程的情况，从建立一个线程开始。然后怎么控制同步过程，多线程常用的方法和结构

18. volatile的理解

19. 实现多线程有几种方式，多线程同步怎么做，说说几个线程里常用的方法

七、网络通信

1. http是无状态通信，http的请求方式有哪些，可以自己定义新的请求方式么。

2. socket通信，以及长连接，分包，连接异常断开的处理。

3. socket通信模型的使用，AIO和NIO。

4. socket框架netty的使用，以及NIO的实现原理，为什么是异步非阻塞。

5. 同步和异步，阻塞和非阻塞。

6. OSI七层模型，包括TCP,IP的一些基本知识

7. http中，get post的区别

8. 说说http,tcp,udp之间关系和区别。

9. 说说浏览器访问www.taobao.com，经历了怎样的过程。

10. HTTP协议、  HTTPS协议，SSL协议及完整交互过程；

11. tcp的拥塞，快回传，ip的报文丢弃

12. https处理的一个过程，对称加密和非对称加密

13. head各个特点和区别

14. 说说浏览器访问www.taobao.com，经历了怎样的过程。

八、数据库MySql

1. MySql的存储引擎的不同

2. 单个索引、联合索引、主键索引

3. Mysql怎么分表，以及分表后如果想按条件分页查询怎么办(如果不是按分表字段来查询的话，几乎效率低下，无解)

4. 分表之后想让一个id多个表是自增的，效率实现

5. MySql的主从实时备份同步的配置，以及原理(从库读主库的binlog)，读写分离

6. 写SQL语句。。。

7. 索引的数据结构，B+树

8. 事务的四个特性，以及各自的特点（原子、隔离）等等，项目怎么解决这些问题

9. 数据库的锁：行锁，表锁；乐观锁，悲观锁

10. 数据库事务的几种粒度；

11. 关系型和非关系型数据库区别

九、设计模式

1. 单例模式：饱汉、饿汉。以及饿汉中的延迟加载,双重检查

2. 工厂模式、装饰者模式、观察者模式。

3. 工厂方法模式的优点（低耦合、高内聚，开放封闭原则）

十、算法

1. 使用随机算法产生一个数，要求把1-1000W之间这些数全部生成。（考察高效率，解决产生冲突的问题）

2. 两个有序数组的合并排序

3. 一个数组的倒序

4. 计算一个正整数的正平方根

5. 说白了就是常见的那些查找、排序算法以及各自的时间复杂度

6. 二叉树的遍历算法

7. DFS,BFS算法

9. 比较重要的数据结构，如链表，队列，栈的基本理解及大致实现。

10. 排序算法与时空复杂度（快排为什么不稳定，为什么你的项目还在用）

11. 逆波兰计算器

12. Hoffman 编码

13. 查找树与红黑树

十一、并发与性能调优

1. 有个每秒钟5k个请求，查询手机号所属地的笔试题(记得不完整，没列出)，如何设计算法?请求再多，比如5w，如何设计整个系统?

2. 高并发情况下，我们系统是如何支撑大量的请求的

3. 集群如何同步会话状态

4. 负载均衡的原理

5 .如果有一个特别大的访问量，到数据库上，怎么做优化（DB设计，DBIO，SQL优化，Java优化）

6. 如果出现大面积并发，在不增加服务器的基础上，如何解决服务器响应不及时问题“。

7. 假如你的项目出现性能瓶颈了，你觉得可能会是哪些方面，怎么解决问题。

8. 如何查找 造成 性能瓶颈出现的位置，是哪个位置照成性能瓶颈。

9. 你的项目中使用过缓存机制吗？有没用用户非本地缓存

十二、其他

1.常用的linux下的命令

Redis、Zookeeper、Kafka、MySQL

面试

1.事务的隔离级别

	Read uncommitted	
	Read committed		解决脏读
	Repeatable read		解决不可重复读
	Serializable		解决幻读
	
2.MySQL实现可重复读的原理

	使用的是一种叫MVCC的控制方式，即多版本并发控制，类似于乐观锁的一种实现方式。
	InnoDB在每行记录后面都保存两个隐藏的列，分别保存了这个行的创建时间和行的删除时间，这里存储的并不是实际的时间，而是系统版本号，当数据被修改时版本号加一，在读取事务开始，系统会给当前读事务一个版本号，事务会读取版本号《=当前版本号的数据，此时如果其他事务修改了这条数据，那么这条数据的版本号就加一，从而比当前读事务的版本号高，读事务自然读不到更新后的数据。

3.索引

	Myisam索引（非聚集索引）
		若以这个引擎创建数据库表Create table user （…..），它实际是生成三个文件：

		user.myi   索引文件     user.myd数据文件     user.frm数据结构类型。

		如下图：当我们执行  select \* from user where id = 1的时候，它的执行流程。

		(1)查看该表的myi文件有没有以id为索引的索引树。

		(2)根据这个id索引找到叶子节点的id值，从而得到它里面的数据地址。(叶子节点存的是索引和数据地址)。

		(3)根据数据地址去myd文件里面找到对应的数据返回出来。
		
	Innodb引擎(聚集索引)

	　　	若以这个引擎创建数据库表Create table user （…..），它实际是生成两个文件：

	　　	user.ibd   索引文件        user.frm数据结构类型

	　　	因为innodb引擎创建表默认就是以主键为索引，所以不需要myi文件。

		　　	下图为innodb表的结构图：很显然它与myisam最大的区别是将整条数据存在叶子节点，而不是地址。(叶子节点存的是主键索引和数据信息)

		　　	若此时，你在其他列创建索引例如name，它就会另外创建一个以name为索引的索引树，(叶子节点存的是索引和主键索引)。

	　　	你在执行select \* from user where name = ‘吴磊’，他的执行过程如下：

	　　　　	(1)找到name索引树

	　　　　	(2)根据name的值找到该树下叶子的name索引和主键值

	　　　　	(3)用主键值去主键索引树去叶子节点到该条数据信息
	加了索引之后能够大幅度的提高查询速度，但是索引也不是越多越好，一方面它会占用存储空间，另一方面它会使得写操作变得很慢。
	通常我们对查询次数比较频繁，值比较多的列才建索引。
　　	例如：select \* from user where sex = "女"， 这个就不需要建立索引，因为性别一共就两个值，查询本身就是比较快的。
　　　　select \* from user where user_id = 1995 ,这个就需要建立索引，因为user_id的值是非常多的。

	B+Tree的特性

　　	(1)由图能看出，单节点能存储更多数据，使得磁盘IO次数更少。

　　	(2)叶子节点形成有序链表，便于执行范围操作。

　　	(3)聚集索引中，叶子节点的data直接包含数据；非聚集索引中，叶子节点存储数据地址的指针。

4.数据库主从同步

	形式
		一主一从
		一主多从，提高系统的读性能
		多主一从，数据备份
		双主复制
		级联复制，多级复制，缓解主节点压力
	
	原理
		(1)mysql主从复制涉及到三个线程，一个运行在主节点（log dump thread），其余两个（I/O thread, SQL thread ）运行在从节点。
		(2)当从节点连接主节点时，主节点会创建一个log dump 线程，用于发送bin-log的内容。在读取bin-log中的操作时，此线程会对主节点上的bin-log加锁，当读取完成，甚至在发动给从节点之前，锁会被释放。
		(3)当从节点上执行`start slave`命令之后，从节点会创建一个I/O线程用来连接主节点，请求主库中更新的bin-log。I/O线程接收到主节点binlog dump 进程发来的更新之后，保存在本地relay-log中。
		(4)SQL线程负责读取relay log中的内容，解析成具体的操作并执行，最终保证主从数据的一致性。
		
5.用什么锁对象内存占用最小

6.Collections.sort()使用的排序算法
	
	归并排序

7.AQS

	AQS(AbstractQueuedSynchronizer)，AQS是JDK下提供的一套用于实现基于FIFO等待队列的阻塞锁和相关的同步器的一个同步框架。这个抽象类被设计为作为一些可用原子int值来表示状态的同步器的基类。如果你有看过类似 CountDownLatch 类的源码实现，会发现其内部有一个继承了 AbstractQueuedSynchronizer 的内部类 Sync。可见 CountDownLatch 是基于AQS框架来实现的一个同步器.类似的同步器在JUC下还有不少。

8.线程池原理及参数配置
	corePoolSize：线程池中的常驻核心线程数
	maximumPoolSize：线程池能够容纳同时执行的最大线程数，此值必须大于1
	keepAliveTime：多余的空闲线程存活时间。当前线程数量超过maximumPoolSize时，当空闲时间达到keepAliveTime时，多余空闲线程会被销毁直到只剩下corePoolSize个线程为止。
	unit：keepAliveTime的单位
	workQueue：任务队列，被提交但尚未执行的任务
	threadFactory：表示生成线程池中工作线程的线程工厂，用于创建线程，一般用默认的即可
	handler：决绝策略，表示当队列满了并且线程大于线程池的最大线程数（maximumPoolSize）

9.ThreadLocal

	ThreadLocal为解决多线程程序的并发问题提供了一种新的思路。使用这个工具类可以很简洁地编写出优美的多线程程序。

	当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
	从线程的角度看，目标变量就象是线程的本地变量，这也是类名中“Local”所要表达的意思。

10.Eureka和Zookeeper做服务发现的区别 consul

11.分布式限流有哪些方案

	(1)提供给业务方的controller层进行控制 guava的RateLimiter
	Java的delayqueue延迟队列实现
	Redis实现，存储两个Key，一个用于计时，一个用于计数，请求每调用一次，计数器增加1，若在计数器时间内计数器未超过阀值，则可以执行任务 配合lua脚本
	(2)Nginx前端限流
	(3)业务系统限流 客户端 服务端
	(4)数据库限流 力保数据库

12.线程池限流的缺陷是什么

13.项目中系统日志的处理

14.JVM模型及调优

15.JMM模型

16.垃圾回收机制

17.垃圾收集器

18.项目中的设计模式

	(1)策略模式根据不同的network_type,选择对应的Parser
	(2)观察者模式，applicationlistener
	(3)单例模式
	(4)代理模式
	(5)发布订阅模式

19.设计模式的原则

20.Tomcat的优化

21.锁的原理

22.Synchronized与ReentrantLock的区别

23.偏向锁、轻量级锁、重量级锁

24.能否从偏向锁直接升级为重量级锁

25.Java并发包都有哪些类，如何使用

26.Redis和Zookeeper如何实现分布式锁

27.Redis的数据类型，具体命令，如何取有序列表的前10个元素

28.数据库索引的使用，聚簇索引和非聚簇索引，没有主键，数据如何组织

29.B+树的原理，InnoDB引擎和MylSAM引擎的区别的使用场景

30.MySQL的分库分表

31.MQ的可靠性和顺序性

32.ES插入数据的原理

33.IO、并发、缓存、Redis、Zookeeper、分布式、JVM、数据库

34.Redis的单线程模型

35.开发新的API，需要考虑哪些方面：下边界处理、高可用、并发问题、可扩展性、幂等性、充实机制

36.Java线程与内核线程的关系，与进程的关系

37.为什么有并发、并发产生的根源、解决并发问题的一些理论、java中解决并发的方式，不同方式的用用成精

38.Redis的数据类型，每种数据类型的底层实现，跳表如何插入数据、如何扩容

39.HashMap的扩容规则和具体实现

40.CopyOnWrite

41.三次握手、四次挥手

42.写一个word-count用到哪些命令

43.CAS

44.CurrentHashMap的锁机制

45.Spring Cloud所有框架的整体流程图

46.找出有序数组中指定元素的出现次数

47.二叉查找树从小到大排序

48.16个瓶子1个有毒

面试：
1.ISP Refact
	使用缓存
	减少IO
	利用系统已有的机制
2.线程池隔离
	如果我们很多业务都依赖于同一个线程池,当其中一个业务因为各种不可控的原因消耗了所有的线程，导致线程池全部占满。

	这样其他的业务也就不能正常运转了，这对系统的打击是巨大的。

	比如我们 Tomcat 接受请求的线程池，假设其中一些响应特别慢，线程资源得不到回收释放；线程池慢慢被占满，最坏的情况就是整个应用都不能提供服务。

	所以我们需要将线程池进行隔离。

	通常的做法是按照业务进行划分：

    比如下单的任务用一个线程池，获取数据的任务用另一个线程池。这样即使其中一个出现问题把线程池耗尽，那也不会影响其他的任务运行。
3.HeapOOM Issue Fixed
	log显示heap outofmemory 
	无dump文件
	测试环境复现困难
	堆扩容至5G，初始值与最大值一直
	stable test时再次出现
	shell脚本调用出了问题，加缓存解决
	设置栈大小扩容至256K
	TPS数过低
	模拟调用CellDate的接口
	问题解决
4.使用到的设计模式
	单例模式 CSClient
	工厂方法 数据校验，根据不同的对象调用不同校验类的校验逻辑
	策略方法 Response数据的解析策略
	
口语面试：

1. Why do you choose our company to apply for a job?
	
	I wish to have a job in which I can make good use of my strengths and have further improvement. And your company meets all my requirements.
	
2. Have you got a clear idea about our company?

	Yes, I have purposefully done some homework in advance.
	
3. How long would you work here if you were admitted?

	I hope to grow with the company
	
4. Do you expect a high salary?

	In my mind, salary is not the most important thing.

Resume:

*Java语言
*设计模式
*编码习惯
*内存模型
*类加载机制
*GC原理
*JVM调优
*Spring AOP IOC
*Spring Boot MVC Mybatis JPA
*Spring Cloud Dubbo Zookeeper
*Consul
Mysql数据库
Netty Akka
Docker
Shell Python
Gradle Git	
	
基础知识部分
	进程和线程管理
	TCP和HTTP协议
	数据结构
	经典算法
	常用设计模式
	
OSI 7层模型
物理层
数据链路层
传输层
会话层
表示层
应用层

TCP/IP 5层模型
物理层
数据链路层
网络层
传输层
应用层	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	