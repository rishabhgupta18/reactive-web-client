package com.reactive.web.client.reactivewebclient.pojo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class URLConfig {

    @NonNull
    private String path;
    private String[] urlVariables;
    private Map<String, String[]> parameters;
    private Map<String, String> headers;
    private Body body = new Body(null, MediaType.APPLICATION_JSON);


}
