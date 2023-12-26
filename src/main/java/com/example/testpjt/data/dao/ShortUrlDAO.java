package com.example.testpjt.data.dao;

import com.example.testpjt.data.entity.ShortUrlEntity;

public interface ShortUrlDAO {

    ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity);

    ShortUrlEntity getShortUrl(String originalUrl);

//    ShortUrlEntity getOriginalUrl(String shortUrl);

    void deleteByShortUrl(String shortUrl);

    void deleteByOriginalUrl(String originalUrl);

}
