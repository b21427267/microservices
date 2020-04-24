package learnmicorservice.rest.phonenumber;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learnmicorservice.data.PhoneNumber;
import learnmicorservice.data.PhoneNumbers;
import learnmicorservice.repositories.phoneNumber.PhoneNumberRepository;

@RestController
public class PhoneNumberController {
	private final PhoneNumberRepository phoneNumberRepository;

	@Autowired
	public PhoneNumberController(PhoneNumberRepository phoneNumberRepository) {
		this.phoneNumberRepository = phoneNumberRepository;
	}

	protected Logger logger = Logger.getLogger(PhoneNumberController.class.getName());

	@PostMapping("/addphonenumber")
	public boolean addPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
		phoneNumberRepository.add(phoneNumber);
		return true;
	}

	@RequestMapping("/getallphonenumbers")
	public PhoneNumbers getAllPhoneNumbers() {
		return new PhoneNumbers(phoneNumberRepository.getAll());
	}

	@RequestMapping("/deletephonenumber")
	public void deletePhoneNumber(@RequestParam(defaultValue = "0") String id) {
		phoneNumberRepository.deleteById(Integer.valueOf(id));
	}

	@RequestMapping("/getphonenumbersbyuserid")
	public PhoneNumbers getPhoneNumbersByUserId(@RequestParam(defaultValue = "0") String id) {
		return new PhoneNumbers(phoneNumberRepository.getAll(Integer.valueOf(id)));
	}

	@RequestMapping("/getphonenumber")
	public PhoneNumber getPhoneNumber(@RequestParam(defaultValue = "0") String id) {
		return phoneNumberRepository.getById(Integer.valueOf(id));
	}
}
