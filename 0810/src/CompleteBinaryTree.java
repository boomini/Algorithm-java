import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private final int SIZE;
	private int lastIndex; //�������� �߰��� ����� �ε���
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1];
		
	}
	
	public void add(char c) {
		if(lastIndex==SIZE) return;
		nodes[++lastIndex] = c;
	}
	
	public void bfs() {
		// Ž���� ��ٸ��� ������ �����
		// �迭�� �����ϹǷ� Ž���� ��带 �����ϴ� �ε����� ����
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); //��Ʈ��� �ε��� ����
		
		int current = 0;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			//�����ڽ��� �ִٸ�
			if(current*2<=lastIndex) {
				queue.offer(current*2);
			}
			//������ �ڽ��� �ִٸ�
			if(current*2 + 1 <= lastIndex) {
				queue.offer(current*2 + 1);
			}
		}
	}
	
	public void bfs2() {
		// Ž���� ��ٸ��� ������ �����
		// �迭�� �����ϹǷ� Ž���� ��带 �����ϴ� �ε����� ����
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); //��Ʈ��� �ε��� ����
				
		int current = 0, level = 0, size = 0;
				
		while(!queue.isEmpty()) {
			size = queue.size();
			
			System.out.println("level" + level+ ":");
			while(--size>=0) {
				current = queue.poll();
				System.out.print(nodes[current] + " ");
				//�����ڽ��� �ִٸ�
				if(current*2<=lastIndex) {
					queue.offer(current*2);
				}
				//������ �ڽ��� �ִٸ�
				if(current*2 + 1 <= lastIndex) {
					queue.offer(current*2 + 1);
				}
			}
			System.out.println();
			++level;
		}
	}
	
	public void dfsByPreOrder() {
		System.out.println("Preorder: ");
		dfsByPreOrder(1);
		System.out.println();
	}
	private void dfsByPreOrder(int current) {
		//������ó��
		System.out.print(nodes[current] + " ");
		//�����ڽ� ��� �湮
		if(current*2<=lastIndex) dfsByPreOrder(current*2);
		//������ �ڽ� ��� �湮
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	
	public void dfsByInOrder() {
		System.out.println("Preorder: ");
		dfsByInOrder(1);
		System.out.println();
	}
	private void dfsByInOrder(int current) {
		//�����ڽ� ��� �湮
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		
		//������ó��
		System.out.print(nodes[current] + " ");
		
		//������ �ڽ� ��� �湮
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
	}
}
