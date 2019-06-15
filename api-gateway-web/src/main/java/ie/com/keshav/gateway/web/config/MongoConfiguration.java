package ie.com.keshav.gateway.web.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Amit Tank
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    private final String dbName;
    private final String uri;

    public MongoConfiguration(@Value("${azure.mongo.db-name}") String dbName,
                              @Value("${azure.mongo.uri}") String uri) {
        this.dbName = dbName;
        this.uri = uri;
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(uri));
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
