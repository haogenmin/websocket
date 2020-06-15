package com.haogenmin.webtest.websocket;

import com.alibaba.fastjson.JSONObject;
import com.haogenmin.websocket.manager.impl.WebSocketManager;
import com.haogenmin.websocket.service.impl.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author ：HaoGenmin
 * @Title :MyWebSocketServer
 * @date ：Created in 2020/6/15 9:14
 * @description：
 */
@ServerEndpoint("/myWebsocket/{userId}")
@Component
public class MyWebSocketServer extends WebSocketServer {
    private Logger logger = LoggerFactory.getLogger(MyWebSocketServer.class);


    @OnMessage
    @Override
    public void getMessage(String message, Session session) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        logger.info("收到用户" + getUserId() + "的消息：" + jsonObject.getString("message"));
        System.out.println("MyWebSocket--->"+message);
    }

}
