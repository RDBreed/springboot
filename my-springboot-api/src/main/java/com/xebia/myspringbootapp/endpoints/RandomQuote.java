package com.xebia.myspringbootapp.endpoints;


import com.xebia.myspringbootapp.services.dao.RandomQuoteDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import com.xebia.myspringbootapp.model.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tomhofte on 06/01/2017.
 */
@RestController
public class RandomQuote {

    private static Logger log = LoggerFactory.getLogger(RandomQuote.class);

    @Autowired @Qualifier("randomQuoteRESTImpl")
    RandomQuoteDAO randomQuoteDAO;


    @RequestMapping(method=RequestMethod.GET, path="/quote")
    @NewSpan
    public @ResponseBody Quote getQuote() {
        log.info("Invoke RandomQuote");
        return randomQuoteDAO.getRandomQuote();

    }
}
