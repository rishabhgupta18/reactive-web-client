package com.reactive.web.client.reactivewebclient.handler;

import com.reactive.web.client.reactivewebclient.pojo.URLConfig;
import org.springframework.web.reactive.function.client.WebClient;

public interface IRESTHandler {

    public WebClient.RequestHeadersSpec get(URLConfig urlConfig);
    public WebClient.RequestHeadersSpec post(URLConfig urlConfig);
    public WebClient.RequestHeadersSpec put(URLConfig urlConfig);
    public WebClient.RequestHeadersSpec delete(URLConfig urlConfig);
}
