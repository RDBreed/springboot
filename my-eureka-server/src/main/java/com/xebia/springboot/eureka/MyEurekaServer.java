package com.xebia.springboot.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by tomhofte on 19/01/2017.
 */
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MyEurekaServer.class).web(true).run(args);
    }

}