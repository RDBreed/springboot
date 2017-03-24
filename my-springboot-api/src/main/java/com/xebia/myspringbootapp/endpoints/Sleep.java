package com.xebia.myspringbootapp.endpoints;

import org.springframework.web.bind.annotation.*;

/**
 * Created by tomhofte on 21/12/2016.
 */

@RestController
public class Sleep {

    @RequestMapping(method=RequestMethod.GET, path="/sleep")
    public void sleep(@RequestParam("time") long time){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
