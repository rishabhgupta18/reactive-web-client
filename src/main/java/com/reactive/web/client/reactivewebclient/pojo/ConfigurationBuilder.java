package com.reactive.web.client.reactivewebclient.pojo;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;


public class ConfigurationBuilder {

    public static URI buildURI(UriBuilder uriBuilder, URLConfig urlConfig) {
        UriBuilder builder = uriBuilder.path(urlConfig.getPath());
        urlConfig.getParameters().forEach((parameterName, parameterValues) -> {
            builder.queryParam(parameterName, (String[]) parameterValues);
        });
        return builder.build((String[])urlConfig.getUrlVariables());
    }

    public static WebClient.RequestHeadersSpec buildSpec(WebClient.RequestHeadersSpec spec, URLConfig urlConfig) {
        return spec.accept(urlConfig.getBody().getContentType())
                .headers(httpHeaders -> {
                    urlConfig.getHeaders().forEach(
                            (headerName, headerValue) -> {
                                ((HttpHeaders) httpHeaders).add(headerName, headerValue);
                            }
                    );
                });
    }

}
