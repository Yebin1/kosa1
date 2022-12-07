/* 0901

Today Point
[상속 관계]에서 Override: 상속 관계에서 자식이 부모의 함수를 재정의
[상속 관계]에서 [자식 클래스]가 [부모 클래스]의 함수(method)를 재정의
>> 재정의: 틀의 변화가 아니라 내용을 변경 (함수의 이름, 타입 X) { 중괄호 블록 안의 내용 변경 }

문법
1. 부모와 함수 이름이 동일
2. 부모 함수의 parameter 동일
3. 부모 함수의 return type 동일
4. { 실행 블록 내 코드만을 정정 }
*/

class Point2 {
	int x = 4, y = 5;
	
	String getPosition() {
		return this.x + "/" + this.y;
	}
}

class Point3D extends Point2 {	// 세 점의 값 출력 위해...
	int z = 6;					// 상속을 통해 x, y값 가지므로 z만
	
	// String get3D...(){}		// 새 함수를 추가하는 것도 OK
	// z값까지 추가해서 출력하고 싶지만 함수를 추가하지 않을 때
	
	@Override					// 오타 알려주기
	String getPosition() {		// 재정의
	// Annotation: Java code만으로 전달할 수 없는 부가적인 정보를 컴파일러나 개발툴로 전달할 수 있다
	// @Override 컴파일러나 개발 툴에게 지금 이 함수가 재정의되었는지 검증하도록 알려준다
	// Spring은 70%가 Annotation
		
		return this.x + "/" + this.y + "/" + this.z;
	}
}

public class Ex04_Inherit_Override {

	public static void main(String[] args) {
		Point3D p = new Point3D();
		System.out.println(p.getPosition());	// 재정의된 함수가 호출

	}

}
