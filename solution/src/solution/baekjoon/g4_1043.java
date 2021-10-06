package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node3{
	int i; //��� ����
	ArrayList<Integer> arr; //����� ��帮��Ʈ
	public Node3(int i) {
		this.i = i;
		this.arr = new ArrayList<>();;
	}
	
}
public class g4_1043 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // ����� ��
		int M = Integer.parseInt(st.nextToken()); // ��Ƽ�� ��
		Node3[] arr = new Node3[N+1];//���
		boolean check[] = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new Node3(i);
		}
		st = new StringTokenizer(in.readLine());
		int tN = Integer.parseInt(st.nextToken()); //������ �ƴ� ��
		Queue<Integer> q = new LinkedList<Integer>(); //������ �ƴ� ��� ����Ʈ
		for(int i=0; i<tN; i++) {
			int num = Integer.parseInt(st.nextToken());
			q.add(num);//ť���߰�
			check[num] = true; //������ �ƴ»�� üũ
		}
		ArrayList<Integer>[] meeting = new ArrayList[M];
		for(int i=0; i<M; i++) {//����Ʈ ����(��Ƽ)
			st = new StringTokenizer(in.readLine());
			meeting[i] = new ArrayList<Integer>();

			int num=Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			meeting[i].add(first);
			for(int j=0;j<num-1; j++) {//��Ƽ�� ������ �������ŭ
				int pn = Integer.parseInt(st.nextToken()); //��Ƽ�� �����ѻ��
				arr[first].arr.add(pn);
				arr[pn].arr.add(first);
				meeting[i].add(pn);
			}
		}
		
		while(!q.isEmpty()) {//������ �ƴ� ����Ʈ ��� �̾Ƴ���!
			int num = q.poll();
			for(int i = 0; i<arr[num].arr.size(); i++) {
				int linknum = arr[num].arr.get(i);
				if(!check[linknum]) {
					check[linknum] = true;
					q.add(linknum);
				}			
			}
		}
		ArrayList<Integer> per = new ArrayList<Integer>();
		for(int i=0; i<check.length; i++) {
			if(check[i]) {
				per.add(i);
			}
		}
		
		int ans= 0;
		outer : for(int i=0; i<M; i++) {
			for(int j=0; j<meeting[i].size(); j++) {
				if(per.contains(meeting[i].get(j))) continue outer;
			}
			ans++;
		}
		
		System.out.println(ans);
	}
}

