package solution.swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swtest_1767 {
	static int[] dr = {-1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, map[][], max, min, totalCnt;
	static ArrayList<int[]> list; // ���� �ڸ��� �ƴ� �ھ���� ��ġ�� ������ ����Ʈ
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==0 || i==N-1 || j==0 || j==N-1) continue;
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++; // �����ڸ��� �ƴ� �ھ��
					}
				}
			}
			System.out.println("#" + tc + " " + min);
		}
	}
	
	private static boolean go(int index, int cCnt) {
		//index �ھ� ��ü : 4���� �õ�
		for(int i = 0; i< dc.length; i++) {
			if(isAvailable()) {
				
			}
		}
		
	}
}
