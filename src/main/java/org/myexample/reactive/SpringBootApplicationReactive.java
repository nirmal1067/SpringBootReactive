package org.myexample.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
//(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})

public class SpringBootApplicationReactive {
	
	
    public static void main(String[] args)
    {
    	SpringApplication.run(SpringBootApplicationReactive.class, args);
    }

}
