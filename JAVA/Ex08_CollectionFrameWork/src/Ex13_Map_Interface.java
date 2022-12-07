// 0913

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
Map �������̽�
(key, value) �� ���� ������ ���� �迭
ex) ���� ��ȣ: (02, ����), (031, ���)

����
key: �ߺ�X		>> Set
value: �ߺ�O		>> List

Generic ����

Map �������̽� ���� Ŭ����
������: HashTable (����ȭ ����)	>> Lock �ڿ� ��ȣ
�Ź���: HashMap	(����ȭ ����X) >> ���� ���
*/


public class Ex13_Map_Interface {

	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		map.put("Tiger", "1004");		// id, pwd
		map.put("Scott", "1004");
		map.put("Superman", "1007");
		
		System.out.println(map.containsKey("tiger")); 	// false ��ҹ��� ����
		System.out.println(map.containsKey("Scott"));	
		System.out.println(map.containsValue("1004"));	// �ߺ� ���X
		
		System.out.println("-------------------------------");
		
		// key�� �����ϸ� value ���� �� �� �ִ� >> map.get(key)
		System.out.println(map.get("Tiger"));	 		// 1004
		System.out.println(map.get("hong"));	 		// null
		
		map.put("Tiger", "1008");						// value replace (overwrite)
		System.out.println(map.toString());
		System.out.println(map.get("Tiger"));
		// key�� ���� ��� value ���� ��������Ʈ
		
		System.out.println("-------------------------------");
		
		Object value = map.remove("Superman");
		System.out.println("������ value: " + value);
		System.out.println(map.toString());
		
		System.out.println("-------------------------------");
		
		// ���� (����)
		// Set �������̽��� �����ϴ� ��ü�� �����Ͽ� �ּҸ� return
		// ����X, �ߺ�X
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-------------------------------");
		
		// value�� �ߺ� �����Ͱ� ���ǹǷ� ������ �ִ� ������ ����
		Collection clist = map.values();
		System.out.println(clist.toString());
		
	}

}
