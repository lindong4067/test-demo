## 1 IOC容器
	1.1 BeanFactory接口提供了高级的配置机制，可以管理任何类型的对象。
	1.2 ApplicationContext是BeanFactory的子接口，它在BeanFactory的基础上增加了更容易与Spring Aop集成的功能，语言资源处理，发布事件，和程序应用层的特定上下文（例如WebApplicationContext）。
	1.3 BeanFactory提供了配置框架和基本功能。ApplicationContext提供了更多企业级应用的相关功能。ApplicationContext是BeanFactory的完整超集。
	1.4 在容器内部，这些Bean被表示为BeanDefinition对象，它包含了如下的元数据信息：
		* 一个限制包类名:通常是定义好的bean的实现类
		* bean行为配置元素，规定了bean的容器内的行为方式（范围，生命周期回调等等）
		* 对其他bean的引用，这些引用被叫做协作者和依赖
		* 在新创建的对象中设置其他的设置项，例如，管理连接池的bean，你可以设置这个bean的可以使用的连接数，或者最大，最小连接数
## 2 依赖注入 DI
	2.1 依赖注入是对象定义他们依赖的过程，这些依赖指的是与之一起协作的其他对象，只通过构造方法参数，工厂方法的参数或对象属性（调用构造方法或者工厂方法后得到的对象）。容器在创建bean之后注入它们的依赖。这个过程是从根本上反转过来的，因此叫做控制反转（IOC），bean自己控制实例化或定位它的依赖。
	
## 3 IOC容器
	3.1 IOC容器与Beans
	3.2 MessageSource
		3.2.1 三种方式设置locale，优先级依次：
			* 代码中设定 setDefault(Locale locale)
			* 启动参数设置 java -Duser.country=US -Duser.language=en
			* Linux服务器locale
	3.3 Event&Listener
	3.4 ApplicationContext
	3.5 BeanFactory


























	