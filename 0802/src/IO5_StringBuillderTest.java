
public class IO5_StringBuillderTest {
	public static void main(String[] args) {
//      StringBuilder�� ���� ���ڿ� �̾���̱� ���� ó���� �� �� �Ź� �޸𸮿� �ö󰡴� ���� ��������
      StringBuilder sb = new StringBuilder();
      sb.append("Hello ");
      sb.append("SAFFY!!");

//      !! �� ���� ���, ���� �ݺ����� ������ ������ �ݺ��� ���� �ٸ��� ����ϰ� ���� ��� ����
      sb.setLength(sb.length() - 2);
      System.out.println(sb.toString());
   }
}
