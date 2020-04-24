package learnmicorservice.rest.user;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learnmicorservice.data.User;
import learnmicorservice.data.Users;
import learnmicorservice.repositories.user.UserRepository;

@RestController
public class UserController {
	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	protected Logger logger = Logger.getLogger(UserController.class.getName());

	@PostMapping("/adduser")
	public boolean addUser(@RequestBody User user) {
		userRepository.add(user);
		return true;
	}

	@RequestMapping("/getallusers")
	public Users getAllUsers() {
		return new Users(userRepository.getAll());
	}

	@RequestMapping("/deleteuser")
	public void deleteUser(@RequestParam(defaultValue = "0") String id) {
		userRepository.deleteById(Integer.valueOf(id));
	}

	@RequestMapping("/getuser")
	public User getUser(@RequestParam(defaultValue = "0") String id) {
		logger.info("************************************aaaaaaaa");
		return userRepository.getById(Integer.valueOf(id));
	}
}
