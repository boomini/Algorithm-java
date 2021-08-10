package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int data;
	Node link;
	
	public Node(int data) {
		super();
		this.data = data;
	}
	
	public Node(int data, Node link) {
		this(data);
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
	
}

class Linkedlist{
	private Node head;
	public void addNode(int num) {
		Node currnode=null;
		for(int i=1; i<=num; i++) {
			if(head == null) {
				head = new Node(i,head);
				currnode = head;
				continue;
			}
			Node newNode  = new Node(i);
			currnode.link = newNode;
			currnode = newNode;
		}
		
	}
	public void delete(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Node currnode = null;
		Node previousNode = null;
		int index = 1;
		while(head.link!=null) {
			index ++;
			for(int i=1; i<=num; i++) {//��������ŭ �ݺ�
				if(currnode==null) {
					currnode = head;//�����尡 null�϶�, ó������
				}else {
					if(currnode.link==null) {
						currnode = head;//��������忩�� ������ ���ư���.
					}else {
						currnode=currnode.link;//�����忡 ������ �ش��ϴ� ��带 �־��ش�.
					}												
				}	
				if(i==num-1) {
					previousNode = currnode; //������� ����
				}
			}
			if(previousNode == null || currnode.data==head.data) {
				head = currnode.link;
				//ù��° ��� ������		
			}else {
				previousNode.link = currnode.link;
			}
			currnode.link = null;
			//������ ������ ����
			sb.append(currnode.data).append(", ");
			
			currnode = previousNode;	
			//�����忡 ������带 �־��� ���⼭���� K�� �ݺ�
		}
		sb.append(head.data).append(">");
		System.out.println(sb.toString());
		
	}
}
public class s5_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Linkedlist list = new Linkedlist();
		list.addNode(N);
		list.delete(K);
		
	}
}
