package com.daddyrusher.captcha.api.request;

public class SolveRequest extends DefaultRequest {
    private String request;
    private String answer;

    public String getRequest() {
        return request;
    }

    public String getAnswer() {
        return answer;
    }
}
