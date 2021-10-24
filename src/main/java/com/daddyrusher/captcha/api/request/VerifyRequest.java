package com.daddyrusher.captcha.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerifyRequest {
    @JsonProperty
    private String secret;
    @JsonProperty
    private String response;

    public String getSecret() {
        return secret;
    }

    public String getResponse() {
        return response;
    }
}
