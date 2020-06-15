/**
 * 
 */
package com.haogenmin.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**  

* <p>Title: WebSocketConfiguration</p>  

* <p>Description: </p>  

* @author HaoGenmin 

* @date 2020年6月1日  

*/
@Configuration
public class WebSocketConfiguration {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
