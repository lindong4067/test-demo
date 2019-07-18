Resume

OAMCenter是“运营、管理和维护中心”的缩写。它作为HTTP服务工作，接收来自网络的指令来配置和监视MPS产品。

OAMCenter是基于SpringBoot框架 RESTful服务开发的。REST API的真实性用于配置和监视MPS产品。OAMCenter将这些请求从REST API转换为其他接口，如CAIX、Consul Http API和UDA请求，并将它们路由到目标服务，如FDS服务器、领事服务和UDA服务器。

SpringBoot + SpringMVC, API遵循RESTFul风格，
Mybatis
Mysql
SpringCloud
	Zuul路由网关
	Ribbon客户端负载均衡
	Feign声明式服务调用
	Hystrix服务熔断及服务降级
	Eureka注册中心
	Sleuth调用链路跟踪
	Bus消息总线技术
	Stream消息驱动的微服务
Docker虚拟化技术
	镜像
	容器
	仓库
	Docker Compose部署脚本
	Docker Service服务编排
	Docker Redis分布式集群部署
	Dockerfile构建
	Kubernetes编排

Git Maven Jenkins Sonar

Zookeeper 分布式应用程序协调服务

Redis 高性能的key-value数据库

RabbitMQ 面向消息的中间件

Kafka	分布式发布订阅消息系统

使用Interceptor

Architecture

FE
	WebBE
		OAMCenter 
			UDAClient 		UDAServer		Postgre Redis
			ConsulClient 	ConsulServer	Consul
			HTTPClient		FDSServer		SMPC GMPC 
			CAIX(Customer Administration Interface based on XML)

1.Consul
	KV
	Transaction
	Service
	Watch

2.watch
	include: ISP ServiceAlarm MiscService
	oam-fds--fdsserver
	db-uda--udaserver
	db-db--postgre
	db-db--redis
	
3.Async Task Management
	import cell data
	export cell data

4.Clean Up Task
	Event Log
	Alarm Log
	Ghost Cell
	TPS Log
	Counter history

5.Config Loader
	configure for OAMCenter in Consul, 
	Runtime configurable, consul watch
	Non-runtime configurable, restart
	
6.ISP
	oam-fds--fdsserver
	db-uda--udaserver
	db-db--postgre
	db-db--redis
	
7.Virtual Counter Cache
	counterhistory
	countercachehistory
	
8.Service Monitor
	ServiceMonitor watch all services in Consul
	
9.Misc Service	
10.Logging
11.High Availability
	OCF Resource
	Cluster Configurations

ESA Config

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




















