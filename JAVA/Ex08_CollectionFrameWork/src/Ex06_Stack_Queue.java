import java.util.Stack;

// 0913


public class Ex06_Stack_Queue {

	public static void main(String[] args) {
		
		// Java API�� �����ϴ� Ŭ����
		// Collection�� Java API�� ����
		
		// Stack �ڷᱸ���� ������ Ŭ���� ���� �ޱ�
		// LIFO ���Լ���
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		// Exception in thread "main" java.util.EmptyStackException
		// System.out.println(stack.pop());
		
		
		
	}

}
