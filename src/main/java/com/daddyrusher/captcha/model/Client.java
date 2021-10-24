package com.daddyrusher.captcha.model;

public class Client {
    private final String id;
    private final long apiKeyExpire;

    public Client(String id, long apiKeyExpire) {
        this.id = id;
        this.apiKeyExpire = apiKeyExpire;
    }

    public String getId() {
        return id;
    }

    public long getApiKeyExpire() {
        return apiKeyExpire;
    }

    // TODO: add descriptive toString
}
