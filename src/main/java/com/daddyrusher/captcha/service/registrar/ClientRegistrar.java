package com.daddyrusher.captcha.service.registrar;

import com.daddyrusher.captcha.model.Client;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class ClientRegistrar implements Registrar {
    private final Map<String, Client> clients = new ConcurrentHashMap<>();

    // TODO:

    @Override
    public void registering(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public Client retrieveClient(String id) {
        return clients.get(id);
    }
}
