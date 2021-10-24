package com.daddyrusher.captcha.api;

import com.daddyrusher.captcha.api.request.SolveRequest;
import com.daddyrusher.captcha.api.request.VerifyRequest;
import com.daddyrusher.captcha.api.response.CaptchaResponse;
import com.daddyrusher.captcha.api.response.SolveResponse;
import com.daddyrusher.captcha.api.response.VerifyResponse;
import com.daddyrusher.captcha.service.ImageCreator;
import com.daddyrusher.captcha.service.registrar.Registrar;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.io.IOException;

@Controller("/captcha")
public class CaptchaController {
    private final ImageCreator imageCreator;
    private final Registrar registrar;

    public CaptchaController(ImageCreator imageCreator, Registrar registrar) {
        this.imageCreator = imageCreator;
        this.registrar = registrar;
    }

    @Get("/new")
    public Object createCaptcha(@RequestAttribute("public") String publicKey) {
        boolean hasClient = registrar.retrieveClient(publicKey) != null;

        if (hasClient) {
            // TODO: implement answer service
            return new CaptchaResponse("1", "42");
        }

        return HttpResponse.notFound("Client not found");
    }

    @Get("/image")
    public Object image(@RequestAttribute("public") String publicKey,
                        @RequestAttribute("request") String captchaTest) throws IOException {

        // TODO: think about saving image to repository or local storage
        return HttpResponse
                .ok(imageCreator.asBytes())
                .contentType(MediaType.IMAGE_JPEG_TYPE);
    }

    @Post("/solve")
    public Object solve(@Body SolveRequest request) {
        // TODO: implement captcha test solver
        return new SolveResponse();
    }

    @Get("/verify")
    public Object verify(VerifyRequest request) {
        return new VerifyResponse(true, "no error");
    }
}
