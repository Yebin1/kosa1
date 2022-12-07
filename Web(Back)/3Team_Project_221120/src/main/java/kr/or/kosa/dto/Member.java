package kr.or.kosa.dto;

public class Member {
	private String userid;
	private int status;
	private String ip;

	public Member() {
		super();
	}

	public Member(String userid, int status, String ip) {
		super();
		this.userid = userid;
		this.status = status;
		this.ip = ip;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
		return "Member [userid=" + userid + ", status=" + status + ", ip=" + ip + "]";
	}

}
