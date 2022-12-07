/* 0901

Today Point
[��� ����]���� Override: ��� ���迡�� �ڽ��� �θ��� �Լ��� ������
[��� ����]���� [�ڽ� Ŭ����]�� [�θ� Ŭ����]�� �Լ�(method)�� ������
>> ������: Ʋ�� ��ȭ�� �ƴ϶� ������ ���� (�Լ��� �̸�, Ÿ�� X) { �߰�ȣ ��� ���� ���� ���� }

����
1. �θ�� �Լ� �̸��� ����
2. �θ� �Լ��� parameter ����
3. �θ� �Լ��� return type ����
4. { ���� ��� �� �ڵ常�� ���� }
*/

class Point2 {
	int x = 4, y = 5;
	
	String getPosition() {
		return this.x + "/" + this.y;
	}
}

class Point3D extends Point2 {	// �� ���� �� ��� ����...
	int z = 6;					// ����� ���� x, y�� �����Ƿ� z��
	
	// String get3D...(){}		// �� �Լ��� �߰��ϴ� �͵� OK
	// z������ �߰��ؼ� ����ϰ� ������ �Լ��� �߰����� ���� ��
	
	@Override					// ��Ÿ �˷��ֱ�
	String getPosition() {		// ������
	// Annotation: Java code������ ������ �� ���� �ΰ����� ������ �����Ϸ��� �������� ������ �� �ִ�
	// @Override �����Ϸ��� ���� ������ ���� �� �Լ��� �����ǵǾ����� �����ϵ��� �˷��ش�
	// Spring�� 70%�� Annotation
		
		return this.x + "/" + this.y + "/" + this.z;
	}
}

public class Ex04_Inherit_Override {

	public static void main(String[] args) {
		Point3D p = new Point3D();
		System.out.println(p.getPosition());	// �����ǵ� �Լ��� ȣ��

	}

}
