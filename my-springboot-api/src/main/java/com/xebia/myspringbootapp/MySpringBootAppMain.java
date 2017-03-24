package com.xebia.myspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



    @EnableCircuitBreaker
    @SpringBootApplication
    public class MySpringBootAppMain {


        public static void main(String[] args) {
            SpringApplication.run(MySpringBootAppMain.class, args);
        }

    }

