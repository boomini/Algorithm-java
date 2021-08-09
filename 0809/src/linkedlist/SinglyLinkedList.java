package linkedlist;

public class SinglyLinkedList {
	private Node head; // ù��° ��带 ����
	
	//ù��° ���� �����ϱ�
	public void addFirstNode(String data) {
		Node newNode = new Node(data,head);
		head = newNode;
	}
	
	//������ ��� ã��
	public Node getLastNode() {
		for(Node curNode = head; curNode != null; curNode = curNode.link) {
			if(curNode.link == null) {
				//�ڽ��� �ڿ��ƹ��� ������ �ڽ��� ����
				return curNode ;
			}
		}
		return null;
	}
	//������ ���� �����ϱ�
	public void addLastNode(String data) {
		if(head == null) {
			//���� ����Ʈ
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		lastNode.link = newNode;
	}
	
	public void insertAfterNode(Node preNode, String data) {
		if(preNode == null) {
			System.out.println("�����尡 ���� ������ �Ұ����մϴ�.");
			return;
		}
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
	}
	
	//data�� �����ͷ� ���� �ִ� ó�� ������ ��� ����
	public Node getNode(String data) {
		for(Node currNode = head; currNode != null; currNode = currNode.link) {
			if(currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}
	
	//target�� ������� ã��
	public Node getPreviousNode(Node target) {
		for(Node currNode = head; currNode != null; currNode = currNode.link) {
			if(currNode.link == target) {
				return currNode;
			}
		}
		return null;
	}
	
	//data�� ���� �ִ� ��� ã�� ����
	public void deleteNode(String data) {
		Node targetNode = getNode(data);
		if(targetNode == null) {
			System.out.println("������ ��尡 ��� ������ �Ұ����մϴ�.");
			return;
		}
		Node preNode = getPreviousNode(targetNode);
		if(preNode == null) {//target�� ù��° ����� ��Ȳ
			head = targetNode.link;
		}else {//target�� ù��° ��尡 �ƴ� ��Ȳ
			preNode.link = targetNode.link;
		}
		targetNode.link = null;
	}
	
	public void printList() {
		System.out.print("L = (");
		for(Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data + " ");
		}
		System.out.println(" ) ");
	}
	
}
