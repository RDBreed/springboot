package com.xebia.myspringbootapp;

import com.xebia.myspringbootapp.endpoints.RandomQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanTextMap;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.web.HttpSpanExtractor;
import org.springframework.cloud.sleuth.instrument.web.HttpSpanInjector;
import org.springframework.cloud.sleuth.instrument.web.ZipkinHttpSpanInjector;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.sleuth.util.TextMapUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@EnableCircuitBreaker
    @SpringBootApplication
    public class MySpringBootAppMain {

    private static Logger log = LoggerFactory.getLogger(RandomQuote.class);;


    public static void main(String[] args) {
            SpringApplication.run(MySpringBootAppMain.class, args);
        }
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    static class CustomHttpSpanExtractor implements HttpSpanExtractor {

        @Override
        public Span joinTrace(SpanTextMap carrier) {
            Map<String, String> map = TextMapUtil.asMap(carrier);

            Random random = new Random();
            Span.SpanBuilder builder;

            // extract all necessary headers
            //conversationId and messageId found in the header
            log.debug("Found trace information: conversationid "+map.get("conversationid")+" and messageid: "+map.get("messageid"));
            if (map.get("conversationid") != null && map.get("messageid") != null) {
                long traceId = Span.hexToId(map.get("conversationid"));
                long spanId = Span.hexToId(map.get("messageid"));
                builder = Span.builder().traceId(traceId).spanId(spanId);
                log.debug("All Trace information found in the header");
                return builder.build();
            }
            //Only conversationid found;generate a new message id
            else if(map.get("conversationid") != null)
                     {
                long traceId = Span.hexToId(map.get("conversationid"));
                builder = Span.builder().traceId(traceId).spanId(traceId);
                log.debug("Only conversation id Trace information found in the header");
                return builder.build();
            }
            else {
                log.debug("No trace information found in the header -- initialize new span");
                return null;
            }

        }
    }

    static class CustomHttpSpanInjector implements HttpSpanInjector {

        @Override
        public void inject(Span span, SpanTextMap carrier) {
            carrier.put("conversationid", span.traceIdString());
            carrier.put("messageid", Span.idToHex(span.getSpanId()));
        }
    }
/*

    @Bean
    HttpSpanInjector customHttpSpanInjector() {
        return new CustomHttpSpanInjector();
    }

    @Bean
    HttpSpanExtractor customHttpSpanExtractor() {
        return new CustomHttpSpanExtractor();
    }
*/

}

