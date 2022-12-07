// 0913

import kr.or.kosa.MyStack;


public class Ex07_MyStack_Main {

public static void main(String[] args) {
		
	MyStack mystack = new MyStack(5);
	mystack.push(10);
	mystack.push(20);
	mystack.push(30);
	mystack.push(40);
	mystack.push(50);
	mystack.push(60);
	
	System.out.println(mystack.pop());
	System.out.println(mystack.pop());
	System.out.println(mystack.pop());
	System.out.println(mystack.pop());
	System.out.println(mystack.pop());
	System.out.println(mystack.pop());
	}

}