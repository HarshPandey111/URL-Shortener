package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository repository;

    public UrlMapping shortenUrl(String originalUrl) {
        String code = generateCode();
        UrlMapping mapping = new UrlMapping(originalUrl, code);
        return repository.save(mapping);
    }

    public String getOriginalUrl(String code) {
        UrlMapping mapping = repository.findByShortCode(code);
        return (mapping != null) ? mapping.getOriginalUrl() : null;
    }

    private String generateCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return code.toString();
    }
}
