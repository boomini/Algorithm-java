package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_21608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int index[] = new int[N*N];
		ArrayList<Integer> [] arr = new ArrayList[(N*N)+1];
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			index[i] = n;
			arr[n] = new ArrayList<Integer>();
			for(int j=0; j<4; j++) {			
				arr[n].add(Integer.parseInt(st.nextToken()));				
			}
		}
		
		int s[][] = new int[N][N];
		int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
		int ans[] = new int[4]; //[0] => �� [1] => �� [2] => ��ĭ [3] => �����ϴ� �л���
		for(int i=0; i<N*N; i++) {//�л��� ���ʴ�� ����
			int n = index[i];
			for(int l=0; l<N; l++) {
				for(int m=0; m<N; m++) {
					if(s[l][m]!=0)continue;
					else if(ans[0]==-1 && ans[1]==-1){//������ ģ��������, ���ڸ��� ���°�츦 ���� �ʱⰪ.
						ans[0]=l;
						ans[1]=m;//�ʱⰪ
					}
					int a = 0; //��������� cnt�� ����
					int b = 0; //�����ϴ� �л� cnt�� ����
					for(int d=0; d<4; d++) {
						int nx = l+dir[d][0];
						int ny = m+dir[d][1];
						if(nx>=0 && ny>=0 && nx<N && ny <N) {
							if(s[nx][ny]==0) a++;
							else if(arr[n].contains(s[nx][ny])){
								b++;
							}
						}
						
					}
					if(ans[3] == b) {
						if(ans[2]<a) {
							ans[0] = l;
							ans[1] = m;
							ans[2] = a;
						}else if(ans[2]==a) {
							if(ans[0]>l) {
								ans[0] = l;
								ans[1] = m;
							}else if(ans[0]==l) {
								if(ans[1]>m) {
									ans[1]=m;
								}
							}
						}
					}else if(ans[3]<b) {
						ans[0] = l;
						ans[1] = m;
						ans[2] = a;
						ans[3] = b;
					}
				}
			}
			s[ans[0]][ans[1]]=n;
			ans = new int[4];
			ans[0]=-1;
			ans[1]=-1;
		}
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int n = s[i][j];
				int check = 0;
				for(int d=0; d<4; d++) {
					int nx = i+dir[d][0];
					int ny = j+dir[d][1];
					if(nx>=0 && ny>=0 && nx<N && ny <N && arr[n].contains(s[nx][ny])) {
						check++;
					}
				}
				if(check==0) continue;
				sum += Math.pow(10, check-1);
			}
		}
		
		System.out.println(sum);
		
	}
}
