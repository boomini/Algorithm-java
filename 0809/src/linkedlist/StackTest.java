package linkedlist;

public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("�ǹ�");
		System.out.println(stack);
		stack.push("������");
		System.out.println(stack);
		stack.push("����ȯ");
		System.out.println(stack);
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.peek());
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
