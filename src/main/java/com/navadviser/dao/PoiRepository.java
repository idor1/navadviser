package com.navadviser.dao;

import com.navadviser.entity.PoI;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PoiRepository extends MongoRepository<PoI, String>{
}
