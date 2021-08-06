package stack;

import java.util.Stack;

public class S1_StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.isEmpty() + "/" + stack.size());
		
		stack.push("�̼���");
		stack.push("�迬��");
		stack.push("������");
		stack.push("�ڿ���");
		
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		
	}
}
