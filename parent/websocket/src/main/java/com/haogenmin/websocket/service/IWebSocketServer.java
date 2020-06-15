package com.haogenmin.websocket.service;

import javax.websocket.Session;
import javax.websocket.server.PathParam;

/**
 * @author Hao Genmin
 * @Title :IWebSocketServer
 * @description: WebSocketServer 的公用接口
 * @date 2020/6/13 16:49
 */

public interface IWebSocketServer {
    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    void open(@PathParam("userId") String userId, Session session);

    /**
     * 接受客户端的消息
     *
     * @param message 客户端发来的消息
     * @param session 客户端的会话
     */
    void getMessage(String message, Session session);


    /**
     * 连接关闭调用
     */
    void close();


    /**
     * 出现错误调用
     *
     * @param t
     */
    void error(Throwable t);


    /**
     * 异步发送消息
     *
     * @param message 要发送的消息
     */
    void sendMessageAsync(String message);

    /**
     * 同步发送消息
     *
     * @param message 要发送的消息
     */
    void sendMessage(String message);

    /**
     * 同步发送消息
     *
     * @param message 要发送的部分消息
     * @param isLast  发送的消息是不是最后一部分
     */
    void sendMessage(String message, boolean isLast);

    Session getSession();

    String getUserId();

}
