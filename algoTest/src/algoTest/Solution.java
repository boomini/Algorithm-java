package algoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int i;
	int j;
	public Node(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	
}
public class Solution {
	private static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}}; //��,��,��,��
	private static int sum;
	private static boolean visited[][];
	private static int N;
	private static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			sum=0;
			arr= new int[N][N];
			visited = new boolean[N][N];
			Node fo=null;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						fo=new Node(i,j);
					}
				}
			}
			arr[fo.i][fo.j] = 0;
			dfs(fo,0);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j])sum++;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(Node fo,int cnt) {//���� �̵��Ҷ����� �װ����� �˻�.
		if(cnt==3) return;
		
		outer : for(int d=0; d<4; d++) {			
			int nx= fo.i;
			int ny = fo.j;
			int flag=0;
			// �� �� �� �̵�
			while(true) {
				nx=nx+dir[d][0];
				ny=ny+dir[d][1];
				if(nx>=0 && ny>=0 && nx<N &&ny<N) {//�̵��� �� �ִ��� üũ
					if(arr[nx][ny]==1) {//��⸦ ��������
						if(flag==1) {//���̿� �ϳ��� �־�����
							visited[nx][ny] = true;
							flag++;
							arr[nx][ny] = 0;
							dfs(new Node(nx,ny),cnt+1);
							arr[nx][ny]=1;
						}else if(flag==0){//���̿� �ϳ��� ��������
							flag++;
						}else{//�ϳ� �̻��̸� ���� ��.
							continue outer;
						}
						
					}else {//��⸦ ������ �ʾ�����
						if(flag==1)//���̿� ��Ⱑ �ϳ�����̵�����
							dfs(new Node(nx,ny),cnt+1);
					}
				}else {//�̵��� �� ������ while�� ����
					break;
				}
				
			}
			//���࿡ ����� �ִٸ� ��� �ٽ� Ž��
		}
		
	}
}
