package kr.or.kosa.dto;

public class User {
	private String userId;
	private int status;
	private String ip;

	public User() {
	}

	public User(String userId, int status, String ip) {
		super();
		this.userId = userId;
		this.status = status;
		this.ip = ip;
	}

	public String getuserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", status=" + status + ", ip=" + ip + "]";
	}
	
	

}
