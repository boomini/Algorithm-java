import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			//return this.weight - o.weight; //������ ��ȣ�� ��� ������.
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// ��������Ʈ �ۼ�, from, to, ���
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start,end,weight);
		}
		
		Arrays.sort(edgeList); //�������� ����
		
		make(); //��� ������ ������ �������� ����� ���
		
		//���� �ϳ��� �õ��ϸ� Ʈ�� ����� ��
		int cnt = 0, result = 0;;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == V-1) break; //����Ʈ�� �ϼ�
			}
		}
		System.out.println(result);
	}
	
	static int[] parents; //�θ���Ҹ� ����(Ʈ��ó�� ���)
	
	private static void make() {
		//��� ���Ҹ� �ڽ��� ��ǥ�ڷ� ����.
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	//a������ ������ ��ǥ�� ã��
	private static int find(int a) {
		if(a==parents[a]) return a; //�ڽ��� ��ǥ��
		return parents[a] = find(parents[a]); //�ڽ��� ���� ������ ��ǥ�ڸ� �ڽ��� �θ�� : path compression
	}
	
	// �� ���Ҹ� �ϳ��� �������� ��ġ��(��ǥ�ڸ� �̿��ؼ� ��ħ)
	private static boolean union(int a , int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; //�̹� ���� �������� ��ġ�� ����
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
