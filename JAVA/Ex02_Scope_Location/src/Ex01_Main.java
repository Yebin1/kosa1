import kr.or.kosa.common.Car; // ctrl + shift + O

/*
Ŭ���� == ���赵 == Ÿ��
Ŭ���� ���� �伭 (���赵��� �Ǵ��ϱ� ���� �ּ��� ������ ������ �־�� �Ѵ�)
[�ʵ� + �Լ�] + ������ �Լ�

�ʵ�(member field)	>> ������, ���� ��ƾ� ��	>> ���� ����, ���� ����, ��ǰ ����	>> field >> variable
�Լ�(method)			>> ���, ���� >> �ڵ���	>> �޸���, �����, �Ҹ��� ����
+ �߰������� ������		>> Ư���� ������ �Լ�		>> ��ü�� ������ member field �ʱ�ȭ �������� ���

Ŭ����, �ʵ�, ������, �Լ�: ����(����) >> ������, ������, ������
>> public, private, default

>> kr.or.kosa.common �ȿ� Car Ŭ���� ����	>> public class Car {}
>> kr.or.kosa.common �ȿ� Airplane		>> class Airplane {	>> default class
>> default: ���� ���� �ȿ����� ���� >> ���� package �ȿ����� open, �ٸ� package �ȿ����� ���� �Ұ�
>> default ������: ���� ����(package) ������ ����� ���������� ���

�ϳ��� �������� java ������ ���� ���� Ŭ������ ���� �� �ִ�
>> Ex01_Main.java ������ �� �ȿ� Ex01_Main �̶�� Ŭ������ �ϳ� ������ �ִ�
>> �Ϲ������� �ʿ��� Ŭ������ ������ ���Ϸ� �����ؼ� ����Ѵ�
>> �ϳ��� ������ ������ ���� ���� Ŭ������ ���� �� ������ public�� �ϳ��� Ŭ������ ���� �� �ִ�

public class Apt >> class Apt
public ���� >> �ش� ���������� ��� ������ Ŭ����
��Ģ�����δ� public class ����

*/


class Emp{ }				// ������ �� ����� �뵵

class Test{					// �����Ϸ��� default class Test�� �ؼ�
	int data;				// instance variable >> �����Ϸ��� default int data; �� �ؼ�
	public int p_data;		// public �ǹ�X >> �̹� class�� default >> �ش� class������ ���
							// ������ ���� ������ �ٸ� �������� ��� �Ұ�
	private int pri_data;	// private ���ߴ�, �����, ĸ��ȭ
}

public class Ex01_Main {

	public static void main(String[] args) {
		
		Car car = new Car(); // ctrl + shift + O >> �ٸ� ��� �ڵ� �޾��� �� import
//		Airplane air = new Airplane();
		
		Apt apt = new Apt();
		Emp e = new Emp();
		
		Test t = new Test();
		// t.p_data ��� �Ұ�

	}

}
