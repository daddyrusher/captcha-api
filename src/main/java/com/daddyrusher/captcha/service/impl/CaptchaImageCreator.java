package com.daddyrusher.captcha.service.impl;

import com.daddyrusher.captcha.exception.CaptchaException;
import com.daddyrusher.captcha.service.CaptchaTextGenerator;
import com.daddyrusher.captcha.service.ImageCreator;
import jakarta.inject.Singleton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Создатель картинки капчи
 */
@Singleton
public class CaptchaImageCreator implements ImageCreator {
    private static final int DEFAULT_WIDTH = 150;
    private static final int DEFAULT_HEIGHT = 40;
    private static final String DEFAULT_IMAGE = "captcha";
    private static final String IMAGE_FORMAT = "jpeg";
    private static final String IMAGE_EXTENSION = "." + IMAGE_FORMAT;
    private final CaptchaTextGenerator textGenerator;

    public CaptchaImageCreator(CaptchaTextGenerator textGenerator) {
        this.textGenerator = textGenerator;
    }

    @Override
    public File asFile() {
        try {
            var file = Files.createTempFile(DEFAULT_IMAGE, IMAGE_EXTENSION).toFile();
            try (var fileOutputStream = new FileOutputStream(file)) {
                fileOutputStream.write(writeImage(createImage()));
                file.deleteOnExit();
                return file;
            }
        } catch (IOException e) {
            throw new CaptchaException(e.getMessage());
        }
    }

    @Override
    public byte[] asBytes() {
        return writeImage(createImage());
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, Transparency.OPAQUE);
        Graphics graphics = image.createGraphics();

        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.setColor(new Color(169, 169, 169));
        graphics.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        graphics.setColor(new Color(255, 255, 255));
        graphics.drawString(textGenerator.generate(), 40, 25);
        return image;
    }

    private byte[] writeImage(BufferedImage image) {
        try (var byteArrayOutputStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, IMAGE_FORMAT, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new CaptchaException("Can't generate captcha: " + e.getMessage(), e);
        }
    }
}
