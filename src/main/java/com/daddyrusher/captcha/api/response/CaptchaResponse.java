package com.daddyrusher.captcha.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaResponse {
    @JsonProperty("request")
    private final String captchaTestNumber;
    private final String answer;

    public CaptchaResponse(String captchaTestNumber, String answer) {
        this.captchaTestNumber = captchaTestNumber;
        this.answer = answer;
    }
}
