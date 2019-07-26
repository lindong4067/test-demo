## Arithmetic
负数转二进制规律:

    1.取负数的绝对值的原码
    2.计算原码的反码
    3.对反码加一，获取补码
    
    例如：整数-1在计算机中如何表示
    1.先取1的原码:  00000000 00000000 00000000 00000001
    2.得反码       11111111 11111111 11111111 11111110
    3.得补码:      11111111 11111111 11111111 11111111

    1.^(亦或运算) 针对二进制，相同的为0，不同的为1
    2.&(与运算) 针对二进制，只要有一个为0，就为0
    3.<<(向左位移) 针对二进制，转换成二进制后向左移动位，后面用0补齐
    4.>>(向右位移) 针对二进制，转换成二进制后向右移动位，高位移入原来高位的值
    5.>>>(无符号右移)  无符号右移，忽略符号位，高位都以0补齐

## Collection
Set和List的区别

    1. Set 接口实例存储的是无序的，不重复的数据。List 接口实例存储的是有序的，可以重复的元素。

    2. Set检索效率低下，删除和插入效率高，插入和删除不会引起元素位置改变 <实现类有HashSet,TreeSet>。

    3. List和数组类似，可以动态增长，根据实际存储的数据的长度自动增长List的长度。查找元素效率高，插入删除效率低，因为会引起其他元素位置改变 <实现类有ArrayList,LinkedList,Vector> 。

```java
class Demo{
    //Elements只接受Number及其子类
    List<? extends Number> list1 = new ArrayList<>();
    
    //Elements只接受Number及其上层父类
    List<? super Number> list2 = new ArrayList<>();
}
```
## Concurrent

### 同步和异步:
 > 同步和异步是针对应用程序和内核的交互而言的，同步指的是用户进程触发IO 操作并等待或者轮询的去查看IO 操作是否就绪，而异步是指用户进程触发IO 操作以后便开始做自己的事情，而当IO 操作已经完成的时候会得到IO 完成的通知。

### 阻塞和非阻塞:
 > 阻塞和非阻塞是针对于进程在访问数据的时候，根据IO操作的就绪状态来采取的不同方式，说白了是一种读取或者写入操作方法的实现方式，阻塞方式下读取或者写入函数将一直等待，而非阻塞方式下，读取或者写入方法会立即返回一个状态值。
 
### Java 提供了三种创建线程的方法：

    通过实现 Runnable 接口；
    通过继承 Thread 类本身；
    通过 Callable 和 Future 创建线程。

### 通过 Callable 和 Future 创建线程

    1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
    2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
    3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
    4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。

### 创建线程的三种方式的对比

    1. 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
    2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。

### CAS
    
    概念：
    1.全称compare and swap，一个CPU原子指令，在硬件层面实现的机制，体现了乐观锁的思想。
    2.JVM用C语言封装了汇编调用。Java的基础库中有很多类就是基于JNI调用C接口实现了多线程同步更新的功能。
    
    原理：
    CMS有三个操作数：当前主内存变量的值V，线程本地变量预期值A，线程本地待更新值B。
    当需要更新变量值的时候，会先获取到内存变量值V然后很预期值A进行比较，如果相同则更新为B，
    如果不同，则将最新的变量值更新到预期值中再重新尝试上面的步骤，直到成功为止。
    
    实例：
    AtomicInteger
    
    缺点：
    1.CPU开销比较大, 在并发量比较高的情况下，如果许多线程反复尝试更新某一个变量，
    却又一直更新不成功，循环往复，会给CPU带来很大的压力。
    2.不能保证代码块的原子性, CAS机制所保证的只是一个变量的原子性操作，而不能保证整个代码块的原子性。
    比如需要保证3个变量共同进行原子性的更新，就不得不使用Synchronized了。
    3.ABA问题, 这是CAS机制最大的问题所在。

### 公平锁与非公平锁

#### 概念：
    公平锁：加锁前先查看是否有排队等待的线程，有的话优先处理排在前面的线程，先到先得
    分公平锁：线程加锁时直接尝试获取锁，获取不到就自动到队尾等待
    
#### 实例：
    ReentrantLock 同时支持两种锁
    
    //创建一个非公平锁，默认是非公平锁
    Lock nonFairLock= new ReentrantLock();
    Lock nonFairLock= new ReentrantLock(false);

    //创建一个公平锁，构造传参true
    Lock fairLock= new ReentrantLock(true);
    
#### 场景：
    更多的是直接使用非公平锁：非公平锁比公平锁性能高5-10倍，因为公平锁需要在多核情况下维护一个队列，
    如果当前线程不是队列的第一个无法获取锁，增加了线程切换次数。
    
### 乐观锁与悲观锁

#### 概念：
    悲观锁：假设一定会发生并发冲突，通过阻塞其他所有线程来保证数据的完整性。
    乐观锁：假设不会发生并发冲突，直接不加锁去完成某项更新，如果冲突就返回失败。
    
#### 实例：
    悲观锁：Synchronized多线程同步，具有排他性，也会容易产生死锁。
    乐观锁：
    CAS机制，简单来说会有三个操作数，当前内存变量值V，变量预期值A，即将更新值B，
    当需要更新变量的时候，会直接将变量值V和预期值A进行比较，如果相同，则直接更新为B；
    如果不相同，则当前变量值V刷新到预期值中，然后重新尝试比较更新。
    
#### 场景：    
    乐观锁：适用于数据争用不严重/重试代价不大/需要相应速度快的场景。
    悲观锁：适用于数据争用严重/重试代价大的场景。

## 分布式

### 基于Redis的分布式限流
	1. 每次请求时将当前时间（秒）作为key写入到Redis中，超时时间设置为2秒，Redis将该Key的值进行自增
	2. 当达到阀值时返回错误
	3. 写入Redis的操作用Lua脚本完成，利用Redis的单线程机制保证每个Redis请求的原子性。

### 基于Redis的分布式锁
	1. 常见的分布式解决方案
		基于DB的唯一索引
		基于ZK的临时有序节点
		基于Redis的NX EX参数
	2. Redis的优势
		这里利用 Redis set key 时的一个 NX 参数可以保证在这个 key 不存在的情况下写入成功。并且再加上 EX 参数可以让该 key 在超时之后自动删除。
	
		所以利用以上两个特性可以保证在同一时刻只会有一个进程获得锁，并且不会出现死锁(最坏的情况就是超时自动删除 key)。
		
		使用Redis可以保证性能
		阻塞锁与非阻塞锁见上文
		利用超时机制解决了死锁
		Redis支持集群部署提高了可用性
		
	3. 问题
		如果 key超时之后业务并没有执行完毕但却自动释放锁了，这样就会导致并发问题。
		就算 Redis 是集群部署的，如果每个节点都只是 master 没有 slave，那么 master 宕机时该节点上的所有 key 在那一时刻都相当于是释放锁了，这样也会出现并发问题。就算是有 slave 节点，但如果在数据同步到 salve 之前 master 宕机也是会出现上面的问题。

### 分布式缓存设计

	1. 常见的缓存方案
		NG 本地缓存，命中的话直接返回。
		NG 没有命中时则需要查询分布式缓存，如 Redis 。
		如果分布式缓存没有命中则需要回源到 Tomcat 在本地堆进行查询，命中之后异步写回 Redis 。
		以上都没有命中那就只有从 DB 或者是数据源进行查询，并写回到 Redis 中。
		
	2. 缓存更新的原子性	
		可以将多个 Tomcat 中的数据写入到 MQ 队列中，由消费者进行单线程更新缓存。
		利用分布式锁，只有获取到锁进程才能写数据。
		
	3. 如何写缓存
		写缓存时也要注意，通常来说分为以下几步：

			开启事务。
			写入 DB 。
			提交事务。
			写入缓存。
		这里可能会存在数据库写入成功但是缓存写入失败的情况，但是也不建议将写入缓存加入到事务中。 因为写缓存的时候可能会因为网络原因耗时较长，这样会阻塞数据库事务。 如果对一致性要求不高并且数据量也不大的情况下，可以单独起一个服务来做 DB 和缓存之间的数据同步操作。

		更新缓存时也建议做增量更新。
		
	4. 负载均衡
	
		缓存负载策略一般有以下两种：

			轮询机制。
			一致哈希算法。
			
		轮询的优点是负载到各个服务器的请求是均匀的，但是如果进行扩容则缓存命中率会下降。

		一致哈希的优点是相同的请求会负载到同一台服务器上，命中率不会随着扩容而降低，但是当大流量过来时有可能把服务器拖垮。

		所以建议两种方案都采用： 首先采用一致哈希算法，当流量达到一定的阈值的时候则切换为轮询，这样既能保证缓存命中率，也能提高系统的可用性。
			
### 分布式ID生成器
 
	1. 基于数据库
	
		可以利用 MySQL 中的自增属性 auto_increment 来生成全局唯一 ID，也能保证趋势递增。 但这种方式太依赖 DB，如果数据库挂了那就非常容易出问题。
		
		但也有改进空间，可以将数据库水平拆分，如果拆为了两个库 A 库和 B 库。 A 库的递增方式可以是 0 ,2 ,4 ,6。B 库则是 1 ,3 ,5 ,7。这样的方式可以提高系统可用性，并且 ID 也是趋势递增的。

		但也有如下一下问题：

		想要扩容增加性能变的困难，之前已经定义好了 A B 库递增的步数，新加的数据库不好加入进来，水平扩展困难。
		也是强依赖与数据库，并且如果其中一台挂掉了那就不是绝对递增了。
	
	2. 本地UUID生成
	
		还可以采用 UUID 的方式生成唯一 ID，由于是在本地生成没有了网络之类的消耗，所有效率非常高。

		但也有以下几个问题：

			生成的 ID 是无序性的，不能做到趋势递增。
			由于是字符串并且不是递增，所以不太适合用作主键。
			
	3. 采用本地时间
		
		这种做法非常简单，可以利用本地的毫秒数加上一些业务 ID 来生成唯一ID，这样可以做到趋势递增，并且是在本地生成效率也很高。

		但有一个致命的缺点:当并发量足够高的时候唯一性就不能保证了。
		
	4. Twitter雪花算法
    
## 常用框架

### Spring

#### Spring Bean
	
	1. 生命周期
		实例化
		填充属性
		调用BeanNameAware的setBeanName方法
		调用BeanFactoryAware的setBeanFactory方法
		调用ApplicationContextAware的setApplicationContext方法
		调用BeanPostProcess的postProcessBeforeInitialization方法
		调用InitializingBean的afterPropertiesSet方法
		调用定制的初始化方法
		调用BeanPostProcess的postProcessAfterInitialization方法
		Bean准备就绪
		调用DispostableBean的destory方法
		调用定制的销毁方法
		
		再谈生命周期之前有一点需要先明确：

		Spring 只帮我们管理单例模式 Bean 的完整生命周期，对于 prototype 的 bean ，Spring 在创建好交给使用者之后则不会再管理后续的生命周期。
		
	2. 注解方式

		在 bean 初始化时会经历几个阶段，首先可以使用注解 @PostConstruct, @PreDestroy 来在 bean 的创建和销毁阶段进行调用:
		
	3. InitializingBean, DisposableBean 接口
		
		还可以实现 InitializingBean,DisposableBean 这两个接口，也是在初始化以及销毁阶段调用：
		
	4. 自定义初始化和销毁方法

		也可以自定义方法用于在初始化、销毁阶段调用:
			在一个类里定义start()方法和destory()方法
			在@Configuration类里面使用@Bean注解
			使用@Bean(initMethod = "start", destroyMethod = "destroy")指定初始化和销毁方法
		
```java
            @Configuration
            		public class LifeCycleConfig {
            
            
            			@Bean(initMethod = "start", destroyMethod = "destroy")
            			public SpringLifeCycle create(){
            				SpringLifeCycle springLifeCycle = new SpringLifeCycle() ;
            
            				return springLifeCycle ;
            			}
            		}
            
            		public class SpringLifeCycle{
            
            			private final static Logger LOGGER = LoggerFactory.getLogger(SpringLifeCycle.class);
            			public void start(){
            				LOGGER.info("SpringLifeCycle start");
            			}
            
            
            			public void destroy(){
            				LOGGER.info("SpringLifeCycle destroy");
            			}
            		}
```
	
	5. 实现\*Aware接口	
	
		\*Aware 接口可以用于在初始化 bean 时获得 Spring 中的一些对象，如获取 Spring 上下文等。
		
		这样在 springLifeCycleAware 这个 bean 初始化会就会调用 setApplicationContext 方法，并可以获得 applicationContext 对象。
		
	6. BeanPostProcessor 增强处理器

		实现 BeanPostProcessor 接口，Spring 中所有 bean 在做初始化时都会调用该接口中的两个方法，可以用于对一些特殊的 bean 进行处理：
		
		postProcessBeforeInitialization	//bean初始化之前调用
		postProcessAfterInitialization	//bean初始化完成调用
		
#### Spring AOP

	1. JDK动态代理
	
		其中有两个非常核心的类:

		java.lang.reflect.Proxy类。
		java.lang.reflect.InvocationHandle接口。

		Proxy 类是用于创建代理对象，而 InvocationHandler 接口主要你是来处理执行逻辑。
		
	2. CGLIB 动态代理

		cglib 是对一个小而快的字节码处理框架 ASM 的封装。 他的特点是继承于被代理类，这就要求被代理类不能被 final 修饰。	

### Guava

	1. 缓存
		
		缓存在日常开发中举足轻重，如果你的应用对某类数据有着较高的读取频次，并且改动较小时那就非常适合利用缓存来提高性能。
		
		缓存之所以可以提高性能是因为它的读取效率很高，就像是 CPU 的 L1、L2、L3 缓存一样，级别越高相应的读取速度也会越快。

		但也不是什么好处都占，读取速度快了但是它的内存更小资源更宝贵，所以我们应当缓存真正需要的数据。
		
	2. JVM缓存

		首先是 JVM 缓存，也可以认为是堆缓存。

		其实就是创建一些全局变量，如 Map、List 之类的容器用于存放数据。

		这样的优势是使用简单但是也有以下问题：

			只能显式的写入，清除数据。
			不能按照一定的规则淘汰数据，如 LRU，LFU，FIFO 等。
			清除数据时的回调通知。
			其他一些定制功能等。

	3. Ehcache、Guava Cache
	
		所以出现了一些专门用作 JVM 缓存的开源工具出现了，如本文提到的 Guava Cache。

		它具有上文 JVM 缓存不具有的功能，如自动清除数据、多种清除算法、清除回调等。

		但也正因为有了这些功能，这样的缓存必然会多出许多东西需要额外维护，自然也就增加了系统的消耗。
		
	4. 分布式缓存设计

		刚才提到的两种缓存其实都是堆内缓存，只能在单个节点中使用，这样在分布式场景下就招架不住了。

		于是也有了一些缓存中间件，如 Redis、Memcached，在分布式环境下可以共享内存。
		
	5. 	
### Kafka 

#### produce

#### custom

## 架构设计

### 秒杀系统设计

	1. 设计思路
	
		尽量将请求过滤在上游
		尽可能的利用缓存
		
	2. 具体实现

		前端JS进行请求过滤，比如5秒钟只能点一次抢购按钮，5秒钟只能允许请求一次后端服务
		如果流量巨大，导致各个层的压力都很大可以适当的加机器横向扩容。如果加不了机器那就只有放弃流量直接返回失败。快速失败非常重要，至少可以保证系统的可用性。
		
		业务分批执行：对于下单、付款等操作可以异步执行提高吞吐率。
		
		主要目的就是尽量少的请求直接访问到 DB。

### 百万级消息推送系统

	1. 场景：
	
		基于WEB的聊天系统（点对点，群聊）
		WEB应用中需要服务端推送的场景
		基于SDK的消息推送平台

	2. 技术选型
		
		要满足大量的连接数、同时支持双全工通信，并且性能也得有保障。

		在 Java 技术栈中进行选型首先自然是排除掉了传统 IO。

		那就只有选 NIO 了，在这个层面其实选择也不多，考虑到社区、资料维护等方面最终选择了 Netty。

	3. 协议解析
	
		RPC框架定制协议
		
	4. 简单实现

		4.1. 注册鉴权
			
			所以第一步得是注册才行。

			如上面架构图中的 注册/鉴权 模块。通常来说都需要客户端通过 HTTP 请求传递一个唯一标识，后台鉴权通过之后会响应一个 token，并将这个 token 和客户端的关系维护到 Redis 或者是 DB 中。

			客户端将这个 token 也保存到本地，今后的每一次请求都得带上这个 token。一旦这个 token 过期，客户端需要再次请求获取 token。

			鉴权通过之后客户端会直接通过TCP 长连接到图中的 push-server 模块。

			这个模块就是真正处理消息的上、下行。

		4.2. 保存通道关系
		
			在连接接入之后，真正处理业务之前需要将当前的客户端和 Channel 的关系维护起来。

			假设客户端的唯一标识是手机号码，那就需要把手机号码和当前的 Channel 维护到一个 Map 中。

			同时为了可以通过 Channel 获取到客户端唯一标识（手机号码），还需要在 Channel 中设置对应的属性：

			public static void putClientId(Channel channel, String clientId) {
				channel.attr(CLIENT_ID).set(clientId);
			}

			获取时手机号码时：

			public static String getClientId(Channel channel) {
				return (String)getAttribute(channel, CLIENT_ID);
			}

			这样当我们客户端下线的时便可以记录相关日志：

			String telNo = NettyAttrUtil.getClientId(ctx.channel());
			NettySocketHolder.remove(telNo);
			log.info("客户端下线，TelNo=" +  telNo);

			>这里有一点需要注意：存放客户端与 Channel 关系的 Map 最好是预设好大小（避免经常扩容），因为它将是使用最为频繁同时也是占用内存最大的一个对象。

		4.3. 消息上行
			
			接下来则是真正的业务数据上传，通常来说第一步是需要判断上传消息输入什么业务类型。

			在聊天场景中，有可能上传的是文本、图片、视频等内容。

			所以我们得进行区分，来做不同的处理；这就和客户端协商的协议有关了。

				可以利用消息头中的某个字段进行区分。
				更简单的就是一个 JSON 消息，拿出一个字段用于区分不同消息。

			不管是哪种只有可以区分出来即可。

		4.4. 消息解析与业务解耦
		
			Redis、Zookeeper、Kafka、MySQL





