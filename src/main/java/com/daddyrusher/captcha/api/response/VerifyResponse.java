package com.daddyrusher.captcha.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerifyResponse {
    @JsonProperty
    private boolean success;
    @JsonProperty
    private String errorText;

    public VerifyResponse() {
    }

    public VerifyResponse(boolean success, String errorText) {
        this.success = success;
        this.errorText = errorText;
    }
}
