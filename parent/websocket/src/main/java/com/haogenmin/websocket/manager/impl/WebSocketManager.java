package com.haogenmin.websocket.manager.impl;

import com.haogenmin.websocket.manager.IWebSocketManager;
import com.haogenmin.websocket.service.IWebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：HaoGenmin
 * @Title :WebSocketManager
 * @date ：Created in 2020/6/13 16:57
 * @description：
 */
public class WebSocketManager implements IWebSocketManager {
    private static final WebSocketManager instance = new WebSocketManager();

    private WebSocketManager() {
    }

    public static WebSocketManager getInstance() {
        return instance;
    }

    private Logger logger = LoggerFactory.getLogger(WebSocketManager.class);

    // 存放客户端的socket
    private ConcurrentHashMap<String, IWebSocketServer> webSocketMap = new ConcurrentHashMap<String, IWebSocketServer>();

    @Override
    public int getOnlineCount() {
        return webSocketMap.size();
    }

    @Override
    public void sendMessageToAll(String message) {
        for (Map.Entry<String, IWebSocketServer> entry : webSocketMap.entrySet()) {
            IWebSocketServer webSocketServer = entry.getValue();
            if (webSocketServer.getSession().isOpen()) {
                webSocketServer.sendMessageAsync(message);
            } else {
                logger.info("与账号" + entry.getKey() + "的websocket连接已经关闭，执行删除连接操作！");
                webSocketMap.remove(entry.getKey(), entry.getValue());
            }
        }

    }

    @Override
    public void sendMessageToOne(String userId, String message) {
        IWebSocketServer webSocketServer = webSocketMap.get(userId);
        if (webSocketServer == null) {
            logger.info("没有与账号" + userId + "的websocket连接！");
            return;
        }
        if (webSocketServer.getSession().isOpen()) {
            webSocketServer.sendMessageAsync(message);
        } else {
            logger.info("与账号" + userId + "的websocket连接已经关闭，执行删除连接操作！");
            webSocketMap.remove(userId);
        }
    }

    @Override
    public void addWebSocketServer(String userId, IWebSocketServer webSocketServer) {
        webSocketMap.put(userId, webSocketServer);
    }

    @Override
    public void removeWebSocketServer(String userId) {
        webSocketMap.remove(userId);

    }
}
