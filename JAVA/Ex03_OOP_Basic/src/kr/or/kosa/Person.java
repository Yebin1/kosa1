package kr.or.kosa;


/*
class == 설계도 == 데이터 타입
설계도는 종이 >> 구체화 필요 (메모리) >> 객체
구체화된 것: 객체, 인스턴스

설계도: field(고유, 상태, 부품) + method(기능) + constructor(생성자 함수)

public class Ex01_Basic{
	public static void main(String[] args){
	이 안에서 코드 연습
	main 이름을 가진 함수의 지역
	String name = "초기화";	// local variable > 접근자 > 함수가 호출 생성 > 함수 종료, 소멸
	int age = 0;
	}
}


*/


public class Person {
	public String name;		// default (자동) null
	public int age;			// default (자동) 0
	public boolean power;	// default (자동) false
	
	// member field >> instance variable
	// 1. instance variable 초기화하지 않아도 된다 >> default 값
	// 초기화: 변수가 처음으로 값을 할당 받는 것
	// 질문: name member field 초기화 하고 싶을 때 >> 해도 됨
	// 필요하다면 초기화 가능: public int age = 100
	
	// Today Point: 왜 초기화하지 않을까?
	// 생성되는 객체(사람)마다 [다른 이름을 가질 수 있다]
	// Person member field: 사람을 만들 때마다 다른 값을 가지게 한다면 초기화가 굳이 필요하지 X
	
	/*
	main(){
		Person 남자 = new Person(); // 사람 한 명 생성
		남자.name = "김유신";
		남자.age = 100;
		남자.power = true;
		
		Person 여자 = new Person(); // 사람 한 명 더 생성
		여자.name = "유관순";
		여자.age = 20;
		여자.power = false;
		
		Person 인간 = new Person();
		// stack	함수 할당
		// heap		class 할당
	}
	*/
	
	// 기능
	// 정보를 출력하는 기능
	// void 어떠한 것도 돌려주지 않겠다는 의미
	public void personPrint() {
		System.out.printf("이름은 %s, 나이는 %d, 파워는 %s", name, age, power);
	}
	
	
	
	
	
	
	


}
