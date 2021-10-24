package com.daddyrusher.captcha.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterResponse {
    @JsonProperty("secret")
    private String secretKey;
    @JsonProperty("public")
    private String publicKey;

    public String getSecretKey() {
        return secretKey;
    }

    public RegisterResponse(String secretKey, String publicKey) {
        this.secretKey = secretKey;
        this.publicKey = publicKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
