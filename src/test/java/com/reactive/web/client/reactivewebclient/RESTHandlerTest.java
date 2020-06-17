package com.reactive.web.client.reactivewebclient;

import com.reactive.web.client.reactivewebclient.handler.RESTHandler;
import com.reactive.web.client.reactivewebclient.pojo.URLConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

public class RESTHandlerTest {
    static final String BASE_URL = "http://cookie.jsontest.com/";
    RESTHandler restHandler;
    URLConfig urlConfig;


    @BeforeEach
    public void setUp(){
        restHandler = new RESTHandler(BASE_URL);
        urlConfig = new URLConfig();
    }

    @Test
    public void getTest(){

        String expectedResponse = "{\"cookie_status\": \"Cookie set with name jsontestdotcom\"}\n";

        Mono<String> monoResponse = restHandler.get(urlConfig)
        .retrieve()
        .bodyToMono(String.class);

        StepVerifier.create(monoResponse.log())
                .expectSubscription()
                .expectNextMatches(response -> {
                    return response.equals(expectedResponse);
                })
                .verifyComplete();
    }

}
