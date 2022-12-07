package kr.or.kosa;

public class Emp {
	
	// member field (instance variable)
	private int empno;
	private String ename;
	private String job;
	private int sal;

	// setter, getter method
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	
	
	// method (기능)
	public void empDataPrint() {
		System.out.println("사원 데이터 출력");
		
		// method (main 함수)
		// 함수 안에 있는 변수(지역 변수) 접근자 붙이지 않는다
		int data = 0;	// local variable
		int input = 0;
		// for(int i;)	>> block variable
	}
	
	

}
