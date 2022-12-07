/* 0901
실무 (현업) 환경
한 개의 클래스만 설계하여 사용하는 경우 (X)
설계도 1장에 모든 업무를 구현하는 것은 현실적으로 불가능
설계도를 여러 개로 나눈다 >> 문제 발생 >> 기준, 관계 설정 필요

쇼핑몰: 결제, 배송, 판매처, 회원 관리, 관리자 관리, 상품 관리 >> 각각의 업무에 대해 별도의 설계도 작성

 * 기준 필요 *	여러 개의 설계도를 이어주는 기준 (부모를 뒤에)
1. 상속 (is ~ a: 상속) 은/는 ~이다 
	* 강아지는 동물이다
2. 포함 (has ~ a: 포함) 은/는 ~을 가지고 있다
	* 자동차는 엔진을 가지고 있다

ex) 상속 is ~ a
원은 도형이다		>> 원 extends 도형
삼각형은 도형이다		>> 삼각형 extends 도형

ex) 포함 has ~ a
원, 점의 관계		>> 원은 점이다 (x), 원은 점을 가지고 있다 (o)
				>> class 원 { 점이라는 member field }
경찰, 권총의 관계	>> 경찰은 권총이다 (x), 경찰은 권총을 가지고 있다 (o)
				>> class 권총 { }
				>> class 권총 { 권총이라는 member field }

원은 도형이다
삼각형은 도형이다
사각형은 도형이다
>> 도형: (공통적) 공통 자원 >> 추상화, 일반화 (그리다, 색상)
원은 구체화, 특수화 (본인만이 가지는 특징) >> (반지름, 점)

점: 좌표값 (x, y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다

class Shape { 그리다, 색상 }	>> 상속 관계 부모
class Point { 좌표값 }		>> 포함 관계 (부품 정보)
>> 구체화, 특수화된 Circle, Triangle 생성

*/

// 추상화, 일반화, 공통
class Shape {
	String color = "gold";	// 공통 속성
	void draw() {
		System.out.println("도형을 그리다");
	}
}

class Point {
	int x, y;
	
	public Point() {
		// this.x = 1;
		// this.y = 1;
		this(1,1);		// 생성자를 호출하는 this
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 원을 만드세요 (원: 한 점과 반지름을 가지고 있다)
// 1. 원은 도형이다 (is ~ a): shape
// 2. 원은 점을 가지고 있다 (has ~ a): point
// 3. 원은 반지름을 가지고 있다 (특수화, 구체화): r

// 원은 반지름 초기값 10을 가진다
// 점의 좌표 초기값 (10, 15) 가진다
// 초기값을 설정하지 않으면 반지름과 점의 값을 입력 받을 수 있다 (원이 만들어질 때)
// >> 생성자 활용


/*
문제2
삼각형 클래스를 만든다
삼각형은 3개의 점, 색상, 그리다(기능)을 가진다
hint)	Shape 상속, Point 제공 받아 설계도 작성
hint2)	(x, y), (x, y), (x, y) >> 3개의 점
default 삼각형을 만들거나 3개의 좌표값을 받아 그릴 수 있다


*/


class Circle extends Shape {
	Point point;	// Point라는 클래스의 point
	int r;					// 특수성
	
	public Circle() {
		// this.r = 10;
		// this.point = new Point(10, 15);
		this(10, new Point(10, 15));
	}
	
	public Circle(int r, Point point) {
		this.r = r;
		this.point = point;
	}
	
}

class Triangle extends Shape {
	Point a, b, c;
	
	public Triangle() {
/*		this.x = new Point(10, 20);
		this.y = new Point(30, 40);
		this.z = new Point(50, 60);		*/
		this(new Point(10, 20), new Point(30, 40), new Point(50, 60));
		
	}
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// 구체화, 특수화
	// 추가 기능
	void trianglePoint() {
		System.out.printf("a: (%d, %d)\t", a.x, a.y);
		System.out.printf("b: (%d, %d)\t", b.x, b.y);
		System.out.printf("c: (%d, %d)\t", c.x, c.y);
	}
}


class Triangle2 extends Shape {
	Point[] pointarray;
	
	public Triangle2() {
		// this(new Point(10, 20), new Point(30, 40), new Point(50, 60));
		this(new Point[] {new Point(10, 20), new Point(30, 40), new Point(50, 60)});
	}
	
	public Triangle2(Point [] pointarray) {
		this.pointarray = pointarray;
	}
	
	// 구체화, 특수화
	// 추가 기능
	void trianglePoint() {
		for (Point point: this.pointarray) {
			System.out.printf("x: (%d, %d)\t", point.x, point.y);
		}
	}
}


public class Ex02_Inherit_Composition {

	public static void main(String[] args) {
		
		Circle circle = new Circle();
		System.out.println(circle.r);
		System.out.println(circle.color);
		System.out.println(circle.point.x); // circle.point >> point의 주소값 출력 >> .x (member field값) 추가
		System.out.println(circle.point.y);
		circle.draw();						// 상속
		
		// 반지름, 좌표값을 직접 입력할 경우
		// Point point = new Point (100, 200);
		// Circle circle2 = new Circle(50, point);
		Circle circle2 = new Circle(50, new Point(100, 200));

		Triangle triangle = new Triangle();
		triangle.trianglePoint();
		System.out.println();
		
		Triangle2 triangle2 = new Triangle2();
		triangle2.trianglePoint();
		System.out.println();
		
		Point[] parray = new Point[] {new Point(10, 20), new Point(30, 40), new Point(50, 60)};
		Triangle2 triangle3 = new Triangle2(parray);
		triangle3.trianglePoint();
		
	}

}
