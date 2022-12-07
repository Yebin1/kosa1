

public class Emp {						//Emp라는 클래스는 데이터 타입이다 (큰 타입)
	public int number;
	private int empno; 					//private 접근자
										//public private 자원 전달 역할 (기능)
	public int getEmpno() {				//read
		return empno;
	}
	public void setEmpno(int empno) {	//write
		//전달하기 전에 검증
		if(empno < 0) {
			this.empno = 0;
		} else {
			this.empno = empno;
		}
	}
	
	public void print() {
		System.out.println("사원번호: " + empno);
	}
	

}
