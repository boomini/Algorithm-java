package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_16236 {
	/*�Ʊ��� �ʱ�ũ�� = 2
	�ڽź��� ���� ����⸸ ���� �� �ִ�.
	����⸦ �ڽ��� ũ�⸸ŭ ������ ũ��+1
	�ڽŰ� ũ�Ⱑ ���� ������ ���� �� ������ ������ �� �ִ�.
	���̻� ���� �� �ִ� ����Ⱑ ������ ������ ���� ���� �����û.
	���� �� �ִ� ������� �Ÿ��� ���� ����� �����, ���� ���� ���� �ִ� �����, ���� ���� ���ʿ� �ִ� ����� 
	�Ʊ���� �̵��� 1��
	����⸦ ������ ��ĭ�� �ȴ�.
	���ʾȿ� ������ ����⸦ ��Ƹ��� �� �ֳ�
	
	1. ������ ����� sorting�ϰ�
	2. ���� ������ ����� ��� üũ
	*/ 
	private static int N;
	private static int arr[][];
	private static int babyI;
	private static int babyJ;
	private static int result;
	private static int babySize;
	private static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		babyI = 0;
		babyJ = 0;
		babySize = 2;
		result = 0;
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==9) {
					babyI = i;
					babyJ = j;
				}
				arr[i][j] = num;
			}
		}
		int cnt = 0;
		while(true) {
			if(BFS()) {
				//System.out.println(babyI + " " + babyJ + " " + babySize + " " + result);
				cnt++;
				if(cnt==babySize) {
					babySize+=1;
					cnt=0;
				}
				continue;
			}
			break;
		}
		System.out.println(result);
		
	}

	private static boolean BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {babyI, babyJ, 0});
		arr[babyI][babyJ] = 0;
		int minSecond = Integer.MAX_VALUE;
		int minI = Integer.MAX_VALUE;
		int minJ = Integer.MAX_VALUE;
		int dx[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		boolean flag = false;
		visited= new boolean[N][N];
		while(!queue.isEmpty()) {
			int currentI = queue.peek()[0];
			int currentJ = queue.peek()[1];
			int currentSecond = queue.peek()[2];
			if(currentSecond>minSecond) break;
			queue.poll();
			
			
			int fishSize = arr[currentI][currentJ];
			if(fishSize!=0&&fishSize<babySize) {
				flag = true;
				if(minSecond>currentSecond) {
					minSecond = currentSecond;
					minI = currentI;
					minJ = currentJ;
				}else if(minSecond==currentSecond) {
					if(minI>currentI) {
						minI = currentI;
						minJ = currentJ;
					}else if(minI==currentI) {
						if(minJ>currentJ) {
							minJ = currentJ;
						}
					}
				}
			}
			for(int i=0; i<4; i++) {
				int ni = currentI + dx[i][0];
				int nj = currentJ + dx[i][1];
				if(ni>=0 && nj >=0 && ni <N && nj<N && !visited[ni][nj] && arr[ni][nj]<=babySize) {
					visited[ni][nj] = true;
					//!!!!�߿�!!!!! �� ���� �湮ó��������!
					queue.add(new int[] {ni, nj, currentSecond+1});
				}
			}
			
		}
		
		if(flag) {
			babyI = minI;
			babyJ = minJ;
			result+=minSecond;
		}
		
		
		return flag;
		
	}
}
