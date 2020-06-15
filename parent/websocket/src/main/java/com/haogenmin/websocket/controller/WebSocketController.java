package com.haogenmin.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：HaoGenmin
 * @Title :WebSocketController
 * @date ：Created in 2020/6/15 9:39
 * @description：
 */
@Controller
public class WebSocketController {
    @RequestMapping("/")
    public String hello() {
        return "test";
    }
}
