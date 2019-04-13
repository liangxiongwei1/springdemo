package com.example.springboot1.mqtt;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liang.xiongwei
 * @Title: MqttSubMsg
 * @Package com.intellif.smart.utils
 * @Description
 * @date 2018/11/29 17:28
 */
public class MqttSubMsg {
    protected static final Logger logger = LoggerFactory.getLogger(MqttSubMsg.class);
    public static final String HOST = "tcp://192.168.11.228:1883";
    public static final String TOPIC = "lxw_test";
    private static final String clientid = "client124111";
    private MqttClient client;
    private MqttConnectOptions options;
    public void start() {
        try {
            logger.info("SubMsg----->start");
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 设置回调
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    logger.info("mqtt connection lost, trying to reconnect it ...");
                    try {
                        client.disconnect();
                        client.connect();
                    } catch (Exception e) {
                        logger.error("error to reconnect mqtt server");
                    }
                }
                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                @Override
                public void messageArrived(String topicName, MqttMessage message) throws Exception {
                    //业务代码
                    logger.info("接受mqtt消息成功，message:"+message.toString());
                }

            });
            MqttTopic topic = client.getTopic(TOPIC);
            // setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            options.setWill(topic, "close".getBytes(), 1, true);
            client.connect(options);
            // 订阅消息
            client.subscribe(TOPIC, 1);
        } catch (Exception e) {
            logger.error("MQ订阅者异常",e);
        }
    }

}
