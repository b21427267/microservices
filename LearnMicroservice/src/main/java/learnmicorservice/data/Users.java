package learnmicorservice.data;

import java.util.List;

public class Users {
	private List<User> userList;
	
	private Users() {
		// TODO Auto-generated method stub
	}

	public Users(List<User> userList) {
		this.userList = userList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
