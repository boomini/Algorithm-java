
public class R03_HanoiTest {
	private static void hanoi(int n, int start, int temp, int dest) {
		if(n==0) return;
		//�ڽ��� ������ n-1�� ���� ���� : �ӽñ������ �ű��
		hanoi(n-1,start,dest,temp);
		//�ڽ��� ���� �ű�� : �������
		System.out.println( n+":"+start+">"+dest);
		//���´� �ӽñ���� n-1�� ���� �ڽ����� �ױ� : ����������� �ű��
		hanoi(n-1,temp,start,dest);
	}
	public static void main(String[] args) {
		hanoi(3,1,2,3);
	}
}
