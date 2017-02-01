package com.xebia.springboot.services;

import com.xebia.springboot.model.Bookmark;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tomhofte on 31/01/2017.
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class BookmarkService {

        @RequestMapping(method= RequestMethod.GET, path="{username}/bookmarks")
        public @ResponseBody
        Bookmark getBookmarks(@PathVariable String username){

            return new Bookmark(username,"Test Label", "http://www.google.com", "Google Search Home Page", 0);
        }

    public static void main(String[] args) {
        SpringApplication.run(BookmarkService.class, args);
    }

    }
