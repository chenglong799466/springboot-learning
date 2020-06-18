package com.chenglong.study;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//SpringBootTest在启动的时候不会启动服务器，所以WebSocket自然会报错，这个时候需要添加选项webEnvironment，以便提供一个测试的web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudyApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("===================================");
    }

    @Test
    public void testMqtt() throws MqttException {
        /*ServerMQTT server = new ServerMQTT();

        ClientMQTT client = new ClientMQTT();
        client.start();

        server.mqttMessage = new MqttMessage();
        server.mqttMessage.setQos(1);
        server.mqttMessage.setRetained(true);
        server.mqttMessage.setPayload("hello,topic122".getBytes());
        server.publish(server.getTopic11(), server.getMqttMessage());
        System.out.println(server.mqttMessage.isRetained() + "------ratained状态");*/

    }

}
