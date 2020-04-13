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
    ConsumerGroupExample example = new ConsumerGroupExample("master:2181,node01:2181,node02:2181", "test-zhangd5", "test_zhangdi_topic");
    example.run(a_numThread);

    try {
      TimeUnit.HOURS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    example.shutdown();
    System.out.println("application shutdown");

  }



}
