package com.naresh.UrlShortner;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
@Builder
public class UrlEntity {
    @Id
    private String shortUrl;
    private String longUrl;
    @Indexed( expireAfter = "30d")
    private LocalDate createdAt;


}
