package ie.com.keshav.gateway.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"ie.com.keshav.gateway.business",
		"ie.com.keshav.gateway.web"
})
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
@EnableMongoRepositories(basePackages = {
		"ie.com.keshav.gateway.business.repository"
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
