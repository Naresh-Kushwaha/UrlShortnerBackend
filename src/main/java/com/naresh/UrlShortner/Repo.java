package com.naresh.UrlShortner;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface Repo extends MongoRepository<UrlEntity,String> {
}
