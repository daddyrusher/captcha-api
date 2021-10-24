package com.daddyrusher.captcha.service.impl;

import com.daddyrusher.captcha.service.KeyGenerator;
import jakarta.inject.Singleton;

import java.util.UUID;

/**
 * Генератор ключей для запросов/ответов
 */
@Singleton
public class DefaultKeyGenerator implements KeyGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
