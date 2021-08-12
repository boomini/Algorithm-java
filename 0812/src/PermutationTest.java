import java.util.Arrays;

//N���� ���� �ٸ� ������ �̴� ����
public class PermutationTest {

	static int N=3, R=2;
	static int[] numbers;
	static int[] input;
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
		
		permutation(0,0);
	}
	 
	private static void permutation(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//������ ��� ������ ����ִ� �迭��� ���ҿ� ���� �õ�
		for(int i = 0; i<N; i++) {//i : �ε���
			if((flag & 1<<i)!=0) continue; //�ε����� �ش��ϴ� ���� ��� ���� ���� ���� ����
			
			numbers[cnt] = input[i];
			
			//���� �ڸ����� ������ gogo
			permutation(cnt+1,flag | 1<<i);
		}
	}
	
}
