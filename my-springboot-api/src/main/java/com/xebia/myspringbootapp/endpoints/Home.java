package com.xebia.myspringbootapp.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.UUID;

/**
 * Created by tomhofte on 12/07/2017.
 */
@RestController
public class Home {

    private static Logger log = LoggerFactory.getLogger(Home.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired Tracer tracer;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/home")
    public String home() {
        log.info("you called home");
        return "Hello World";
    }

    @RequestMapping("/callhome")
    @NewSpan
    public String callHome() {
        log.debug("In calling home");
        log.debug("Set Bagage Item Tag");
        Span span = tracer.getCurrentSpan();
        String convId= UUID.randomUUID().toString();
        span.setBaggageItem("X-IRIS-CONVID", convId);
        tracer.addTag("X-IRIS-CONVID", convId);
        MDC.put("X-IRIS-CONVID", convId);
        tracer.continueSpan(span);
        return restTemplate.getForObject("http://localhost:5000/home", String.class);
    }
}
