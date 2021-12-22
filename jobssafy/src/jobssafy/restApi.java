package jobssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class restApi {
	public static void main(String[] args) throws IOException {
		//HttpURLConnection�� ����Ͽ� JSON POST ��û �ۼ�
		//1.URL ��ü �����
		URL url = new URL("http://13.125.222.176/quiz/jordan");
		//2. ���� ����
		//HttpURLConnection=> url��ü���� openConnection �޼��带 ȣ���Ͽ� HttpURLConnection ��ü�� ������ �� �ִ�.
		//�߻�Ŭ�����̹Ƿ� HttpURLConnection�� ���� �ν��Ͻ�ȭ �� �� ����.
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		//3. ��û��� ����
		con.setRequestMethod("POST");
		//4. ��û ������ ���� ��� �Ű� ���� ����
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		//5. ���� ���� ���� ����
		con.setRequestProperty("Accept", "application/json");
		//6. �������� �����µ� ������ ���Ǵ��� Ȯ��
		con.setDoOutput(true);
		//7. ���� ����
		String jsonInputString ="{\"nickname\": \"���� 4�� �躸��\" , \"yourAnswer\" : \"kubernetes\"}";
		try(OutputStream os = con.getOutputStream()){
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input,0,input.length);
		}
		//8. �Է� ��Ʈ������ ���� �б�
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(con.getInputStream(), "utf-8"))){
			System.out.println(br.readLine());
		}
	}
}
