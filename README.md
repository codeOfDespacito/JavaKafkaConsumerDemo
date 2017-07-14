### 简介
kafka消费者Demo

### [kafkaConsumer][1]重要配置参数说明
* `auto.offset.reset`：当offset非法时，使用哪种方式更新offset，其值有`smallest`和`largest`，默认为`largest`。使用一个新的groupid读取数据时，因为offset存在导致非法，如果是`smallest`则会从kafka中最小的offset开始读取数据，如果是`largest`则会从新来的数据开始读取，已经存在于kafka中的数据不会在读取。   

### 逻辑说明

* java读取kafka，此程序没有sleep操作，只要topic中有数据则会直接拿取
* 程序使用线程池`Executors.newFixedThreadPool(a_numThreads)`的方式拿取topic数据，最大线程数取决与topic的分区数。具体情况如下：   
> 1. 当线程数少于分区属，则每个线程会在多个分区中拿取；   
> 2. 当线程数等于分区属，则每个线程只拿取一个分区的内容；   
> 3. 当线程数大于分区属，则多余的线程则会被闲置，同时也占用系统资源

[1]:./src/main/java/cn/com/zhangdi/kafka/KafkaConsumerConfig.java