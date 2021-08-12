import java.util.Arrays;

public class CombNextPermutationTest {

	public static void main(String[] args) {
		int[] input = {7,1,4,2,3};
		int N = input.length;
		int R = 3;
		
		int[] p = new int[N];
		// ���ʺ��� R����ŭ 1ä���
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		
		do {
			//���� ���
			for(int i=0; i<N; i++) {
				if(p[i]==1) System.out.print(input[i]+ " ");
			}
			System.out.println();
		}while(np(p));
	}
	
	//���� ū ������ ������ true, ������ false
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		//step1. �����(i)�� ã�´�. ����⸦ ���� ��ȯ��ġ(i-1) ã��
		int i =N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		//step2. i-1 ��ġ���� ��ȯ�� ū �� ã��
		int j=N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		//step3. i-1��ġ���� j��ġ�� ��ȯ
		swap(numbers, i-1, j);
		
		//step4. �������� �� �ڱ��� �������� ������ ������ ������������ ó��
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
