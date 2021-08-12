package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2_3040_02 {
	private static int N = 9;
	private static int R = 7;
	private static int arr[] = new int[9];
	private static int comArr[] = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		int[] p = new int[N];
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		do {
			for (int i = 0; i < p.length; i++) {
				if(p[i] == 1) System.out.println(arr[i] + " ");
			}
		}while(np(p));
		
	}
	//���� ū ������ ������ true, ������ false
	private static boolean np(int[] p) {
		int N = p.length;
		//step1. �����(i)�� ã�´�. ����⸦ ���� ��ȯ��ġ(i-1)ã��
		int i = N-1;
		while(i>0&& p[i-1]>p[i]) i--;
		
		if(i==0) return false;
		
		//step2. 
		return true;
	}
	
}
