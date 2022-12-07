package kr.or.onepizza;

import java.io.Serializable;

public class User implements Serializable {

	private String emailId; // ���̵� (�̸��� ����ǥ����)
	private String password; // ��й�ȣ
	private String phoneNumber; // ��ȭ��ȣ
	private String address; // �ּ�
	private static final long serialVersionUID = 4341708937646597533L; // UId�� ����ȭ ��Ű�� ���ؼ�

	public User(String emailId, String password, String phoneNumber, String address) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "�̸��� �ּ� :" + emailId + ", ��й�ȣ :" + password + ", ��ȭ��ȣ :" + phoneNumber + ", �ּ� :" + address;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}
}
