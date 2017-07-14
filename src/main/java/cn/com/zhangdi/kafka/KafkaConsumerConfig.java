package cn.com.zhangdi.kafka;


import kafka.consumer.ConsumerConfig;

import java.util.Properties;

/**
 * Created by zhangdi on 2017/07/03.
 */
public class KafkaConsumerConfig {

    /**
     * 创建ConsumerConfig
     *
     * @param a_zookeeper zookeeper地址
     * @param a_groupId   Consumer groupid
     * @return
     */
    public static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        //props.put("auto.offset.reset", "smallest");
        props.put("auto.offset.reset", "largest");
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        return new ConsumerConfig(props);
    }
}
