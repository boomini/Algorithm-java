package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_1916 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		//������ ����
		int M = Integer.parseInt(in.readLine());
		//������ ����
		int arr[][] = new int[N+1][N+1];
		int distance[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			//ù��°�� ��ߵ����� ��ȣ, �������� ���ù�ȣ, �������
			if(arr[start][end]!=-1) {
				arr[start][end] = Math.min(arr[start][end], val);
				//������� �������� ���� ������ �������ϰ�� �ּҰ��� �޴´�.
			}else {
				arr[start][end] = val;
			}
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		//�ʱⰪ ����
		int min = Integer.MAX_VALUE;
		int current = 0;
		outer : for(int i=1; i<=N; i++) {
			min = Integer.MAX_VALUE;
			//a�ܰ� : �湮���� ���� ������ �� �ּҰ���ġ�� ���� ����
			for(int j=1; j<=N; j++) {
				if(!visited[j]&&distance[j]<min) {
					min = distance[j];
					current = j; 
				}
			}
			
			visited[current] = true;
			if(current==end) {
				break outer;
			}
			//b�ܰ� : current������ �������� �Ͽ� �� �� �ִ� �ٸ� �湮���� ���� �����鿡 ���� ó��
			for(int k=1; k<=N; k++) {
				if(!visited[k] && arr[current][k] != -1 && distance[k] > min+arr[current][k]) {
					distance[k] = min + arr[current][k];
 				}
			}
		}
		
		
		System.out.println(distance[end]);
		
	}
}
