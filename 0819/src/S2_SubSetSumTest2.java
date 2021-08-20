import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

public class S2_SubSetSumTest2 {
	static int N, totalCnt2, totalCnt3, S;
	static int[] input;
	static boolean[] isSelected;
	static int callCnt2, callCnt3;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		callCnt3 = callCnt2 = totalCnt2 = totalCnt3 = 0;
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset2(0,0);
		//����ġ�� ���Ѱ��
		System.out.println("����� �� : " + totalCnt2 + "ȣ��Ƚ��" + callCnt2) ;
		generateSubset3(0,0);
		//����ġ�� �Ѱ��
		System.out.println("����� �� : " + totalCnt3 + "ȣ��Ƚ��" + callCnt3) ;
	}

	private static void generateSubset2(int cnt, int sum) {
		//cnt : �κ������� ó���ϱ� ���� ����� ���Ҽ�
		//sum : �������� �κ����� �������ҵ��� ��.
		callCnt2++;
		if (cnt == N) {
			// �κ����� �ϼ�


			// �κ������� �� == ��ǥ�� üũ
			if (sum == S) {
				totalCnt2++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i] + " ");
				}
				System.out.println();
			}

			return;
		}
		// ���� ���Ҹ� �κ����տ� �ֱ�
		isSelected[cnt] = true;
		generateSubset2(cnt + 1, sum+input[cnt]);

		// ���� ���Ҹ� �κ����տ� �����ʱ�
		isSelected[cnt] = false;
		generateSubset2(cnt + 1, sum);
	}
	private static void generateSubset3(int cnt, int sum) {
		//cnt : �κ������� ó���ϱ� ���� ����� ���Ҽ�
		//sum : �������� �κ����� �������ҵ��� ��.
		
		callCnt3++;
		// �κ������� �� == ��ǥ�� üũ
		if (sum == S) {
			totalCnt3++;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		if(sum>S || cnt==N) return;
			//��ǥ�� �ϴ� ���� �Ѿ������ ��. or // �κ����� �ϼ�
			
		
		// ���� ���Ҹ� �κ����տ� �ֱ�
		isSelected[cnt] = true;
		generateSubset3(cnt + 1, sum+input[cnt]);
		
		// ���� ���Ҹ� �κ����տ� �����ʱ�
		isSelected[cnt] = false;
		generateSubset3(cnt + 1, sum);
	}
}
