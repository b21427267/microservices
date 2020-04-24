package learnmicorservice.data;

import java.util.List;

public class PhoneNumbers {
	private List<PhoneNumber> phoneNumberList;

	public PhoneNumbers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneNumbers(List<PhoneNumber> phoneNumberList) {
		super();
		this.phoneNumberList = phoneNumberList;
	}

	public List<PhoneNumber> getPhoneNumberList() {
		return phoneNumberList;
	}

	public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}
}
