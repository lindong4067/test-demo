
Redis 学习—— 数据类型及操作

目录

一、String，字符串
	1、set key value [ex 秒数]/[px 毫秒数] [nx]/[xx]
	2、setnx key value：key不存在时设置value
	3、get key：获取key的值
	4、mset k1 v1 k2 v2 ... kn vn：multi set 一次性设置多个键值
	5、msetnx k1 v1 k2 v2 ... kn vn：设置多个键值，当键不存在时才设置
	6、mget k1 k2 .. kn：获取多个key的值
	7、setrange key offset value：将key对应的值，偏移offset位置的字符替换为value。
	8、getrange key start end：获取字符串中[start, end]范围的值
	9、getset key newvalue：获取原值，并设置新值
	10、append key value：把value追加到key的原值上
	11、strlen key：获取key值的长度
	12、incr/decr key：指定key的值加1或减1，返回加1或减1后的值
	13、incrby/decrby key num：指定的key值加或减num，返回加num或减num后的值
	14、incrbyfloat key float：key值加float，float为浮点数
	15、setbit key offset value：设置key值的二进制位上offset对应的值
	16、getbit key offset：获取key值的二进制位上offset对应的值
	17、bitop operation destkey key1 key2 ... keyn：对key1、key2 ... keyn做operation操作，并将结果保存到destkey上
	18、bitcount key：返回被置为1的位的数量
	19、bitops key 1/0：返回第一个被置为1/0的位
二、List，链表
	1、lpush key value：把值插入链表头部
	2、lrange key start end：返回链表中[start, end]中的元素
	3、rpush key value：把值插入链表的尾部
	4、lpop key：返回并删除链表头元素
	5、rpop key：返回并删除链表尾部元素
	6、lrem key count value：从链表中删除value值
	7、ltrim key start end：截取[start, end]的列表并重新赋给key
	8、lindex key index：返回列表索引index上的值
	9、llen key：返回列表的个数
	10、linsert key after|before search value：在列表中查找search，在search之后|之前插入value
	 11、lset key index value：设置列表index位置的元素为value
	12、brpop/blpop key timeout：等待弹出key的尾部/头部元素
	13、rpoplpush source dest：把source的尾部拿出来放到dest的头部
	14、brpoplpush source dest timout：等待弹出，放到dest中
三、Set，集合
	1、sadd key val1 val2 ... valn：向集合中添加元素
	2、srandmember key：随机或一个元素
	3、smembers key：返回列表的所有元素
	4、sismember key value：判断是否存在某个元素
	5、scard key：返回集合的个数
	6、spop key：返回并删除其中一个随机元素
	7、srem val1 val2 ... valn：删除元素
	8、smove source dest value：将source集合中的value删除并移到dest中
	9、sinter k1 k2 ... kn：求集合的交集
	11、sunion k1 k2 ... kn：求集合的并集
	12、sdiff k1 k2 ... kn：求集合的差集
四、Sorted Set，有序集合
	1、zadd key score1 value1 score2 value2 ... scoren valuen：添加元素
	2、zrange key start end [withscores]：获取[start, end]的元素(升序)
	3、zrevrange key start end [withscores]：获取[start, end]的元素(降序)
	4、zrank key member：查member的排名(升序)
	5、zrevrank key member：查member的排名(降序)
	6、zcard key：返回元素个数
	7、zcount key min max：返回分数[min, max]区间的元素个数
	8、zscore key member：获取元素的分数
	9、zrangebyscore key min max [withscores] [limit offset N]：获取[min, max]区间并偏移offset个，取出后N个元素(升序)
	10、zrevrangebyscore key max min [withscores] [limit offset N]：获取[max, min]区间并偏移offset个，取出后N个元素(降序)
	11、zrem key value1 value2 ... valuen：删除元素
	12、zremrangebyscore key min max：删除分数[min, max]范围的元素
	13、zremrangebyrank key start end：删除排名[min, max]之间的元素
	14、zinterstore dest numkeys key1 [key2 ... keyn] [weights weight1 [weight2 ... weightn]] [aggregate sum|min|max]
五、Hash，哈希
	1、hset key field value：设置key中field的值
	2、hsetnx key field value：当键不存在时才设置值
	3、hmset key field1 value1 ... fieldn valuen：设置多个键值
	4、hget key field：获取key中field的值
	5、hmget key field1 ... fieldn：获取多个值
	6、hgetall key：获取key中所有的键值
	7、hdel key field：删除key中的field
	8、hlen key：返回key中的个数
	9、hexists key field：判断是否存在某个key
	10、hkeys key：返回所有的键
	11、hvals key：返回所有的值
	12、hincyby key field value：增加整数值
	13、hincrbyfloat key field value：增加小数