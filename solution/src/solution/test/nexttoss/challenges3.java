package solution.test.nexttoss;

class Solution2 {
	public boolean solution(String amountText) {
		boolean answer = true;

		// solution
		// 1. �Ǿ� 0�ΰ�� ����
		if (amountText.charAt(0) == '0' && amountText.length() != 1)
			return false;
		int check = 0;
		boolean check2 = false;
		for (int i = amountText.length() - 1; i >= 0; i--) {
			check ++ ;
			char c = amountText.charAt(i);
			if (check % 4 == 0 && check != 0) { 
				// �����ڰ� ������ ������ ��� ��� ������ó��, �ƴҰ�� ��� ����
				if (check2) {
					if (c == ',')
						continue;
					else
						return false;
				} else if (check2 && check != 4) {
					if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9') {
						continue;
					} else
						return false;
				}
				
				if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
						|| c == '8' || c == '9') {
					continue;
				} else if (c == ',') {
					check2 = true;// ,�����ִ� ��� ó��
					continue;
				} else
					return false;
			}

			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
					|| c == '9')
				continue;
			else
				return false;

		}
		return answer;
	}
}

public class challenges3 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		System.out.println(sol.solution("10000"));
		System.out.println(sol.solution("25,000"));
		System.out.println(sol.solution("39,00"));
		System.out.println(sol.solution("39,000,000,000,000,000,000"));
		System.out.println(sol.solution("39,000,000,00,0,000,000,000"));
		System.out.println(sol.solution("0500"));
	}

}
