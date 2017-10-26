package com.zsl.WebSocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


import java.util.Map;

//websocket握手类
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {


    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("websocketHandshake前");
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        System.out.println("websocketHandshake后");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
