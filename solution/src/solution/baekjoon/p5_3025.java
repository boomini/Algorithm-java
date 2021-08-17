package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5_3025 {
	private static int R;
	private static int C;
	private static char map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			//map �Է¹ޱ�
			s = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}	
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(in.readLine());
			//ȭ��ź�� ������ �ذ����ִ� �Լ�
			check(0, num-1);
		}
		
		StringBuilder sb = new StringBuilder();
		//ȭ��ź ��� ���� ��, map ���
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}	
		System.out.println(sb.toString());
		

	}

	private static void check(int i, int j) {
		
		for(int k=i; k<R; k++) {
			//#1. ���� ���������� ���߰� ���´�.
			if(map[k][j]=='X') {
				//ó�����ڸ��� 'X'�� ���
				if(k-1<0) return;
				
				map[k-1][j] = 'O';
				return;
			}
			//#2. �Ʒ�ĭ�� ���� ȭ���϶�
			else if(map[k][j]=='O') {
				
				if(k-1>=0 && j-1>=0 && map[k-1][j-1]=='.' && map[k][j-1]=='.' ) {
					//#2-1. ���� ���ʾƷ��� ����������
					//���� ��ġ ���� ���ʰ�  ���ʾƷ��� Ȯ�� �� �� �� ������ ���ʾƷ��κ��� Ž���Ѵ�.
					check(k,j-1);
				}else if(k-1>=0 && j+1<C && map[k-1][j+1]=='.' && map[k][j+1]=='.') {
					//#2-2. ������-�������Ʒ��� ����������
					//���� ��ġ ���� �����ʰ�  �����ʾƷ��� Ȯ�� �� �� �� ������ �����ʾƷ��κ��� Ž���Ѵ�.
					check(k,j+1);
				}else {
					//#2-3. �� ���� �ش� �ȵǸ� ȭ��ź�� �ڸ��� ���߰� ���´�.
					map[k-1][j] = 'O';
					return;
				}
			}
			//#3. ���̶�� ȭ��ź�� ���߰� ���´�.
			else if(k==R-1){
				map[k][j] = 'O';
				return;
			}
			
		}
		
	}
}
