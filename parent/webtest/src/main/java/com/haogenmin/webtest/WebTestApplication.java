package com.haogenmin.webtest;

import com.haogenmin.websocket.manager.impl.WebSocketManager;
import com.haogenmin.websocket.service.impl.WebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：HaoGenmin
 * @Title :WebTestApplication
 * @date ：Created in 2020/6/13 17:19
 * @description：
 */
@SpringBootApplication
@ComponentScan({"com.haogenmin.websocket","com.haogenmin.webtest"})
public class WebTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebTestApplication.class,args);
    }
}
