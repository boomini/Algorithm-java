
public class R02_CombinationTest {

	private static int comb(int n, int r) {
		//�ڽ��� �����ؼ� r���� ����� ����� �� + �ڽ��� �������� �ʰ� r���� ����� ����� ��
		if(r==0 || n==r) return 1;
		
		return comb(n-1,r-1) + comb(n-1,r);
			
			
	}
	public static void main(String[] args) {
		System.out.println(comb(3,2));
		System.out.println(comb(5,3));
	}
}
