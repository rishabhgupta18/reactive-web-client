package com.reactive.web.client.reactivewebclient.handler;

import com.reactive.web.client.reactivewebclient.pojo.ConfigurationBuilder;
import com.reactive.web.client.reactivewebclient.pojo.URLConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class RESTHandler implements IRESTHandler {

    private WebClient webClient;

    public RESTHandler() {
        this.webClient = WebClient.create();
    }

    public RESTHandler(String baseUrl) {
        this.webClient = WebClient.create(baseUrl);
    }

    @Override
    public WebClient.RequestHeadersSpec get(URLConfig urlConfig) {
        return ConfigurationBuilder.buildSpec(webClient.get()
                        .uri(uriBuilder ->
                                ConfigurationBuilder.buildURI(uriBuilder, urlConfig)),
                urlConfig);


    }

    @Override
    public WebClient.RequestHeadersSpec post(URLConfig urlConfig) {
        return ((WebClient.RequestBodySpec) webClient.post()
                .uri(uriBuilder ->
                        ConfigurationBuilder.buildURI(uriBuilder, urlConfig)))
                .bodyValue(urlConfig.getBody().getContent());
    }

    @Override
    public WebClient.RequestHeadersSpec put(URLConfig urlConfig) {
        return ((WebClient.RequestBodySpec) webClient.put()
                .uri(uriBuilder ->
                        ConfigurationBuilder.buildURI(uriBuilder, urlConfig)))
                .bodyValue(urlConfig.getBody().getContent());
    }

    @Override
    public WebClient.RequestHeadersSpec delete(URLConfig urlConfig) {
        return ((WebClient.RequestBodySpec) webClient.delete()
                .uri(uriBuilder ->
                        ConfigurationBuilder.buildURI(uriBuilder, urlConfig)));
    }


    class Retrieve {

        RESTHandler restHandler;

        public Retrieve() {
            restHandler = new RESTHandler();
        }

        public Retrieve(String baseUrl) {
            restHandler = new RESTHandler(baseUrl);
        }


        public WebClient.ResponseSpec get(URLConfig urlConfig) {
            return restHandler.get(urlConfig).retrieve();
        }

        public WebClient.ResponseSpec post(URLConfig urlConfig) {
            return restHandler.post(urlConfig).retrieve();
        }

        public WebClient.ResponseSpec put(URLConfig urlConfig) {
            return restHandler.put(urlConfig).retrieve();
        }

        public WebClient.ResponseSpec delete(URLConfig urlConfig) {
            return restHandler.delete(urlConfig).retrieve();
        }

    }


    class Exchange {

        RESTHandler restHandler;

        public Exchange() {
            restHandler = new RESTHandler();
        }

        public Exchange(String baseUrl) {
            restHandler = new RESTHandler(baseUrl);
        }


        public Mono<ClientResponse> get(URLConfig urlConfig) {
            return restHandler.get(urlConfig).exchange();
        }

        public Mono<ClientResponse> post(URLConfig urlConfig) {
            return restHandler.post(urlConfig).exchange();
        }

        public Mono<ClientResponse> put(URLConfig urlConfig) {
            return restHandler.put(urlConfig).exchange();
        }

        public Mono<ClientResponse> delete(URLConfig urlConfig) {
            return restHandler.delete(urlConfig).exchange();
        }

    }


}
