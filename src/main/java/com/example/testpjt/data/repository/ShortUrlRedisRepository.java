package com.example.testpjt.data.repository;

import com.example.testpjt.data.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRedisRepository  extends JpaRepository<ShortUrlEntity, Long> {

    ShortUrlEntity findByUrl(String url);

    ShortUrlEntity findByOrgUrl(String originalUrl);
}
