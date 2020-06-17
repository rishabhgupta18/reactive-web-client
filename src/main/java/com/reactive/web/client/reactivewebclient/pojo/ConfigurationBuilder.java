package com.reactive.web.client.reactivewebclient.pojo;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;


public class ConfigurationBuilder {

    public static URI buildURI(UriBuilder uriBuilder, URLConfig urlConfig) {
        UriBuilder builder = uriBuilder.path(urlConfig.getPath());
        if(urlConfig.getParameters()!=null){
            urlConfig.getParameters().forEach((parameterName, parameterValues) -> {
                builder.queryParam(parameterName, parameterValues);
            });
        }

        return urlConfig.getUrlVariables()!=null ? builder.build(urlConfig.getUrlVariables())
                :builder.build();
    }

    public static WebClient.RequestHeadersSpec buildSpec(WebClient.RequestHeadersSpec spec, URLConfig urlConfig) {
        return spec.accept(urlConfig.getBody().getContentType())
                .headers(httpHeaders -> {
                    if(urlConfig.getHeaders()!=null){
                        urlConfig.getHeaders().forEach(
                                (headerName, headerValue) -> {
                                    ((HttpHeaders) httpHeaders).add(headerName, headerValue);
                                }
                        );
                    }
                });
    }

}
