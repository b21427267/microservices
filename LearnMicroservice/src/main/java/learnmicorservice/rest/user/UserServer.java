package learnmicorservice.rest.user;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import learnmicorservice.repositories.user.UserRepository;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class UserServer {
    protected Logger logger = Logger.getLogger(UserServer.class.getName());
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "user-server");
        SpringApplication.run(UserServer.class, args);
    }
    
    @Bean
    public UserRepository userRepository() {
    	return new UserRepository();
    }
}
