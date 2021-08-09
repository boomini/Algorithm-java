package linkedlist;

public class Node {

	//������ �ʵ�
	public String data;
	//��ũ �ʵ�
	public Node link;
	public Node(String data) {
		super();
		this.data = data;
	}
	public Node(String data, Node link) {
		this(data);
		this.link = link;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
}
