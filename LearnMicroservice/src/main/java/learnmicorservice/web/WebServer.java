package learnmicorservice.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "learnmicroservice")
public class WebServer {
    public static final String USER_SERVICE_URL = "http://user-service";
    public static final String PHONENUMBER_SERVICE_URL = "http://phonenumber-service";
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public UserWebService userService() {
        return new UserWebService(USER_SERVICE_URL);
    }
    @Bean
    public WebController webController() {
        return new WebController(userService(), phonenumberService());
    }
    @Bean
    public PhoneNumberWebService phonenumberService() {
        return new PhoneNumberWebService(PHONENUMBER_SERVICE_URL);
    }
    @Bean
    public HomeController homeController() {
        return new HomeController();
    }
}
