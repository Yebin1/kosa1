/* 0901
�ǹ� (����) ȯ��
�� ���� Ŭ������ �����Ͽ� ����ϴ� ��� (X)
���赵 1�忡 ��� ������ �����ϴ� ���� ���������� �Ұ���
���赵�� ���� ���� ������ >> ���� �߻� >> ����, ���� ���� �ʿ�

���θ�: ����, ���, �Ǹ�ó, ȸ�� ����, ������ ����, ��ǰ ���� >> ������ ������ ���� ������ ���赵 �ۼ�

 * ���� �ʿ� *	���� ���� ���赵�� �̾��ִ� ���� (�θ� �ڿ�)
1. ��� (is ~ a: ���) ��/�� ~�̴� 
	* �������� �����̴�
2. ���� (has ~ a: ����) ��/�� ~�� ������ �ִ�
	* �ڵ����� ������ ������ �ִ�

ex) ��� is ~ a
���� �����̴�		>> �� extends ����
�ﰢ���� �����̴�		>> �ﰢ�� extends ����

ex) ���� has ~ a
��, ���� ����		>> ���� ���̴� (x), ���� ���� ������ �ִ� (o)
				>> class �� { ���̶�� member field }
����, ������ ����	>> ������ �����̴� (x), ������ ������ ������ �ִ� (o)
				>> class ���� { }
				>> class ���� { �����̶�� member field }

���� �����̴�
�ﰢ���� �����̴�
�簢���� �����̴�
>> ����: (������) ���� �ڿ� >> �߻�ȭ, �Ϲ�ȭ (�׸���, ����)
���� ��üȭ, Ư��ȭ (���θ��� ������ Ư¡) >> (������, ��)

��: ��ǥ�� (x, y)
���� ���� ������ �ִ�
�ﰢ���� ���� ������ �ִ�
�簢���� ���� ������ �ִ�

class Shape { �׸���, ���� }	>> ��� ���� �θ�
class Point { ��ǥ�� }		>> ���� ���� (��ǰ ����)
>> ��üȭ, Ư��ȭ�� Circle, Triangle ����

*/

// �߻�ȭ, �Ϲ�ȭ, ����
class Shape {
	String color = "gold";	// ���� �Ӽ�
	void draw() {
		System.out.println("������ �׸���");
	}
}

class Point {
	int x, y;
	
	public Point() {
		// this.x = 1;
		// this.y = 1;
		this(1,1);		// �����ڸ� ȣ���ϴ� this
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// ���� ���弼�� (��: �� ���� �������� ������ �ִ�)
// 1. ���� �����̴� (is ~ a): shape
// 2. ���� ���� ������ �ִ� (has ~ a): point
// 3. ���� �������� ������ �ִ� (Ư��ȭ, ��üȭ): r

// ���� ������ �ʱⰪ 10�� ������
// ���� ��ǥ �ʱⰪ (10, 15) ������
// �ʱⰪ�� �������� ������ �������� ���� ���� �Է� ���� �� �ִ� (���� ������� ��)
// >> ������ Ȱ��


/*
����2
�ﰢ�� Ŭ������ �����
�ﰢ���� 3���� ��, ����, �׸���(���)�� ������
hint)	Shape ���, Point ���� �޾� ���赵 �ۼ�
hint2)	(x, y), (x, y), (x, y) >> 3���� ��
default �ﰢ���� ����ų� 3���� ��ǥ���� �޾� �׸� �� �ִ�


*/


class Circle extends Shape {
	Point point;	// Point��� Ŭ������ point
	int r;					// Ư����
	
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
	
	// ��üȭ, Ư��ȭ
	// �߰� ���
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
	
	// ��üȭ, Ư��ȭ
	// �߰� ���
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
		System.out.println(circle.point.x); // circle.point >> point�� �ּҰ� ��� >> .x (member field��) �߰�
		System.out.println(circle.point.y);
		circle.draw();						// ���
		
		// ������, ��ǥ���� ���� �Է��� ���
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
