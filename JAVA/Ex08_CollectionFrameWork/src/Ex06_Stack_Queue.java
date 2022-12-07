import java.util.Stack;

// 0913


public class Ex06_Stack_Queue {

	public static void main(String[] args) {
		
		// Java API가 제공하는 클래스
		// Collection도 Java API가 제공
		
		// Stack 자료구조를 가지는 클래스 제공 받기
		// LIFO 후입선출
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
