package learnmicorservice.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import learnmicorservice.data.PhoneNumber;
import learnmicorservice.data.PhoneNumbers;
import learnmicorservice.data.User;
import learnmicorservice.data.Users;
import learnmicorservice.rest.user.UserController;

@Controller
public class WebController {

	protected Logger logger = Logger.getLogger(UserController.class.getName());
	@Autowired
	protected UserWebService userService;

	@Autowired
	protected PhoneNumberWebService phoneNumberService;

	public WebController(UserWebService userService, PhoneNumberWebService phonenumberService) {
		this.userService = userService;
		this.phoneNumberService = phonenumberService;
	}

	@RequestMapping("/getallusers")
	public String getAllUsers(Model model) {
		Users userList = userService.getAllUsers();
		model.addAttribute("userList", userList.getUserList());

		return "allusers";
	}

	@PostMapping("/adduser")
	public String addUser(User user) {
		userService.addUser(user);
		return "index";
	}

	@RequestMapping("/updateuser")
	public String updateuser(@RequestParam(defaultValue = "0") String id, Model model) {

		User user = userService.getUser(id);

		model.addAttribute("user", user);
		model.addAttribute("operation", "Güncelle");
		model.addAttribute("title", "Kullanýcý Bilgileri");

		return "userinfo";
	}

	@RequestMapping("/deleteuser")
	public String deleteUser(@RequestParam(defaultValue = "0") String id) {
		userService.deleteUser(id);
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@RequestMapping("/newuser")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("operation", "add");
		model.addAttribute("title", "Yeni Kullanýcý");
		return "userinfo";
	}

	@RequestMapping("/getallphonenumbers")
	public String getAllPhoneNumbers(Model model) {
		PhoneNumbers phoneNumberList = phoneNumberService.getAllPhoneNumbers();
		model.addAttribute("phoneNumberList", phoneNumberList.getPhoneNumberList());

		return "phonenumbers";
	}

	@PostMapping("/addphonenumber")
	public String addPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumberService.addPhoneNumber(phoneNumber);
		return "index";
	}

	@RequestMapping("/getphonenumbersbyuserid")
	public String getPhoneNumbersByUserId(@RequestParam(defaultValue = "0") String id, Model model) {
		PhoneNumbers phoneNumberList = phoneNumberService.getPhoneNumbersByUserId(id);
		
		model.addAttribute("phoneNumberList", phoneNumberList.getPhoneNumberList());
		model.addAttribute("userId", id);
		return "phonenumbers";
	}

	@RequestMapping("/updatephonenumber")
	public String updatePhoneNumber(@RequestParam(defaultValue = "0") String id, Model model) {

		PhoneNumber phoneNumber = phoneNumberService.getPhoneNumber(id);

		model.addAttribute("phoneNumber", phoneNumber);
		model.addAttribute("operation", "Güncelle");
		model.addAttribute("title", "Telefon Numarasý Bilgileri");

		return "phonenumberinfo";
	}

	@RequestMapping("/deletephonenumber")
	public String deletePhoneNumber(@RequestParam(defaultValue = "0") String id) {
		phoneNumberService.deletePhoneNumber(id);
		return "index";
	}

	@RequestMapping("/newphonenumber")
	public String addPhoneNumber(@RequestParam(defaultValue = "0") String id, Model model) {
		PhoneNumber pn = new PhoneNumber();
		pn.setUserId(Integer.valueOf(id));
		model.addAttribute("phoneNumber", pn);
		model.addAttribute("operation", "Ekle");
		model.addAttribute("title", "Yeni Telefon Numarasý");
		return "phonenumberinfo";
	}
}
