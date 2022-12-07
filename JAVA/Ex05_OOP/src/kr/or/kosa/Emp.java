// 0901

package kr.or.kosa;

/*
// 데이터를 담을 수 있는 클래스 (1건)
// DTO (Data Transfer Object) || Value Object || Domain 이름
*/

public class Emp {	// extends Object
	private int empno;
	private String ename;
	
	public Emp(int empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}

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


	@Override
	public String toString() {
		return "Emp [empno: " + empno + ", ename: " + ename + "]";
	}
	// Object가 가지는 toString(): 일반적으로 재정의를 가장 많이 하는 함수
	// 만약 재정의를 하지 않으면 toString(): 주소값을 출력하는 함수
	// toString 재정의: 필요한 대로 코딩 >> 일반적으로는 member field 정보를 출력하는 형태로 사용

	
}
	
	
