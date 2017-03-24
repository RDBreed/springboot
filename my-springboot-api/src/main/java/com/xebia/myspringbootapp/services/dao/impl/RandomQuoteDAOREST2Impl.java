package com.xebia.myspringbootapp.services.dao.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xebia.myspringbootapp.model.Quote;
import com.xebia.myspringbootapp.model.Value;
import com.xebia.myspringbootapp.services.dao.RandomQuoteDAO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tomhofte on 13/03/2017.
 */
@Service("randomQuoteREST2Impl")
public class RandomQuoteDAOREST2Impl implements RandomQuoteDAO {

    private final RestTemplate restTemplate;

    public RandomQuoteDAOREST2Impl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @HystrixCommand(commandKey = "RandomQuote2", groupKey = "dummyService", fallbackMethod = "dummyQuoteFallback")
    public Quote getRandomQuote(){
        Quote quote = restTemplate.getForObject("http://rest2-gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }

    public Quote dummyQuoteFallback(){
        Quote dummyQuote = new Quote();
        dummyQuote.setType("dummyQuote");
        Value value = new Value();
        value.setId(new Long(1));
        value.setQuote("This is a dummy quote");
        dummyQuote.setValue(value);
        return dummyQuote;
    }
}
