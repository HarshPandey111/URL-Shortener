package com.example.urlshortener.controller;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService service;

    @PostMapping("/shorten")
    public String shorten(@RequestParam String url) {
        UrlMapping mapping = service.shortenUrl(url);
        return "http://localhost:8080/" + mapping.getShortCode();
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code) {
        String originalUrl = service.getOriginalUrl(code);
        if (originalUrl != null) {
            return ResponseEntity.status(302).header("Location", originalUrl).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
