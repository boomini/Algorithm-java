package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
	private static int N = 8;
	private static int[] numbers;
	private static boolean[] isSelected;
	private static int cnt;
	private static ArrayList<Integer>[] arr;//�ο���� ����
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		isSelected = new boolean[N+1];
		numbers = new int[N];
		int K = Integer.parseInt(in.readLine());
		arr= new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		permutation(0);
		System.out.println(cnt);
	}
	
	private static void permutation(int cnt) {
		if(cnt==N) {
			//System.out.println(Arrays.toString(numbers));
			check(numbers);
			return;
		}
		//������ ��� ������ ����ִ� �迭��� ���ҿ� ���� �õ�
		for(int i = 1; i<=N; i++) {//i : �ε���
			if(isSelected[i]) continue; //�ε����� �ش��ϴ� ���� ��� ���� ���� ���� ����
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			//���� �ڸ����� ������ gogo
			permutation(cnt+1);
			
			isSelected[i] = false;
		}
	}

	private static void check(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			int n = numbers[i];
			for(int j=0; j<arr[n].size(); j++) {
				if(i-1>=0&&numbers[i-1]==arr[n].get(j))return;
				if(i+1<N&&numbers[i+1]==arr[n].get(j))return;
			}
		}
		cnt++;
		
	}
}
