package kr.or.kosa.dto;

import java.util.Date;

/*
create table mvcregister(
 id number constraint pk_mvcregister_id primary key,
 pwd varchar2(20) not null,
 email varchar2(50) not null
)

*/
//생성
public class User {
	private String id;
	private String pwd;
	private String renumber;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private int status;
	private Date startDate;
	private String ip;
	
	
	public User() {
		
	}
	
	public User(String id, String pwd, String renumber, String name, int age, String email, String phone, String address,
			String gender, int status, Date startDate, String ip) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.renumber = renumber;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.status = status;
		this.startDate = startDate;
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRenumber() {
		return renumber;
	}
	public void setRenumber(String renumber) {
		this.renumber = renumber;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
