package com.dmux.jarnbjorn.controller;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/secured", produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordGenerationController {

    @Autowired
    private PasswordEncoder oauthClientPasswordEncoder;

    @GetMapping(value = "/generate/{input}")
    public @ResponseBody String getEncryptedPassowrd(@PathVariable("input") String input){
        return oauthClientPasswordEncoder.encode(input);
    }
    @GetMapping(value = "/generate/sha/{input}")
    public @ResponseBody String getSha(@PathVariable("input") String input){
        return Hashing.sha256()
                .hashString(input, StandardCharsets.UTF_8)
                .toString();
    }

}