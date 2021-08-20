import java.util.Scanner;

//���� �࿡ ���� �ʴ� ���
//N���� ���� ���������� �ʰ� ���� ��� ����� ��

public class NQueenTest {
	static int N;
	static int col[];
	private static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		setQueens(1); //1����� ���� �õ�
		System.out.println(cnt);
	}
	
	private static void setQueens(int rowNo) {

		if(rowNo>N) {
			//������ ����� �� �� ���
			cnt++;
			return;
		}
		
		// ���� �� 1������ N������ ���ƺ���
		// �������� ���� �� ������ ����
		for (int i = 1; i <=N; i++) {
			col[rowNo] = i; //i���� ���ƺ���
			if(isAvailable(rowNo)) {
				setQueens(rowNo+1);
			}
			
		}
	}
	
	private static boolean isAvailable(int rowNo) {//rowNo : ���� �˻��Ϸ��� ��
		for(int k = 1; k<rowNo; k++) {//k : ������
			if(col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == rowNo - k) return false; 
			//1. ���� ���� ��ġ�ϴ��� Ȯ���ϱ�
			//2. �밢���� ������, �����̿� �����̰� ����.
		}
		return true;
	}
}
