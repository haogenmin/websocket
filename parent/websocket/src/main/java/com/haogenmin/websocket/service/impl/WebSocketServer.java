package com.haogenmin.websocket.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haogenmin.websocket.manager.IWebSocketManager;
import com.haogenmin.websocket.manager.impl.WebSocketManager;
import com.haogenmin.websocket.service.IWebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author ：HaoGenmin
 * @Title :WebSocketServer
 * @date ：Created in 2020/6/13 16:41
 * @description :websocket
 */
public abstract class WebSocketServer implements IWebSocketServer {

    private Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private IWebSocketManager webSocketManager;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //用户标记
    private String userId;


    @OnOpen
    public void open(@PathParam("userId") String userId, Session session) {
        // 添加初始化操作
        logger.info("---初始化----userId:" + userId);
        this.session = session;

        //获取当前登录用户的id
        this.userId = userId;

        this.webSocketManager = WebSocketManager.getInstance();

        webSocketManager.addWebSocketServer(userId, this);     //加入map中
    }


    @OnMessage
    public abstract void getMessage(String message, Session session);


    @OnClose
    public void close() {
        // 添加关闭会话时的操作
        webSocketManager.removeWebSocketServer(userId);
        logger.info("用户" + userId + "的连接关闭！当前在线人数为" + webSocketManager.getOnlineCount());
    }


    @OnError
    public void error(Throwable t) {
        logger.info("websocket发生错误");
        t.printStackTrace();
    }


    public synchronized void sendMessageAsync(String message) {
        this.session.getAsyncRemote().sendText(message);//非阻塞式的
    }


    public synchronized void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMessage(String message, boolean isLast) {
        try {
            this.session.getBasicRemote().sendText(message, isLast);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Session getSession() {
        return session;
    }


    public String getUserId() {
        return userId;
    }


}
