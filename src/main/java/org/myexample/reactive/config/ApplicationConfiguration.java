package org.myexample.reactive.config;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;


//@Configuration
@EnableReactiveMongoRepositories
//@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
class ApplicationConfiguration extends AbstractReactiveMongoConfiguration {
    private final Environment environment;

    public ApplicationConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Override
    public MongoClient reactiveMongoClient() {
        int port = 27017;
        return MongoClients.create();
    }
   

    @Override
    protected String getDatabaseName() {
        return "Product";
    }
    
    
//    @Override
//	public MongoClient reactiveMongoClient() {
//		return MongoClients.create();
//	}

//	@Override
//	protected String getDatabaseName() {
//		return "jsa_mongodb";
//	}
}
