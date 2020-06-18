package com.chenglong.study.websocket;


import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;

@Slf4j
@ClientEndpoint
public class SocketClient {

    @OnOpen
    public void onOpen() {
        log.info("webSocket on onOpen------");
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("webSocket on message:{}", message);
    }

    @OnClose
    public void onClose() {
        log.info("断线重连");
/*
        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = loginByApp(restTemplate);
        String token = jsonObject.getString("token");
        URI path = URI.create("wss://api-cru.welink.qq.com/space/websocket/datahub/swmp/messageHub?token=" + token);

        SocketClient socketClient = new SocketClient(path);
        socketClient.connectBlocking();*/

    }

    @OnError
    public void onError(Throwable ex) {
        log.error("ex:{}", ex);
    }

}
