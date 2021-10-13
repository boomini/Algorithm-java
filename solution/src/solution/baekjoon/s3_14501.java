package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int day[] = new int[N+1]; //�� ��¥�� ���� �� �ִ� �ִ��̵�
		int max = 0;
		for(int i=0; i<N; i++) {
			max=Math.max(day[i],max); //�������� ��¥�� �ִ밪.
			day[i+1] = Math.max(max, day[i+1]);//���� ��¥���� ����� ������ �� ������ �ִ밪.
			if(arr[i][0]+i>N) continue;//��¥�� �ش��ϴ� ����� ���� �� ��糯¥�� �Ѿ�� continue
			day[arr[i][0]+i] = Math.max(day[arr[i][0]+i], day[i]+arr[i][1]);//����� �������� �������� �� �ִ밪 ����
			
		}
		System.out.println(day[N]);
	}
}
