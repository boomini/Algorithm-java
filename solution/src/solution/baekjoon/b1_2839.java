package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1_2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		if (N % 5 == 0) {
			//5�� ������ �������� ������ 5�Ѹ�ŭ�� ����
			System.out.println(N / 5);
		} else {
			//�װ� �ƴϸ� 5���� ���� �� ���������� ���� �� �������� 3���� ������ ������������ üũ�ϸ鼭 �������
			int num = N / 5;
			int check = 0;
			int count = 0;
			while (true) {
				check = N - (num * 5);
				count = num;
				if (check % 3 == 0) {
					count += check / 3;
					break;
				}else if(num==0) {
					count = -1;
					break;
				}
				num--;
			}
			System.out.println(count);
		}

	}
}
