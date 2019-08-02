Spring Cloud 
 
> springcloud是由多个独立项目集合而成的，每个项目都是独立的，各自进行自己的迭代和版本发布。所以springcloud不方便使用版本号来管理，而是使用版本名。以避免和子项目版本号的冲突。
 
 核心组件
 
 Eureke 服务发现

 Feign 声明式服务调用，利用动态代理，构造请求，发起请求，解析响应，基于HTTP

 Ribbon 客户端负载均衡，默认Round Ribbon算法

 Hystrix 服务隔离、熔断、降级的框架

 Zuul 微服务网关, 可以做统一的降级、限流、认证授权、安全
 
 Config 分布式配置
 
 