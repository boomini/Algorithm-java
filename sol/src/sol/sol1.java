package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sol1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���α׷��� ���� ������ ǥ���ϱ� ���� Ư���� ǥ����� �����Ѵ�. �ܾ ���ٷ� �����ϴ� ������ũǥ�����, 
		 * �ܾ �ٲ� ������ �빮�ڷ� �����ϴ� ī��ǥ����� ��ǥ���̴�. �ΰ��� ǥ������� ��ȯ�ϴ� ���α׷��� �����Ͻÿ�. 

			ex) this_is_long_variable_name �� �ԷµǸ�, thisIsLongVariableName �̶�� �����ϰ�, 
			thisIsLongVariableName �� �ԷµǸ�, this_is_long_variable_name �̶�� �����Ѵ�.
			
			
			public String changeConvection(String input){
			    String result = "";
			}

		 */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		StringTokenizer st = new StringTokenizer(s, "_");
		ArrayList<String> arr = new ArrayList<String>();
		while(st.hasMoreElements()) {
			arr.add(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		if(arr.size()==1) {
			//ī��ǥ����� ���
			char[] charray = s.toCharArray();
			
			for(int i=0; i<charray.length; i++) {
				if(charray[i]<97) {
					char c =(char) (charray[i]+32);
					sb.append("_").append(c);
					continue;
				}
				sb.append(charray[i]);
			}
		}else {
			//������ũǥ���
			for(int i=0; i<arr.size(); i++) {
				if(i==0) {
					sb.append(arr.get(i));
				}else {
					char[] charray=  arr.get(i).toCharArray();
					char c = (char)(charray[0] - 32);
					sb.append(c);
					for(int j=1; j<charray.length; j++) {
						sb.append(charray[j]);
					}
				}
			}
		}
		//'a' 97
		System.out.println(sb.toString());
	}
}
