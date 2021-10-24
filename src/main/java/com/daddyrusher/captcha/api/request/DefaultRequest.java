package com.daddyrusher.captcha.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultRequest {
    @JsonProperty("public")
    private String publicKey;

    public String getPublicKey() {
        return publicKey;
    }
}
