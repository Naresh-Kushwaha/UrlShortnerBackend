package com.naresh.UrlShortner;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final Repo repo;
    private final RedisTemplate<String,String> redisTemplate;
    private  AtomicInteger counter=new AtomicInteger(0);
    private static final int EXPIRATIOIN_DAYS=1;
    @Value("${backend.url}")
    String url;

    public  String generateHash(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString().substring(0,4)+counter.incrementAndGet();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }

    public String shortenUrl(String originalUrl){

        String shortUrl=generateHash(originalUrl);
        redisTemplate.opsForValue().set(shortUrl,originalUrl,EXPIRATIOIN_DAYS, TimeUnit.DAYS);
        repo.save( UrlEntity.builder()
                .shortUrl(shortUrl)
                .longUrl(originalUrl)
                .createdAt(LocalDateTime.now())
                .build());
        return url+shortUrl;
    }
    public String getOriginalUrl(String shortUrl){

      String orinalUrl=  redisTemplate.opsForValue().get(shortUrl);
      if(orinalUrl==null){
          System.out.println("datafrom mongodb");
          orinalUrl=repo.findById(shortUrl).get().getLongUrl();
          redisTemplate.opsForValue().set(shortUrl,orinalUrl,EXPIRATIOIN_DAYS, TimeUnit.DAYS);
      }

        return orinalUrl ;
    }
}
