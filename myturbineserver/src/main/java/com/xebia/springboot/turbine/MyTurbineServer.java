package com.xebia.springboot.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by tomhofte on 19/01/2017.
 */
@SpringBootApplication
@EnableTurbine
public class MyTurbineServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MyTurbineServer.class).web(true).run(args);
    }

}