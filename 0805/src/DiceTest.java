import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int N; // �ֻ��� ���� Ƚ��
	static int numbers[];
	static int totalCnt;
	static boolean selected[];
	static int totlaCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		selected= new boolean[N];
		totalCnt=0; 
		int M = sc.nextInt();
		switch(M) {
		case 1: //�ֻ��� ������1(�ߺ�����)
			dice1(0);
			break;
		case 2: //�ֻ��� ������2(����)
			selected= new boolean[7];
			dice2(0);
			break;
		case 3: //�ֻ���������3(�ߺ�����)
			dice3(0,1);
			break;
		case 4: //�ֻ��� ������4(����)
			dice4(0,1);
			break;
		}
		System.out.println("����� �� : " + totalCnt);	
	}
	//�ߺ�����
	private static void dice1(int cnt) {
		if(cnt == N){
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {		
			numbers[cnt] = i;
			dice1(cnt+1);
		}
		
	}
	
	//����
	private static void dice2(int cnt) {
		if(cnt == N){
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			//�ߺ�üũ
			if(selected[i]) continue;
			
			numbers[cnt] = i;
			selected[i] = true;
			dice2(cnt+1);
			selected[i] = false;
		}
		
	}
	
	//�ߺ�����
		private static void dice3(int cnt,int start) {
			if(cnt==N) {
				System.out.println(Arrays.toString(numbers));
				totalCnt++;
				return;
			}
			for(int i=start; i<=6; i++) {
				numbers[cnt] = i;
				dice3(cnt+1,i); //���� ������ ������ ó���ϵ���
			}
		}
		
	//����
	private static void dice4(int cnt,int start) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for(int i=start; i<=6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}
}
