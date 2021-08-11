package comparetest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareTest {
	public static void main(String[] args) {
		// primitive Type ���� : Arrays.sort()
		int[] num1 = { 5, 6, 2, 9, 3, 1, 8, 7, 4 };
		Arrays.sort(num1);
		System.out.println(Arrays.toString(num1));

		Integer[] num2 = { 5, 6, 2, 9, 3, 1, 8, 7, 4 };
		List<Integer> list = Arrays.asList(num2);
		System.out.println("1. list : " + list);
		Collections.sort(list);
		System.out.println("2. ����(��������) : " + list);
		Collections.reverse(list);
		System.out.println("3. reverse(��������) : " + list);

		List<Integer> list2 = Arrays.asList(num2);
		System.out.println("4.list2 : " + list2);
		Collections.sort(list2, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
					//return i1.intValue() - i2.intValue();
				return i2.intValue() - i1.intValue();
				//�տ��� �ڸ� �����������,
				//�ڿ��� ���� ���� ��������
			}
		});
		System.out.println("5.���� �� : " + list2);
	}
}
