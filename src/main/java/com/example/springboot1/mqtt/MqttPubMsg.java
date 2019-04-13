package com.example.springboot1.mqtt;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang.xiongwei
 * @Title: MqttPubMsg
 * @Package com.intellif.smart.utils
 * @Description
 * @date 2018/11/29 17:04
 */
public class MqttPubMsg {
    private static Logger LOG = LogManager.getLogger(MqttPubMsg.class);
    private static final String clientid = "cccApi";
    private static MqttClient client;
    private static final String HOST = "tcp://192.168.11.47:1883";

    static{
        try {
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    LOG.info("mqtt connection lost, trying to reconnect it ...");
                    try {
                        client.disconnect();
                        client.connect();
                    } catch (Exception e) {
                        LOG.error("error to reconnect mqtt server");
                    }
                }
                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                @Override
                public void messageArrived(String topicName, MqttMessage message) throws Exception {
                }

            });

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);
            client.connect(options);
        } catch (Exception e) {
            LOG.error("error to create mqtt sender", e);
        }
    }

    public static void post(String topic, String msg) {
        try {
            if (!client.isConnected()) {
                client.connect();
            }
            LOG.info("ready to post msg:" + topic + "," + msg);
            MqttTopic mqttTopic = client.getTopic(topic);
            MqttMessage message = new MqttMessage();
            message.setQos(0);
            message.setRetained(false);
            message.setPayload(msg.getBytes());
            MqttDeliveryToken token;
            token = mqttTopic.publish(message);
            token.waitForCompletion();
        } catch (Exception e) {
            LOG.error("error to post mqtt message", e);
        }
    }

    public static void  main(String[] args){
        MqttSubMsg mqttSubMsg = new MqttSubMsg();
        mqttSubMsg.start();
        Map<String,Object> map = new HashMap<>();
        map.put("Time","20181215T181631");
        map.put("FaceId",281544299868160L);
        MqttPubMsg.post("test", JSONObject.toJSONString(map));
    }
}
