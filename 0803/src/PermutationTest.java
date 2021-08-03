import java.util.Arrays;

//N���� ���� �ٸ� ������ �̴� ����
public class PermutationTest {

	static int N=3, R=3;
	static int[] numbers;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
		isSelected = new boolean[N];
		
		permutation(0);
	}
	 
	private static void permutation(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//������ ��� ������ ����ִ� �迭��� ���ҿ� ���� �õ�
		for(int i = 0; i<N; i++) {//i : �ε���
			if(isSelected[i]) continue; //�ε����� �ش��ϴ� ���� ��� ���� ���� ���� ����
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			//���� �ڸ����� ������ gogo
			permutation(cnt+1);
			
			isSelected[i] = false;
		}
	}
	
}
