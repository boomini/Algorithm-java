
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //���� ����
		int start = 0;
		int end =  V-1; //������ �ε���
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//a�ܰ� : �湮���� ���� ������ �� �ּҰ���ġ�� ���� ����
			min = INFINITY;
			for(int j=0; j<V; ++j){
				if(!visited[j] && distance[j] < min){
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // ���� ���� �湮 ó��
			if(current == end){ // ���� ������ ���������̸� Ż��.
				break;
			}
			
			//b�ܰ�: current������ �������� �Ͽ� ���� �ִ� �ٸ� �湮���� ���� �����鿡 ���� ó��
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current][c] != 0
						&&  distance[c] > min+matrix[current][c]){
					distance[c] = min+matrix[current][c];
				}
			}
		}
		System.out.println(distance[end]);
		
	}

}
