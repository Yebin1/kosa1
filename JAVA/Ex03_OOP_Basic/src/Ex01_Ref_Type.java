import kr.or.kosa.Person;

public class Ex01_Ref_Type {

	public static void main(String[] args) {
		// kr.or.kosa �ȿ� �ִ� Person ���赵�� ������ ��üȭ
		// �޸𸮿� �÷��� ����
		
		Person man = new Person();
		System.out.println(man.name);	// null
		System.out.println(man.age);	// 0
		System.out.println(man.power);	// false
		
		Person man2 = new Person();;
		man2.name = "�ƹ���";
		man2.age = 100;
		man2.power = true;
		man2.personPrint();
	}

}
