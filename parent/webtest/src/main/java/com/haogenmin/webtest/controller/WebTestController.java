package com.haogenmin.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author ：HaoGenmin
 * @Title :WebTestController
 * @date ：Created in 2020/6/13 17:24
 * @description：
 */
@Controller
public class WebTestController {
    @RequestMapping("/test")
    public String index(Map<String, Object> map) {
        return "test";
    }
}
