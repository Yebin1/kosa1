/* 0829
함수 사용시 parameter 값, 주소를 전달
void m(int x) {}	>> x 변수: 값을 받는다
int y = 200;
호출: m(y);
y = 1000; 변경 >> 의미X

 * call by value

/////////////////////////////////////////////////////////

void m2(Car c) { c.color = "red" }	>> c 변수: 주소를 받는다
Car c2 = new Car();
호출: m(c2);			>> 같은 타입의 주소값을 전달한다 (Today Point)

 * call by reference
*/


class Data { // 연습용
	int i;
}

public class Ex12_Method_Call {
	static void scall(Data sdata) { // default static
		System.out.println("함수: " + sdata.i);
		sdata.i = 111;				// 0xA번지 i값을 111로 변경
	}
	static void vcall(int x) {		// default static
		System.out.println("before x: " + x);
		x = 8888;
		System.out.println("after x: "+ x);
		
	}

	public static void main(String[] args) {
		Data d = new Data();		// d의 주소가 0xA번지
		d.i = 100;
		System.out.println("d.i: " + d.i);
		/*
		scall(d);					// 주소값 전달 (0xA번지)
		System.out.println("after d.i: " + d.i);
		*/
		////////////////////////////////////////////////////////
		
		vcall(d.i);					// 값만 전달 (100)
		System.out.println("d.i: " +d.i); 		// 값은 변경X

	}

}
