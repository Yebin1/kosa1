package kr.or.onepizza;

public class Owner {

	private String id; // ������ ���̵� Admin
	private String password; // ������ ��й�ȣ 1234

	public Owner() {
		id = "Admin";
		password = "1234";
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}