package learnmicorservice.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import learnmicorservice.data.PhoneNumber;
import learnmicorservice.data.PhoneNumbers;

@Service
public class PhoneNumberWebService {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(PhoneNumberWebService.class
			.getName());

	public PhoneNumberWebService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public ResponseEntity<String> addPhoneNumber(PhoneNumber user) {			
	    return restTemplate.postForEntity(serviceUrl+ "/addphonenumber", user, String.class);
	}

	public void deletePhoneNumber(String id) {
		restTemplate.getForObject(serviceUrl + "/deletephonenumber?id={id}", void.class, id);
	}

	public PhoneNumber getPhoneNumber(String id) {
		return restTemplate.getForObject(serviceUrl + "/getphonenumber?id={id}", PhoneNumber.class, id);
	}

	public PhoneNumbers getAllPhoneNumbers() {
		return restTemplate.getForObject(serviceUrl + "/getallphonenumbers", PhoneNumbers.class);
	}

	public PhoneNumbers getPhoneNumbersByUserId(String id) {
		return restTemplate.getForObject(serviceUrl + "/getphonenumbersbyuserid?id={id}", PhoneNumbers.class, id);
	}
}

