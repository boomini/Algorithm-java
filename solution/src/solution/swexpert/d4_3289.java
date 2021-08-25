package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_3289 {
	private static int parent[];
	//�θ���� ����
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			make();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine()," ");
				if(Integer.parseInt(st.nextToken())==0) union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else {
					if(find(Integer.parseInt(st.nextToken()))==find(Integer.parseInt(st.nextToken()))) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void make() {
		//��� ���Ҹ� �ڽ��� ��ǥ�ڷ� ����
		parent = new int[N+1];
		for (int i = 1; i <=N ; i++) {
			parent[i] = i;
		}
			
	}
	
	private static int find(int a) {
		if(a==parent[a]) return a;//�ڽ��� ��ǥ��
		return parent[a] = find(parent[a]); //�ڽ��� ���� ������ ��ǥ�ڸ� �θ�� : path compression
	}
	
	//�� ���Ҹ� �ϳ��� �������� ��ġ��(��ǥ�ڸ� �̿��ؼ� ��ħ)
	private static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		
		if(roota != rootb) parent[roota] = rootb;

	}
}
