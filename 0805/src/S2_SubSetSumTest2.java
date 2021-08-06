import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

public class S2_SubSetSumTest2 {
	static int N, totalCnt, S;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		totalCnt = 0;

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("����� �� : " + totalCnt);
	}

	private static void generateSubset(int cnt) {

		if (cnt == N) {
			// �κ����� �ϼ�

			// �κ������� ���� ���
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					sum += input[i];
			}

			// �κ������� �� == ��ǥ�� üũ
			if (sum == S) {
				totalCnt++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i] + " ");
				}
				System.out.println();
			}

			return;
		}
		// ���� ���Ҹ� �κ����տ� �ֱ�
		isSelected[cnt] = true;
		generateSubset(cnt + 1);

		// ���� ���Ҹ� �κ����տ� �����ʱ�
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}
