// 0913
// Java API가 제공하는 Stack 직접 구현해보기

package kr.or.kosa;

/*
1. stack 저장 공간을 가진다 (Array) * 저장 공간은 타입을 가진다 (Object)
2. 위치 정보: 저장되는 값이 있는 위치를 알아야 한다 (index 개념: 전자 제품 매장 cart)
3. 기능: push(), pop(), boolean empty(), full()
*/

public class MyStack {
	
	private Object[] stackarr;	// 저장 공간
	private int maxsize;		// 최대 크기
	private int top;			// 배열의 index값 (위치 정보)
	
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1;				// 배열의 시작값이 0이므로
	}
	
	public boolean isEmpty() {
		return (top == -1);		// true
	}
	
	public boolean isFull() {
		return (top == maxsize -1);
	}
	
	public void push(Object obj) {
		if (isFull()) {
			System.out.println("stack full...");
		} else {
			stackarr[++top] = obj;
		}			 
	}
	
	public Object pop() {
		Object value = null;
		
		if (isEmpty()) {
		System.out.println("stack empty...");
		} else {
			value = stackarr[top--];
		}
		return value;
	}

}
