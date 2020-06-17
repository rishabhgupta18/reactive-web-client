package com.reactive.web.client.reactivewebclient.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;

@Data
@AllArgsConstructor
public class Body {
    private Object content;
    private MediaType contentType;
}
