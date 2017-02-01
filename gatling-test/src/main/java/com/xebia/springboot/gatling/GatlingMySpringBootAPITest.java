package com.xebia.springboot.gatling;


import io.gatling.core.*;
import io.gatling.http.*;
import scala.concurrent.duration.*;

/**
 * Created by tomhofte on 24/01/2017.
 */
public class GatlingMySpringBootAPITest {

        val httpConf = http // 4
                .baseURL("http://computer-database.gatling.io") // 5
                .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
                .doNotTrackHeader("1")
                .acceptLanguageHeader("en-US,en;q=0.5")
                .acceptEncodingHeader("gzip, deflate")
                .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

        val scn = scenario("BasicSimulation") // 7
                .exec(http("request_1")  // 8
                        .get("/")) // 9
                .pause(5) // 10

        setUp( // 11
               scn.inject(atOnceUsers(1)) // 12
                ).protocols(httpConf) // 13
    }
}
