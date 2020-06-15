package com.haogenmin.websocket.manager;

import com.haogenmin.websocket.service.IWebSocketServer;

/**
 * @author ：HaoGenmin
 * @Title :IWebSocketManager
 * @date ：Created in 2020/6/13 16:56
 * @description： websocket 管理器接口
 */
public interface IWebSocketManager {
    /**
     * 返回在线人数
     *
     * @return
     */
    int getOnlineCount();

    /**
     * 给所有在线用户发消息，ConcurrentHashMap可以一边遍历一遍删除元素，内部已经做了维护
     *
     * @param message 要发送的消息
     */
    void sendMessageToAll(String message);

    /**
     * 给单个用户发消息
     *
     * @param userId  用户账户
     * @param message 消息
     */
    void sendMessageToOne(String userId, String message);

    /**
     * 给管理器添加一个新的websocket连接
     *
     * @param userId          新连接的用户
     * @param webSocketServer 连接
     */
    void addWebSocketServer(String userId, IWebSocketServer webSocketServer);

    /**
     * 移除一个websocket连接
     *
     * @param userId 需要移除连接的账户
     */
    void removeWebSocketServer(String userId);
}
