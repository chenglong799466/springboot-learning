package com.chenglong.study.controller;

import com.chenglong.study.concurrent.RealData;
import com.chenglong.study.model.HelloWorld;
import com.chenglong.study.model.RespCode;
import com.chenglong.study.model.RespEntity;
import com.chenglong.study.mqtt.ClientMQTT;
import com.chenglong.study.mqtt.ServerMQTT;
import com.chenglong.study.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloWorld helloWorld;

    @Autowired
    private HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String echo(@RequestParam(value = "echo") String echo) {
        return echo;
    }

    @GetMapping(value = "/sub")
    public void mqttSub() {
        ClientMQTT client = new ClientMQTT();
        client.setClientId("client11");
        client.start();

    }

    @GetMapping(value = "/sub1")
    public void mqttSub1() {
        ClientMQTT client = new ClientMQTT();
        client.setClientId("client22");
        client.start();

    }

    @GetMapping(value = "/pub")
    public void mqttPub() {

        ServerMQTT server = null;
        try {
            server = new ServerMQTT();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        server.mqttMessage = new MqttMessage();
        server.mqttMessage.setQos(1);
        server.mqttMessage.setRetained(false);
        server.mqttMessage.setPayload("hello,topic122".getBytes());
        try {
            server.publish(server.getTopic11(), server.getMqttMessage());
        } catch (MqttException e) {
            e.printStackTrace();
        }
        System.out.println(server.mqttMessage.isRetained() + "------ratained状态");
    }

    /**
     * 实验Future模式
     */
    @GetMapping(value = "/concurrent")
    public void concurrent() throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();

        FutureTask<String> futureTask = new FutureTask<String>(new RealData("hello,world"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);

        // 表示正在处理其他任务
        TimeUnit.SECONDS.sleep(2);
        // get()方法：如果call方法执行完成则给出结果；如果未完成则将当前线程挂起等待
        System.out.println("最后结果-->" + futureTask.get());

        Long end = System.currentTimeMillis();

        Long useTime = end - start;

        System.out.println("程序运行了-->" + useTime + "毫秒");
    }

    /**
     * 体验java8的lambda表达式和stream流api
     */
    @GetMapping(value = "/stream")
    public void stream() {
        // java 8之后
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.stream().forEach(n -> System.out.println(n));
        // 等价于
        features.forEach(System.out::println);

        // Predicate函数式接口的api
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");


        // lambda表达式不能对定义在域外的变量进行修改
        List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7});


        // list和数组互转
        Integer[] objects = primes.toArray(new Integer[primes.size()]);


        primes.stream().mapToLong(o -> o).count();

        int factor = 1;
        primes.forEach(e -> {
            System.out.println(factor);
        });

    }

    /**
     * 本地web服务
     */
    @PostMapping(value = "/test")
    public RespEntity test(@RequestParam String projectId, @RequestBody Map map) {

        String url = "";

        log.info("测试日志");

        System.out.println(map.toString());

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("x-welink-project-id", "476200");

        HttpEntity<Map> httpEntity = new HttpEntity<>(map, httpHeaders);


        Object o = restTemplate.postForObject(url, httpEntity, Object.class);

        return new RespEntity(RespCode.SUCCESS, o);

    }


}


