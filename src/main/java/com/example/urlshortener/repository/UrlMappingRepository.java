package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface jo UrlMapping entity ke liye hai
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    // Custom query method: shortCode se search karega
    UrlMapping findByShortCode(String shortCode);
}
