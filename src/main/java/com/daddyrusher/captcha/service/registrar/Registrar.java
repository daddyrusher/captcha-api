package com.daddyrusher.captcha.service.registrar;

import com.daddyrusher.captcha.model.Client;

public interface Registrar {
    void registering(Client client);

    Client retrieveClient(String id);
}
