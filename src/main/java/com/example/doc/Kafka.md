## Kafka
### First a few concepts:

    Kafka is run as a cluster on one or more servers that can span multiple datacenters.
    The Kafka cluster stores streams of records in categories called topics.
    Each record consists of a key, a value, and a timestamp. 
    
### Kafka has four core APIs:

    The Producer API allows an application to publish a stream of records to one or more Kafka topics.
    The Consumer API allows an application to subscribe to one or more topics and process the stream of records produced to them.
    The Streams API allows an application to act as a stream processor, consuming an input stream from one or more topics and producing an output stream to one or more output topics, effectively transforming the input streams to output streams.
    The Connector API allows building and running reusable producers or consumers that connect Kafka topics to existing applications or data systems. For example, a connector to a relational database might capture every change to a table. 
    
### Topics and Logs    

    A topic is a category or feed name to which records are published. Topics in Kafka are always multi-subscriber; that is, a topic can have zero, one, or many consumers that subscribe to the data written to it.
    Kafka's performance is effectively constant with respect to data size so storing data for a long time is not a problem. 
    The partitions in the log serve several purposes. First, they allow the log to scale beyond a size that will fit on a single server. Each individual partition must fit on the servers that host it, but a topic may have many partitions so it can handle an arbitrary amount of data. Second they act as the unit of parallelism—more on that in a bit. 
    
### Distribution

    The partitions of the log are distributed over the servers in the Kafka cluster with each server handling data and requests for a share of the partitions. Each partition is replicated across a configurable number of servers for fault tolerance. 
    Each partition has one server which acts as the "leader" and zero or more servers which act as "followers". The leader handles all read and write requests for the partition while the followers passively replicate the leader. If the leader fails, one of the followers will automatically become the new leader. Each server acts as a leader for some of its partitions and a follower for others so load is well balanced within the cluster. 
    
### Geo-Replication

    Kafka MirrorMaker provides geo-replication support for your clusters. With MirrorMaker, messages are replicated across multiple datacenters or cloud regions. You can use this in active/passive scenarios for backup and recovery; or in active/active scenarios to place data closer to your users, or support data locality requirements. 
    
### Producers

    Producers publish data to the topics of their choice. The producer is responsible for choosing which record to assign to which partition within the topic. This can be done in a round-robin fashion simply to balance load or it can be done according to some semantic partition function (say based on some key in the record). More on the use of partitioning in a second! 
    
### Consumers

    Consumers label themselves with a consumer group name, and each record published to a topic is delivered to one consumer instance within each subscribing consumer group. Consumer instances can be in separate processes or on separate machines.
    If all the consumer instances have the same consumer group, then the records will effectively be load balanced over the consumer instances.
    If all the consumer instances have different consumer groups, then each record will be broadcast to all the consumer processes.

### Multi-tenancy

### HA
    
    Messages sent by a producer to a particular topic partition will be appended in the order they are sent. That is, if a record M1 is sent by the same producer as a record M2, and M1 is sent first, then M1 will have a lower offset than M2 and appear earlier in the log.
    A consumer instance sees records in the order they are stored in the log.
    For a topic with replication factor N, we will tolerate up to N-1 server failures without losing any records committed to the log. 
    
### Kafka as a Messaging System
    
    By having a notion of parallelism—the partition—within the topics, Kafka is able to provide both ordering guarantees and load balancing over a pool of consumer processes. This is achieved by assigning the partitions in the topic to the consumers in the consumer group so that each partition is consumed by exactly one consumer in the group. By doing this we ensure that the consumer is the only reader of that partition and consumes the data in order. Since there are many partitions this still balances the load over many consumer instances. Note however that there cannot be more consumer instances in a consumer group than partitions. 
    
### Kafka as a Storage System

### Kafka for Stream Processing

//TODO


