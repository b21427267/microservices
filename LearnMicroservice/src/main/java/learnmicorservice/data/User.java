package learnmicorservice.data;

public class User {
	private String name;
	private String surName;
	private String userName;

	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String surName, String userName) {
		super();
		this.name = name;
		this.surName = surName;
		this.userName = userName;
	}

	public User(int id, String name, String surName, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
