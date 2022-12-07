// 0913
// Java API�� �����ϴ� Stack ���� �����غ���

package kr.or.kosa;

/*
1. stack ���� ������ ������ (Array) * ���� ������ Ÿ���� ������ (Object)
2. ��ġ ����: ����Ǵ� ���� �ִ� ��ġ�� �˾ƾ� �Ѵ� (index ����: ���� ��ǰ ���� cart)
3. ���: push(), pop(), boolean empty(), full()
*/

public class MyStack {
	
	private Object[] stackarr;	// ���� ����
	private int maxsize;		// �ִ� ũ��
	private int top;			// �迭�� index�� (��ġ ����)
	
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1;				// �迭�� ���۰��� 0�̹Ƿ�
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
