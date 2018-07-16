package com.example.demo11.websocket;

import com.zhangs.sbdemos.websocket.DemoHandler;
import com.zhangs.sbdemos.websocket.HandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author jane
 * @description webSocket配置类，绑定前端连接端点url及其他信息
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private DemoHandler demoHandler;

    @Autowired
    private HandshakeInterceptor handshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //绑定前端连接端点url
        registry.addHandler(demoHandler, "/websocket/demo").addInterceptors(handshakeInterceptor).withSockJS();
    }
}