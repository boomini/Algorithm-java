package linkedlist;

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLastNode("�̴�");
		list.addLastNode("ȭ����");
		System.out.println(list.getLastNode());
		System.out.println(list.getNode("�̴�"));
		list.printList();
		
		list.addFirstNode("������");
		list.printList();
		
		list.insertAfterNode(list.getNode("�̴�"), "�躸��");
		list.printList();
		
		Node target = list.getNode("�̴�");
		System.out.println(list.getPreviousNode(target));
		
		list.deleteNode("������");
		list.printList();
	}
}
