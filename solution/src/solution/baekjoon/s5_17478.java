package solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5_17478 {
	public static String[] sen = new String[5];
	public static StringBuilder sb = new StringBuilder();
	public static String s = "";
	public static void recursive(int n) {
		
		if(n==0) {
			System.out.print(sb.toString());
			System.out.println(sen[0]);
			System.out.print(sb.toString());
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.print(sb.toString());
			System.out.println(sen[4]);
			return;
		}
		for ( int i=0; i<sen.length; i++) {
			System.out.print(sb.toString());			
			System.out.println(sen[i]);
			
			if(i==sen.length-2) {
				sb.append("____");
				recursive(n-1);
				sb.setLength(sb.length()-4);;
			}
				
		}
	}
	
	public static void fortest(int n) {
		String s = "";
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<sen.length; j++) {
				System.out.println(s + sen[j]);
			}
			s += "--";
		}
	}
	public static void sentence() {	
		sen[0] = "\"����Լ��� ������?\"";
		sen[1] = "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.";
		sen[2] = "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.";
		sen[3] = "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"";
		sen[4] = "��� �亯�Ͽ���.";				
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(sb.readLine());
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		sentence();
		recursive(count);
	}
}
