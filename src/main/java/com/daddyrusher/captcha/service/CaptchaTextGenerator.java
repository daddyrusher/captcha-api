package com.daddyrusher.captcha.service;

/**
 * Генератор текста
 */
public interface CaptchaTextGenerator extends TextGenerator {
    String generate(int textLength);
}
