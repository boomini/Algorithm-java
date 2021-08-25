import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); 
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		
		int[] minEdge = new int[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0; //�ּҽ���Ʈ�����
		minEdge[0] = 0; //������ ������ 0�� ��������� 0���� ����.
		
		for(int i=0; i<N; i++) {
			//1. ����Ʈ���� ���Ե��� ���� ���� �� �ּҰ�������� ���� ã��.
			int min = Integer.MAX_VALUE;
			int minVertex = -1; //�ּҰ�������� ���� ��ȣ
			for(int j=0; j<N; j++) {
				if(!visited[j]&&min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
				
			}
			visited[minVertex] = true; //����Ʈ���� ���Խ�Ŵ
			result += min;
			//2. ���õ� ���� �������� ����Ʈ���� ������� ���� Ÿ �������� ���� ��� �ּҷ� ������Ʈ
			for(int j=0; j<N;j++) {
				if(!visited[j]&&adjMatrix[minVertex][j]!=0&&adjMatrix[minVertex][j]<minEdge[j]) {
					minEdge[j]= adjMatrix[minVertex][j];
				}
				
			}
		}
		System.out.println(result);
	}
}
