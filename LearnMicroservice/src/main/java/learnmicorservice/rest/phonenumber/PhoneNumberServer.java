package learnmicorservice.rest.phonenumber;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import learnmicorservice.repositories.phoneNumber.PhoneNumberRepository;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class PhoneNumberServer {
	protected Logger logger = Logger.getLogger(PhoneNumberServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "phonenumber-server");
		SpringApplication.run(PhoneNumberServer.class, args);
	}

	@Bean
	public PhoneNumberRepository userRepository() {
		return new PhoneNumberRepository();
	}
}
