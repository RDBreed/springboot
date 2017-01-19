package com.xebia.myspringbootapp.services;


import org.springframework.web.bind.annotation.*;
import com.xebia.myspringbootapp.model.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tomhofte on 06/01/2017.
 */
@RestController
public class RandomQuoteService {


    @RequestMapping(method=RequestMethod.GET, path="/quote")
    public @ResponseBody Quote getQuote() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }
}
