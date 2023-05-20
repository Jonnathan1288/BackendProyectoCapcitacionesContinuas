package com.capacitaciones.continuas.emailValidator.Controller;

import com.capacitaciones.continuas.emailValidator.Dto.ZeroBounceResponse;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class ZeroBounceController {
    private static final String ZEROBOUNCE_API_URL = "https://api.zerobounce.net/v2/validate";
    private static final String ZEROBOUNCE_API_KEY = "fe6fd8a03fbc4a73939ac55f783569b3";
    private static final Gson gson = new Gson();
    private static final OkHttpClient httpClient = new OkHttpClient();

    @GetMapping("/validate-email/{email}")
    public ZeroBounceResponse validateEmail(@PathVariable String email) throws Exception {
        String url = ZEROBOUNCE_API_URL + "?api_key=" + ZEROBOUNCE_API_KEY + "&email=" + email;
        Request request = new Request.Builder().url(url).build();
        Response response = httpClient.newCall(request).execute();

        ZeroBounceResponse zeroBounceResponse = gson.fromJson(response.body().string(), ZeroBounceResponse.class);
        return zeroBounceResponse;
    }
}