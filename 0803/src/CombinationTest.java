import java.util.Arrays;

//1,2,3 ����
public class CombinationTest {

	static int N=6, R=3;
	static int[] numbers;
	static int[] input;
	static int sum;
	
	public static void main(String[] args) {
		input = new int[] {1,2,3,4,5,6};
		numbers = new int[R];
		sum = 0;
		combination(0,0);
		System.out.println(sum);
	}
	 
	private static void combination(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			sum++;
			return;
		}
		//start ��ġ�� ������ ������ �� ��� ���
		for(int i = start; i<N; i++) {
			
			numbers[cnt] = input[i];
			//���� �ڸ����� ������ gogo
			combination(cnt+1,i+1);
			
		}
	}
	
}
