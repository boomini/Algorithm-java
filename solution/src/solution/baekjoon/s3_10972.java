package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_10972 {
	private static int N;
	//next_permutation ����
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		np(arr);
		
	}

	private static void np(int[] arr) {
		int i = N-1;
		//#1 �ڿ������� Ž���Ͽ� ����� iã�� 
		while(i>0 && arr[i]<=arr[i-1]) i--;
		
		//�̹� �� ���ĵǾ� �������
		if(i==0) {
			System.out.println(-1);
			return;
		}
		//#2 i-1��ġ���� ��ȯ�� ū �� ã��
		int j = N-1;
		while(arr[i-1]>=arr[j])j--;
		
		swap(arr,i-1,j);
		
		//#3. �������� �� �ڱ��� �������� ������ ������ ������������
		int k = N-1;
		while(i<k) swap(arr, i++, k--);
		
		for (int x : arr) {
			System.out.print(x+ " ");
		}
		return;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
