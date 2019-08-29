package com.haijiao.utils;

import com.haijiao.pojo.RequestMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoggerRepository extends MongoRepository<RequestMessage,String> {

}
