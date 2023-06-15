package com.pfma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.sql.DataSource;


@Configuration
@EnableMongoRepositories(
  basePackages = "com.pfma.repository",
  mongoTemplateRef = "mongoTemplate"
)
public class MongoConfig {

  @Primary
  @Bean
  @ConfigurationProperties(prefix="spring.seconddb")
  public DataSource userDataSource() {
    return DataSourceBuilder.create().build();
  }
  // userEntityManager bean

  // userTransactionManager bean
}
