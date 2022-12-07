package kr.or.kosa.dto;

import java.util.Date;

public class Emp {
	private String job;
	private int sal;
	
	
	public Emp() {
		super();
	}
	public Emp(String job, int sal) {
		super();
		this.job = job;
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Emp [job=" + job + ", sal=" + sal + "]";
	}
	
	
}