package com.alacriti.invoiceCreation.vo;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String address;
	private String city;
	private String country;
	private String state;
	private long pinCode;
	private byte category;
	private String photoPath;
	
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public User(String firstName, String lastName, String email, String password, String confirmPassword, String address,
			String city, String country, String state, long pinCode, byte category, String photoPath) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.city = city;
		this.country = country;
		this.state = state;
		this.pinCode = pinCode;
		this.category = category;
		this.photoPath = photoPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public byte getCategory() {
		return category;
	}

	public void setCategory(byte category) {
		this.category = category;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", address=" + address + ", city="
				+ city + ", country=" + country + ", state=" + state + ", pinCode=" + pinCode + ", category=" + category
				+ ", photoPath=" + photoPath + "]";
	}
	
}
