import kr.or.kosa.common.Car; // ctrl + shift + O

/*
클래스 == 설계도 == 타입
클래스 구성 요서 (설계도라고 판단하기 위해 최소한 무엇을 가지고 있어야 한다)
[필드 + 함수] + 생성자 함수

필드(member field)	>> 데이터, 정보 담아야 함	>> 고유 정보, 상태 정보, 부품 정보	>> field >> variable
함수(method)			>> 기능, 행위 >> 자동차	>> 달린다, 멈춘다, 소리가 난다
+ 추가적으로 생성자		>> 특수한 목적의 함수		>> 객체가 생성시 member field 초기화 목적으로 사용

클래스, 필드, 생성자, 함수: 영역(범위) >> 접근자, 한정자, 수정자
>> public, private, default

>> kr.or.kosa.common 안에 Car 클래스 생성	>> public class Car {}
>> kr.or.kosa.common 안에 Airplane		>> class Airplane {	>> default class
>> default: 같은 폴더 안에서는 공유 >> 같은 package 안에서는 open, 다른 package 안에서는 접근 불가
>> default 접근자: 같은 폴드(package) 내에서 만들어 연습용으로 사용

하나의 물리적인 java 파일은 여러 개의 클래스를 가질 수 있다
>> Ex01_Main.java 파일은 그 안에 Ex01_Main 이라는 클래스를 하나 가지고 있다
>> 일반적으로 필요한 클래스를 별도의 파일로 생성해서 사용한다
>> 하나의 물리적 파일은 여러 개의 클래스를 가질 수 있지만 public은 하나의 클래스만 가질 수 있다

public class Apt >> class Apt
public 삭제 >> 해당 폴더에서만 사용 가능한 클래스
원칙적으로는 public class 생성

*/


class Emp{ }				// 연습할 때 만드는 용도

class Test{					// 컴파일러가 default class Test로 해석
	int data;				// instance variable >> 컴파일러는 default int data; 로 해석
	public int p_data;		// public 의미X >> 이미 class가 default >> 해당 class에서만 사용
							// 에러는 나지 않으나 다른 폴더에서 사용 불가
	private int pri_data;	// private 감추다, 숨기다, 캡슐화
}

public class Ex01_Main {

	public static void main(String[] args) {
		
		Car car = new Car(); // ctrl + shift + O >> 다른 사람 코드 받았을 때 import
//		Airplane air = new Airplane();
		
		Apt apt = new Apt();
		Emp e = new Emp();
		
		Test t = new Test();
		// t.p_data 사용 불가

	}

}
