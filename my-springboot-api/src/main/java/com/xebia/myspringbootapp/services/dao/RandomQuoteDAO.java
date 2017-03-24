package com.xebia.myspringbootapp.services.dao;

import com.xebia.myspringbootapp.model.Quote;

/**
 * Created by tomhofte on 17/03/2017.
 */
public interface RandomQuoteDAO {

    public Quote getRandomQuote();
}
