package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * �Լ��� �ԷµǴ� �ð��� 12�ð� ǥ�������, AM/PM�� �Բ� ǥ��˴ϴ�.

24�ð� ǥ������� Ǯ���ϸ� ������ �����ϴ�.

00:00:00 ~ 11:59:59 --> AM 00:00:00 ~ AM 11:59:59
12:00:00 ~ 23:59:59 --> PM 00:00:00 ~ PM 11:59:59

�Էµ� ù��° �ð����� �ι�° �ð��� �Ǵµ� �ɸ��� �ð��� ���ϴ� �Լ��� �����Ͻÿ�.

(AM 00:00:01, AM 00:00:02) �� �ԷµǸ�, ù��° �ð����� �ι�° �ð��� �Ǳ���� �ɸ��� �ð��� 1�� �̹Ƿ� 00:00:01 ���ϵ˴ϴ�.
(PM 01:00:00, AM 01:00:00) �� �ԷµǸ�, ù��° �ð����� �ι�° �ð��� �Ǳ���� �ɸ��� �ð��� 12�ð� �̹Ƿ� 12:00:00�� ���ϵ˴ϴ�.

*����1: �Է½ð����� valid�մϴ�.
*����2: AM 00:00:00�� �Էµ��� �ʽ��ϴ�.
*����3: Date, time, difftime �� �ý��� ���� class/function ������� �ʾƾ� �մϴ�.

 */
public class sol3 {
	public static String solution(String start, String end) {
		StringTokenizer st = new StringTokenizer(start, " ");
		String startString = st.nextToken();
		String startTime = st.nextToken();
		//���۽ð�
		
		
		st = new StringTokenizer(end, " ");
		String endString = st.nextToken();
		String endTime = st.nextToken();
		//�����½ð�
		
		st = new StringTokenizer(startTime, ":");
		int shour = Integer.parseInt(st.nextToken());
		int smin = Integer.parseInt(st.nextToken());
		int ssec = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(endTime, ":");
		int ehour = Integer.parseInt(st.nextToken());
		int emin = Integer.parseInt(st.nextToken());
		int esec = Integer.parseInt(st.nextToken());
		
		String ans="";
		if(startString.equals(endString)) {
			
			//1. AM/PM�� �������
			ans = calc(shour, smin, ssec, ehour, emin, esec);
		}else if(startString.equals("AM")&&endString.equals("PM")) {
			//2. AM/PM
			ans =calc(shour, smin, ssec, ehour+12, emin, esec);
		}else if(startString.equals("PM")&&endString.equals("AM")) {
			//3. PM/AM
			ans =calc(shour+12, smin, ssec, ehour+24, emin, esec);
		}
		return ans;
	}

	
	private static String calc(int shour, int smin, int ssec, int ehour, int emin, int esec) {
		int hour = 0;
		int min = 0;
		int sec = 0;
		if(esec-ssec<0) {
			sec = 60+(esec-ssec);
			smin-=1;
		}else {
			sec = esec-ssec;
		}
		
		if(emin-smin<0) {
			min = 60+(emin-smin);
			shour-=1;
		}else {
			min = emin-smin;
		}
		
		hour = ehour-shour;
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(hour).append(":");
		if(min<10) {
			sb.append("0");
		}
		sb.append(min).append(":");

		
		if(sec<10) {
			sb.append("0");
		}
		sb.append(sec);

		
		return sb.toString();
		
	}


	public static void main(String[] args) throws IOException {
		System.out.println(solution("AM 00:00:00", "AM 11:59:59"));
		System.out.println(solution("PM 01:00:00", "AM 01:00:00"));
		System.out.println(solution("PM 02:27:00", "AM 07:23:00"));
	}

}
