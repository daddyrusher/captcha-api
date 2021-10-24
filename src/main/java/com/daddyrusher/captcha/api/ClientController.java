package com.daddyrusher.captcha.api;

import com.daddyrusher.captcha.api.response.RegisterResponse;
import com.daddyrusher.captcha.model.Client;
import com.daddyrusher.captcha.service.KeyGenerator;
import com.daddyrusher.captcha.service.TextGenerator;
import com.daddyrusher.captcha.service.registrar.Registrar;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/client")
public class ClientController {
    private final TextGenerator keyGenerator;
    private final Registrar registrar;

    public ClientController(KeyGenerator keyGenerator, Registrar registrar) {
        this.keyGenerator = keyGenerator;
        this.registrar = registrar;
    }

    @Post("/register")
    public Object register() {
        var secretKey = keyGenerator.generate();
        var publicKey = keyGenerator.generate();
        var client = new Client(secretKey, 30);

        registrar.registering(client);
        return new RegisterResponse(secretKey, publicKey);
    }
}
