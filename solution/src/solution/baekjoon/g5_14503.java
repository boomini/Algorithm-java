package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_14503 {
	private static int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};//��,��,��,��
	private static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		//0��, 1��, 2��, 3��
		if(d==1) d=3;
		else if(d==3) d=1;
		//�ϼ�����
		int arr[][] = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		outer : while(true) {
			if(arr[r][c]==0) ans++;
			arr[r][c] = 2;
			//���� ��ġ û��
			

			//a.���� ���� û���� �����ִ��� Ȯ���ϰ� , ������ ȸ���� �� ��ĭ ����
			//b.������ ȸ���ϰ� �ٽ� �ݺ�.
			for(int i=1; i<5; i++) {
				d=(d+1)%4;
				int nx = r+dir[d][0];
				int ny = c+dir[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny <M && arr[nx][ny]==0) {
					r=nx;
					c=ny;
					continue outer;
				}
			}
			
			int nx = r-dir[d][0];
			int ny = c-dir[d][1];
			//c. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡�� �ٶ󺸴� ������ ������ ä�� ��ĭ ������ �ϰ� 2������ ���ư���.
			if(nx>=0 && ny>=0 && nx<N && ny <M && arr[nx][ny]==2) {
				r=nx;
				c=ny;
				continue outer;
			}
			
			break;
			
		}
		System.out.println(ans);
	}
}
