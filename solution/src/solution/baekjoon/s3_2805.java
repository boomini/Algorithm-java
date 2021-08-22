package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_2805 {
	//1. �������ܱ⿡ ���� H�� �����ؾ� �Ѵ�.
	//2. ���̸� �����ϸ� H���� �������� �߸���.
	//3. H���� ū ������ H���� �κ��� �߸� ���̰�, ���� ������ �߸��� ���� ���̴�.
	//4. ���ܱ⿡ ������ �� �ִ� ���̴� ���� ���� �Ǵ� 0�̴�.
	//5. ��� M������ ������ ���� �������� ���ؼ� ���ܱ⿡ ������ �� �ִ� ������ �ִ�.
	//6. 1<=N<=1000000, 1<=M<=2000000000
	//7. �̺�Ž�� 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		s = in.readLine();
		st = new StringTokenizer(s, " ");
		int[] tree = new int[N];
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		int start = 0;
		int last = tree[N-1];
		int mid = 0;
		long sum = 0;
		//M�� ������ ũ�� ������ sum�� ���� �� �����÷ο찡 �߻��� �� �ִ�.
		while(true) {
			mid = (start + last)/2;
			sum = 0;
			for(int i=0; i<N; i++) {
				int piece = tree[i]-mid;
				sum += piece<0?0:piece;
			}
			
			if(start>=last && sum > M) {
				//start�� last���� Ŀ���ų� �������µ� �߷��� �����ǽ��� sum�� ���ϴ� ������ Ŀ���� �� �� ���
				break;
			}else if(start>=last && sum < M) {
				//start�� last���� Ŀ���ų� �������µ� �߷��� �����ǽ��� sum�� ���ϴ� ������ �۾����� �� ������ ��ĭ �Ʒ����� ���
				mid -=1;
				break;
			}
			
			if(sum>M) {
				start = mid+1;
			}else if(sum<M) {
				last = mid-1;
						
			}else break;
			
		}
		System.out.println(mid);
		//System.out.println(start + " " + last + " " + sum + " " + mid);
		
	}
}
