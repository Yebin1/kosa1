// 0913

import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;


class EmpData {

	private String name;
	private int[] numbers;
	ArrayList elist = new ArrayList();
	
	public String getName() {
		return this.name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public int[] setNumbers() {
		return this.numbers;
	}

	public int[] getNumbers() {
		return this.numbers;
	}
	
	public void setNumbers(int [] numbers) {
		this.numbers = numbers;
	}
	
	// ArrayList elist getter, setter
	public List getElist() {	// 다형성
	//public ArrayList getElist() {
		return this.elist;
	}
	public void setElist (ArrayList elist) {
		this.elist = elist;
	}

}


public class Ex04_ArrayList {

	public static void main(String[] args) {
		
		EmpData empdata = new EmpData();
		System.out.println(empdata.toString());				// EmpData@37d31475
		//System.out.println(empdata.getElist().toString);	// 재정의
		
		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);
		/*
		empdata.setElist(li);
		System.out.println(empdata.getElist().toString()); 	// [100, 200]
		*/
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("Superman");
		slist.add("Hulk");
		slist.add("Captain");
		System.out.println(slist.toString()); 				// [Superman, Hulk, Captain]
		
		// int가 아니라 Integer로 사용
		ArrayList<Integer> intList = new ArrayList<Integer>();
		System.out.println(intList.size());		// 0
		System.out.println(intList.add(100));	// true
		System.out.println(intList.size());		// 1

	}

}
