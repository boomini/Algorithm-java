package hwalgo29_����_07��_�躸��;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());//�ʹ产Ʈ�� ���� �����Ǽ�
		int d = Integer.parseInt(st.nextToken());//�ʹ��� ������
		int k = Integer.parseInt(st.nextToken());//�����ؼ� �Դ� ������ ��
		int c = Integer.parseInt(st.nextToken());//������ȣ
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		int cnt = 0;

		int visited[] = new int[3001];
		int i=0;
		for(; i<k; i++) {
			if(visited[arr[i]]==0) cnt++;
			visited[arr[i]]++;
		}

		int max = cnt;
		for(i=1;i<=N; i++) {
			if(max<=cnt) {
				if(visited[c]==0) {
					cnt=cnt+1;
					visited[c]++;
				}
				max = Math.max(cnt, max);
				if(max==k+1) break;
			}
			
			//������ �پ���
			visited[arr[i-1]]--;
			if(visited[arr[i-1]]==0) cnt--;
			
			//�������� �þ
			if(visited[arr[(i+k-1)%N]]==0) {
				cnt++;
			}
			visited[arr[(i+k-1)%N]]++;
			
		}

		System.out.println(max);
	}
}
