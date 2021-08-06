package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty() + "/" + queue.size());
		
		queue.offer("Ȳ����");
		queue.offer("�迬��");
		queue.offer("�����");
		queue.offer("������");
		queue.offer("�̼���");
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "/" + queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek()); //����־ ���� �ȹ߻� null�� ��ȯ
	}
}
