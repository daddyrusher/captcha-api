package com.daddyrusher.captcha.service;

import java.io.File;
import java.io.IOException;

public interface ImageCreator {
    File asFile() throws IOException;

    byte[] asBytes() throws IOException;
}
