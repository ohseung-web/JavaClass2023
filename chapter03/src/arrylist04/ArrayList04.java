package arrylist04;
import java.util.*;
public class ArrayList04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // ��ĳ��
		ArrayList<String > nicknames = new ArrayList<>(); // ArrayList ����
		int[] lengthArr = new int[5]; // ���� ���ڿ� ���̸� ������ �迭
		int max = lengthArr[0]; // �ִ밪�� ������ �ν��Ͻ�

		for (int i = 0 ; i <= 4 ; i++) { // 5���� ������ �Է� �޴´�
			System.out.println("������ �Է� �� �ּ���!");
			nicknames.add(sc.nextLine());
		}

		for (int i = 0 ; i <= 4 ; i++) {
			// ArrayList�� ����� �� ������� ���̸� lengthArr�� �����Ѵ�
			lengthArr[i] = nicknames.get(i).length();
			if (max < lengthArr[i]) { // �ִ밪�� ã�� max�� �����Ѵ�
				max = lengthArr[i];
			}
		}

		for (int i = 0 ; i <= 4 ; i++) { // i��° �迭�� ���̰� max�� ���ٸ� ����Ѵ�
			if (max == nicknames.get(i).length()) {
				System.out.println("���� ���̰� �� ������ > " + nicknames.get(i));
			}
		}
		
		sc.close();
	}

}
