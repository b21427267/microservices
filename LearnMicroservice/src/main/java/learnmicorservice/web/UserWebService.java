package learnmicorservice.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import learnmicorservice.data.User;
import learnmicorservice.data.Users;

@Service
public class UserWebService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(UserWebService.class.getName());

	public UserWebService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}
	
	public ResponseEntity<String> addUser(User user) {			
	    return restTemplate.postForEntity(serviceUrl+ "/adduser", user, String.class);
	}

	public void deleteUser(String id) {
		restTemplate.getForObject(serviceUrl + "/deleteuser?id={id}", void.class, id);
	}

	public User getUser(String id) {
		return restTemplate.getForObject(serviceUrl + "/getuser?id={id}", User.class, id);
	}

	public Users getAllUsers() {
		return restTemplate.getForObject(serviceUrl + "/getallusers", Users.class);
	}
}
