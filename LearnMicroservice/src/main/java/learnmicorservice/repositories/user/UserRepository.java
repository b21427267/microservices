package learnmicorservice.repositories.user;

import java.util.ArrayList;
import java.util.HashMap;

import learnmicorservice.data.User;

public class UserRepository {
	private HashMap<Integer, User> users = new HashMap<Integer, User>();
	private int id = 0;

	public ArrayList<User> getAll() {
		return new ArrayList<User>(users.values());
	}

	public User getById(int id) {
		return users.get(id);
	}

	public User deleteById(int id) {
		return users.remove(id);
	}

	public void add(User u) {
		if (u.getId() == 0) {
			u.setId(++id);
			users.put(u.getId(), u);
		} else {
			users.replace(u.getId(), u);
		}
	}
}
