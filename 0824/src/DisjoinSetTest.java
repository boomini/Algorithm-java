import java.util.Arrays;

public class DisjoinSetTest {

	static int N; //���Ұ���
	static int[] parents; //�θ���Ҹ� ����(Ʈ��ó�� ���)
	
	private static void make() {
		//��� ���Ҹ� �ڽ��� ��ǥ�ڷ� ����.
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	//a������ ������ ��ǥ�� ã��
	private static int find(int a) {
		if(a==parents[a]) return a; //�ڽ��� ��ǥ��
		return parents[a] = find(parents[a]); //�ڽ��� ���� ������ ��ǥ�ڸ� �ڽ��� �θ�� : path compression
	}
	
	// �� ���Ҹ� �ϳ��� �������� ��ġ��(��ǥ�ڸ� �̿��ؼ� ��ħ)
	private static boolean union(int a , int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; //�̹� ���� �������� ��ġ�� ����
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		parents = new int[N];
		
		//make set
		make();
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4,3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("==========find=====================");
		System.out.println(find(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(1));
		System.out.println(Arrays.toString(parents));
	}
}
