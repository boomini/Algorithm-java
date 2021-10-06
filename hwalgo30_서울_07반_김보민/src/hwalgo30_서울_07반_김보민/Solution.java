package hwalgo30_����_07��_�躸��;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			
			for(int i=0; i<N; i++) {
				if(check(arr[i], X)) {
					ans++;
					//System.out.println(Arrays.toString(arr[i]));
				};
				int cur[] = new int[N];
				for(int j=0; j<N; j++) {
					cur[j] = arr[j][i];
				}
				if(check(cur, X)) {
					ans++;
					//System.out.println(Arrays.toString(cur));
				};
				
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean check(int[] cur , int X) {
		
		//1.���ʰ� ���ؼ� Ŀ���¼��� �۾����¼��� Ȯ��
		
		//1-1. Ŀ���� ������ ������ ���̸� ����־���߰�,
		//1-2. �۾����� ������ ���ݺ��ͱ��̸� ����Ѵ�.
		
		//2. �� ���̰� X���� ũ�ų� ���ƾ��Ѵ�.
		int cnt = 1;
		int icur = cur[0];
		boolean flag = false;
		for(int i=1; i<N; i++) {
			if(Math.abs(icur-cur[i])>1) return false; //���� ���̰� 1�̻��̶��
			if(icur==cur[i]) {
				cnt++;
				continue;
			}
			else if(icur<cur[i]) {
				if(flag) {//��ȭ�� �߻������� ������ΰ� x�� �Ѿ���� �ϴ� ���
					if(cnt<2 * X)return false;
					else flag = false;
				}
				
				if(cnt>=X) {//1-1. Ŀ���� ������ ������ ���̸� ����־���߰�,
					cnt=1;
				}else {
					return false;
				}
				icur = cur[i];
			}else {
				if(flag) {//��ȭ�� �߻������� ������ΰ� x�� �Ѿ���� �ϴ� ���
					if(cnt<X) return false;
					else flag = false;
				}//
				
				cnt=1;//1-2. �۾����� ������ ���ݺ��ͱ��̸� ����Ѵ�.
				flag = true;//���̸� �� �ʿ䰡 �ִ�.
				icur = cur[i];
			}
		}
		
		if(flag && cnt<X) {//��ȭ�� �߻������� ������ΰ� x�� �Ѿ���� �ϴ� ���
			return false;
		}
		return true;
		
	}
}