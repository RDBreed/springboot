package com.xebia.myspringbootapp.endpoints;


import com.xebia.myspringbootapp.services.dao.RandomQuoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import com.xebia.myspringbootapp.model.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tomhofte on 06/01/2017.
 */
@RestController
public class RandomQuote {


    @Autowired @Qualifier("randomQuoteRESTImpl")
    RandomQuoteDAO randomQuoteDAO;


    @RequestMapping(method=RequestMethod.GET, path="/quote")
    public @ResponseBody Quote getQuote() {
        return randomQuoteDAO.getRandomQuote();
    }
}
