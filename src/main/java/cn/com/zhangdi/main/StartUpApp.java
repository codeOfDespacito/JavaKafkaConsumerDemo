package cn.com.zhangdi.main;

import cn.com.zhangdi.kafka.ConsumerGroupExample;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangdi on 2017/07/14.
 */
public class StartUpApp {
    public static void main(String[] args) {
        new StartUpApp().doStart(1);
    }


    private void doStart(int a_numThread) {
        ConsumerGroupExample example = new ConsumerGroupExample("kafkahost:2181", "groupid_name", "topic_name");
        example.run(a_numThread);

        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        example.shutdown();
        System.out.println("application shutdown");

    }
}
