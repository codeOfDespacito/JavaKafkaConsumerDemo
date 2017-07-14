package cn.com.zhangdi.kafka;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

/**
 * Created by zhangdi on 2017/07/03.
 */
public class ComsumerThread implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;

    public ComsumerThread(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        MessageAndMetadata<byte[], byte[]> messageAndMetadata = null;
        while (it.hasNext()) {
            messageAndMetadata = it.next();
            String key = new String(messageAndMetadata.key());
            String values = new String(messageAndMetadata.message());
            System.out.println("kafka key = " + key);
            System.out.println("kafka value = " + values);

        }
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
}
