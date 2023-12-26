package com.example.testpjt.data.dao.impl;

import com.example.testpjt.data.dao.ShortUrlDAO;
import com.example.testpjt.data.entity.ShortUrlEntity;
import com.example.testpjt.data.repository.ShortUrlRedisRepository;
import com.example.testpjt.data.repository.ShortUrlRepository;
import com.example.testpjt.service.impl.RestTemplateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {

    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public  ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity){
        ShortUrlEntity foundshortUrlEntity = shortUrlRepository.save(shortUrlEntity);
        return  foundshortUrlEntity;
    }

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl){
        ShortUrlEntity foundshortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        return  foundshortUrlEntity;
    }

    @Override
    public void deleteByShortUrl(String shortUrl){
        // 삭제할 값이 없는 경우 여기서 Null Entity 반환받게 됨
        ShortUrlEntity foundshortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        shortUrlRepository.delete(foundshortUrlEntity);
    }

    @Override
    public void deleteByOriginalUrl(String originalUrl){
        ShortUrlEntity foundshortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        shortUrlRepository.delete(foundshortUrlEntity);
    }
}
