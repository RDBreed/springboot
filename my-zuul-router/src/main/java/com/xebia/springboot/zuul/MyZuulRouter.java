package com.xebia.springboot.zuul;

/**
 * Created by tomhofte on 19/01/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MyZuulRouter {

    public static void main(String[] args) {
        SpringApplication.run(MyZuulRouter.class, args);
    }
}