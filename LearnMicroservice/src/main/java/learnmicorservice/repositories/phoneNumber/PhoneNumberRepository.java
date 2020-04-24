package learnmicorservice.repositories.phoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import learnmicorservice.data.PhoneNumber;
import learnmicorservice.rest.user.UserController;

public class PhoneNumberRepository {
	private HashMap<Integer, PhoneNumber> phoneNumbers = new HashMap<Integer, PhoneNumber>();
	private int id = 0;
	protected Logger logger = Logger.getLogger(UserController.class.getName());

	public ArrayList<PhoneNumber> getAll() {
		return new ArrayList<PhoneNumber>(phoneNumbers.values());
	}

	public ArrayList<PhoneNumber> getAll(int userID) {
		ArrayList<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
		for (PhoneNumber phoneNumber : getAll()) {
			logger.info("**********************************" + phoneNumber.getName());
			if (phoneNumber.getUserId() == userID) {
				numbers.add(phoneNumber);
				logger.info("**********************************users" + phoneNumber.getName());
			}
		}

		return numbers;
	}

	public PhoneNumber getById(int id) {
		return phoneNumbers.get(id);
	}

	public PhoneNumber deleteById(int id) {
		return phoneNumbers.remove(id);
	}

	public void add(PhoneNumber u) {
		logger.info("**********************************added" + u.getName() +" "+u.getId()+" "+u.getUserId());
		if (u.getId() == 0) {
			u.setId(++id);
			phoneNumbers.put(u.getId(), u);
		} else {
			phoneNumbers.replace(u.getId(), u);
		}
	}
}
