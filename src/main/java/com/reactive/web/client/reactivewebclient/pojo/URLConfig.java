package com.reactive.web.client.reactivewebclient.pojo;

import lombok.*;
import org.springframework.http.MediaType;

import java.util.Map;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class URLConfig {

    @NonNull
    private String path;
    private Object[] urlVariables;
    private Map<String, Object[]> parameters;
    private Map<String, String> headers;
    private Body body = new Body(null, MediaType.APPLICATION_JSON);

    public URLConfig setPath(String path) {
        this.path = path;
        return this;
    }

    public URLConfig setUrlVariables(String[] urlVariables) {
        this.urlVariables = urlVariables;
        return this;
    }

    public URLConfig setParameters(Map<String, Object[]> parameters) {
        this.parameters = parameters;
        return this;
    }

    public URLConfig setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public URLConfig setBody(Body body) {
        this.body = body;
        return this;
    }
}
