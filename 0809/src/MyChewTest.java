import java.util.LinkedList;
import java.util.Queue;

public class MyChewTest {
	public static void main(String[] args) {
		int N = 20; //������ ������ ���� 
		Queue<int[]> queue = new LinkedList<int[]>(); //�����ȣ, �����鰳��
		int person = 1;
		queue.offer(new int[] {person,1});
		while(N>0) {
			if(!queue.isEmpty()) {
				int[] p = queue.poll();
				int availableCnt = (N>=p[1]?p[1]:N);
				N-=availableCnt;
				
				if(N==0) {
					System.out.println("������ �����鸦 ������ ���" + p[0] + "��" + availableCnt + "��ŭ ������");
				}else {
					System.out.println(p[0] + "����" + availableCnt + "��ŭ �����鸦 �������ϴ�.��������" +N );
					p[1]++; //�ް��� �ϴ� �����鰳�� ����
					queue.offer(p);
					queue.offer(new int[] {++person,1});
				}
			}
			
		}
		
	}
}
