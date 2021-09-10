package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
     ���� �� ������ �ܼ��� BFS�� �䱸�ϴ� ������ �ƴմϴ�. �ֳ��ϸ�, BFS�� �ϱ� ���ؼ��� ��� ������ ����ġ�� �����ؾ� �Ѵٴ� ���� ������ �ʿ��ϱ� �����Դϴ�. �� ������ ����ġ�� 0�� ������ �ֱ� ������ �Ϲ������δ� �ܼ��� BFS�� �� �� ������, ������ Ư�� ������ �湮 ������ ���� �ܼ� BFS�ε� �쿬���� �׻� ������ ã�� �� ���� ���Դϴ�. �� ���� �� ������ �ϸ� �׻� ������ �����°��� �����ϴ� �� �ſ� ������ ���Դϴ�.

     �� ������ ���� �Ϲ�ȭ�� ��� (����ġ�� 0�� ������ �ִ� ���)�� ���� �ذ��Ϸ���, ��, �� ������ �ǵ���� Ǯ���� ������ ���� ������� ����� �� �ֽ��ϴ�.

* ���ͽ�Ʈ�� �˰���
* 0-1 BFS: ����ġ�� 0�� ������ ����� ������ ť�� �� �ڰ� �ƴ� �� �տ� �ִ� ���
* 2�� ������ �������� �������� �ʰ�, +1�̳� -1�� ���� ��ǥ�� ť�� ���� �� �� ��ǥ�� 2�� �ŵ����� ���� ��ǥ���� ���� ť�� �ִ� ���
 */
public class g5_13549 {
	private static boolean isVisited[]= new boolean[100001];
	private static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs(N));
	}

	private static int bfs(int index) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{index,0});
		
		while(!queue.isEmpty()) {
			int x;
			int weight;
			
			x = queue.peek()[0];
			weight = queue.peek()[1];
			queue.poll();
			
			if(x==K) {
				return weight;
			}
			isVisited[x] = true;
			int n1 = x*2;
			int n2 = x+1;
			int n3 = x-1;
			if(n1<=100000&&!isVisited[n1]) {
				queue.add(new int[] {n1,weight});
			}
			if(n3>=0&&!isVisited[n3]) {
				queue.add(new int[] {n3,weight+1});
			}
			if(n2<=100000&&!isVisited[n2]) {
				queue.add(new int[] {n2,weight+1});
			}
			
					
		}
		return 0;
	}
}
