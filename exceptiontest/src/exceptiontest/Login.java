package exceptiontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���̵�: ");
		String id = in.readLine();
		System.out.println("��й�ȣ : ");
		String pass = in.readLine();
		
		
		try {
			String name = login(id,pass);
			System.out.println(name+ "�� �ȳ��ϼ���");
		} catch (PasswordNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (idNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String login(String id, String pass) throws PasswordNotMatchException, idNotMatchException {
		if(id.equals("ssafy")) {
			if(pass.equals("1234")) {
				return "ȫ�浿";
			}else {
				throw new PasswordNotMatchException("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}else {
			throw new idNotMatchException("���̵� Ʋ�Ƚ��ϴ�.");
			
		}
	}
}
