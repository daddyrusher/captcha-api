package com.daddyrusher.captcha.service.impl;

import com.daddyrusher.captcha.service.CaptchaTextGenerator;
import jakarta.inject.Singleton;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

/**
 * Генератор текста для капчи
 */
@Singleton
public class DefaultCaptchaTextGenerator implements CaptchaTextGenerator {
    private static final int INITIAL_LENGTH = 6;
    private static final Random RANDOM = new SecureRandom();
    private static final String DIGITS = "0123456789";
    private static final String UPPER_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SYMBOLS = DIGITS + UPPER_LETTERS + UPPER_LETTERS.toLowerCase(Locale.ROOT);

    @Override
    public String generate() {
        return generate(INITIAL_LENGTH);
    }

    @Override
    public String generate(int textLength) {
        var builder = new StringBuilder();
        int counter = Math.max(textLength, INITIAL_LENGTH);
        for(int i = 0; i < counter; i++) {
            builder.append(SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length())));
        }
        return builder.toString();
    }
}
