package modifiertest;

public class Store {
	public static void main(String[] args) {
		Guest g1 = new Guest("�ɾ���");
		Guest g2 = new Guest("����");
		Guest g3 = new Guest("������");
		
		System.out.println(g1.name + "�� �湮.");
		g1.visit();
		System.out.println("���� �湮�ڼ� : " +g1.cnt );
	}
}
