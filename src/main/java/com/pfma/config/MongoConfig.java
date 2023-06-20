package com.pfma.config;

import com.pfma.repository.OperationRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = OperationRepository.class)
@Configuration
public class MongoConfig {

}