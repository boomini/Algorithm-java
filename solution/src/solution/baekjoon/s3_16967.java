package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_16967 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int ans[][] = new int[H][W];
		outer: for(int i=0; i<H+X; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<W+Y; j++) {
				int cur = Integer.parseInt(st.nextToken());
				//�� �迭�� �� ���Ե��� ������
				if(cur==0) continue;
				boolean aflag = false;
				boolean bflag = false;
				//A�迭�� ���Եɶ�
				if(i<H && j<W) aflag = true;
				//B�迭�� ���Եɶ�
				if(i>=X && j>=Y) bflag = true;
				
				//�ι迭�� ��� ���Եɶ�
				if(aflag&bflag) {
					ans[i][j] = cur-ans[i-X][j-Y];
				}else if(aflag) {
					ans[i][j] = cur;
				}
				
				if(i==H-1&&j==W-1)break outer;
				
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
