package com.zsl.WebSocket.oth;

import org.springframework.web.socket.*;
import java.util.ArrayList;
import java.util.Random;

public class SystemWebSocketHandler implements WebSocketHandler {

    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();;

    //链接成功
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("ConnectionEstablished");
        users.add(webSocketSession);
        webSocketSession.sendMessage(new TextMessage("链接成功！"));

    }

    //收到消息
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("handleMessage：" + webSocketMessage.toString());
        int max=175;
        int min=10;
        Random random = new Random();
        while(true) {
            int x = random.nextInt(max) % (max - min + 1) + min;
            int y = random.nextInt(max) % (max - min + 1) + min;
            System.out.println(x + "," + y);
            TextMessage msBack = new TextMessage(x + "," + y);
            webSocketSession.sendMessage(msBack);
            Thread.sleep(1000);
        }
    }

    //异常错误
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        users.remove(webSocketSession);
    }

    //断开链接
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


}
