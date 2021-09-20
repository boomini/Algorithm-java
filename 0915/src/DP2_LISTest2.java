import java.util.Arrays;
import java.util.Scanner;

public class DP2_LISTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N]; //��� ������ ���� �ٸ���.
		int[] LIS = new int[N]; //�ش� ���̸� �������� �� �� ���� �ּڰ����� ����.
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0; //LIS�� ä���� ���� ��
		for(int i=0; i<N ; i++) {
			// �ߺ����� �����Ƿ� Ž�� ����. ������ ==> ������ġ�� ȯ��
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
			LIS[temp] = arr[i];
			
			if(temp == size) {
				size++;
			}
		}
		
		System.out.println(size);
	}
}
