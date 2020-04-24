package learnmicorservice.data;

public class PhoneNumber {
	private int id;
	private int userId;
	private String number;
	private String name;

	public String getNumber() {
		return number;
	}

	public PhoneNumber(int id, int userId, String number, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.number = number;
		this.name = name;
	}

	public PhoneNumber(int userId, String number, String name) {
		super();
		this.userId = userId;
		this.number = number;
		this.name = name;
	}

	public PhoneNumber() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
