package com.wdx.rabbitmq;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author wangdongxing
 * @since 2019-05-24 08:28
 */
public class RabbitConsumer {

    private static final String EXCHANGE_NAME = "exchange_demo";

    private static final String ROUTING_KEY = "routingkey_demo";

    private static final String QUEUE_NAME = "queue_demo";

    private static final String IP_ADDRESS = "localhost";

    private static final int PORT = 5672;

    private static final String VIRTUAL_HOST = "testhost";

    public static void main(String[] args) throws Exception {
        Address[] addresses = new Address[] { new Address(IP_ADDRESS, PORT) };
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // connectionFactory.setHost(IP_ADDRESS);
        // connectionFactory.setPort(PORT);
        connectionFactory.setVirtualHost(VIRTUAL_HOST);
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        //这里的连接方式与生产者的 demo 略有不同 ， 注意辨别区别
        //创建连接
        Connection connection = connectionFactory.newConnection(addresses);
        //创建信道
        Channel channel = connection.createChannel();
        // 创建一个type="direct"、持久化的、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);

        // 创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 将交换器与队列通过路由器绑定
        // channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        //设置客户端最多接收未被 ack 的消息的个数
        channel.basicQos(64);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv] Received '" + message + "'");
            Thread.sleep(500);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
        // Consumer consumer = new DefaultConsumer(channel) {
        //     @Override
        //     public void handleDelivery(String consumerTag,
        //                                Envelope envelope,
        //                                AMQP.BasicProperties properties,
        //                                byte[] body) throws IOException {
        //         System.out.println("recv message: " + new String(body));
        //         try {
        //             TimeUnit.SECONDS.sleep(1);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         channel.basicAck(envelope.getDeliveryTag(), false);
        //     }
        // };
        // channel.basicConsume(QUEUE_NAME, consumer);
        //等待回调函数执行完毕之后 ， 关闭资源 TimeUnit.SECONDS . sleep(5);
        // channel.close();
        // connection.close();
    }
}
