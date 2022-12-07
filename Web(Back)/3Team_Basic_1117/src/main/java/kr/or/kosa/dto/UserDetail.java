package kr.or.kosa.dto;

import java.util.Date;

public class UserDetail {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private Date startDate;
	private String profilephoto;

	public UserDetail() {
	}

	public UserDetail(String userId, String password, String name, String email, String phone, String address, String gender,
			Date startDate, String profilepoto) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.startDate = startDate;
		this.profilephoto = profilephoto;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getProfilephoto() {
		return profilephoto;
	}

	public void setProfilephoto(String profilephoto) {
		this.profilephoto = profilephoto;
	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", startDate=" + startDate
				+ ", profilephoto=" + profilephoto + "]";
	}


}
