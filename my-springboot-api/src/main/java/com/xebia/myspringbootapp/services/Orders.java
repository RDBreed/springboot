package com.xebia.myspringbootapp.services;

import org.springframework.web.bind.annotation.*;
import com.xebia.myspringbootapp.model.Order;

/**
 * Created by tomhofte on 21/12/2016.
 */

@RestController
public class Orders {

    @RequestMapping(method=RequestMethod.GET, path="/orders/{id}")
    public @ResponseBody Order getOrder(@PathVariable  int id){
        return new Order(id, "testProduct", 1);
    }


}

