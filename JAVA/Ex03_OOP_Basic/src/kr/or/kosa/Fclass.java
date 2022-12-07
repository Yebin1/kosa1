package kr.or.kosa;

/*
���	(����) ����� ��
�Լ� (method)

method: ���� �Ǵ� ����� �ּ� ������ ���� >> �ϳ��� �Լ��� �ϳ��� ��ɸ� ����
ex) �Դ´�, �ܴ�, �ȴ´�...

Ŭ����: field + method
ex) �Ե����� : ���ӹ� : ��, ����, ���� �̱�

method �Լ��� ȣ�⿡ ���ؼ��� �����Ѵ�
������ �̸��� �θ��� ������ �������� �ʴ´�

JAVA
1. void, parameter(0): void print(String str) { ���� �ڵ� }		>> () ���� ���� ����
2. void, parameter(x): void print(){ ���� �ڵ� }					>> ��¥
3. return type, parameter(0): int print(int data) {return 100;}
4. return type, parameter(x): int print() {return 100;}	

*** void >> ��ȯX >> return type�� ����
return type >> ��� 8���� + String + Array, class, collection, interface
�⺻ 8���� + String + class ...

boolean print(return type)
Car print()
Car print() {Car c = new Car(); return c;} // ���� ��ſ��� Car��� �ϴ� ��ü�� �ּҸ� ��ȯ
String print() {return "A"}

parameter type >> void print(String �Ķ����)
�⺻ 8���� + String + Array, class, collection, interface

void print(int i) {}
void print(String str) {}
void print(Car car)			// print �Լ��� parameter�� Car Ÿ���� �ּҰ��� �޴´�

ex)
Car c = new Car();
void print(Car car) {}
print(c);					// print �Լ� ȣ��� c��� ������

void print(int a, int b, int c, int d) {}	// ��Ģ������ ���� 4�� ���� �־�� ����
print(10, 20)			// ���� 2�� �־ ����X
print(10, 20, 30, 40,)	// 4�� �־� ����

void print(Car c, String str, int i) {}		// �ּҰ�, ���ڿ�, ���� �پ��ϰ� �ִ´�

�������� ǥ��
�ڵ� ��Ģ: ������
class �̸��� ù ���ڴ� �빮��: class Car, class Person
method�� �̸��� �ҹ���, �빮�� ����: getNumber()

��� ��ȣ�� ������ ����� ��� ������ ������ �� �� (�Լ� ����)
getEmpListByEmpno()		// �Լ��� ���� ������ �� ���� ������ �� ��

*/

public class Fclass {	// ���赵. �޸𸮿� �÷��� ����
	public int data;
	
	// void m() >> �����Ϸ��� >> default void m() >> ���� ���� ������
	// �Լ� 70% public
	// �Լ� 30% private >> public, private Ŭ���� ���� ����
	// Ŭ���� ���ο����� ����ض� >> ���� �Լ� >> �ٸ� �Լ��� �����ִ� ����
	
	public void m() {	// void, parameter(x)
		// ��� ����
		// main �Լ����� ����ߴ� �ڵ� �ۼ�
		System.out.println("�Ϲ� �Լ�: void, parameter(x)");
	}
	
	// void m2(int)
	public void m2(int i) {
		System.out.println("�Ϲ� �Լ�: void, parameter(o)");
		System.out.println("parameter ���� Ȱ��, i���� �Լ� ����: "+ i);
	}
	
	//return type m3(x)
	public int m3() {
						// ������ return ���
						// �ڿ� int�� ���� Ÿ���� ���� �ִ´�
		return 1000;	// return type�� �����ϸ� �ݵ�� return Ű���� �ʼ�
		
	}
	
	public int m4(int data) {
		return 100 + data;
	}
	
	// ��������� �⺻ 4���� ����
	///////////////////////////////////////////////////////////////////
	
	// Ȯ��
	// return type(0), parameter(0) ���� ����
	public int sum(int i, int j, int k) {
		return i + j + k;
	}
	
	
	// �Լ��� ������
	// default int subSum(){}	>> ���� ����
	// private int subSum(){}	>> ���� �������� X
	// Ŭ���� ���ο��� �ٸ� �Լ��� �����ִ� ���� �Լ�
	// private �Լ� ����� ���
	
	private int subSum(int i) {	// �ٸ� �Լ��� ȣ���ؼ� ���
		return i + 100;			// ������ ��� �Լ��� ������ �ִٸ� ��������
	}
	public void callSubSum() {
		// �Լ��� �ٸ� �Լ��� ȣ�� ����
		int result = subSum(100);
		// result == local variable
		System.out.println("call result: " + result);
	}
	
	
	private int operationMethod(int data) {
		return data * 200;
	}
	public int opSum(int data) {
		int result = operationMethod(data);
		// ���
		if (result > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
	//Quiz
	//a�� b �� �� ū ���� return�ϴ� �Լ� �ۼ�	
	private int maxMethod(int a, int b) {
		return data;
	}
	public int maxNum(int a, int b) {
		int result = maxMethod(a, b);
		return (a > b) ? a : ((a == b) ? 0 : b);
		
	}
	
	///////////////////////////////////////////////////

	
	
	
	
	

}
