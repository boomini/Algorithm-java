
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		System.out.println("���? ");
		int no = sc.nextInt();
		System.out.println("�츮�� �Ѹ���� ǥ�����ڸ�?");
		String msg = sc.next();
		System.out.println(no+"::"+msg);
	}
}
