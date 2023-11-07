package collection.hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<String, Integer>();

		System.out.println("���� �̸��� �α��� �Է��ϼ���.(��: korea 5000");

		// ���� �Է� HashMap ����
		while(true) {
			System.out.print("���� �̸�, �α� >> ");
			String keyValue = scan.nextLine();
			StringTokenizer st = new StringTokenizer(keyValue);
			String nation = st.nextToken().trim();
			if(nation.equals("�׸�")) {
				break;
			}
			Integer people = Integer.parseInt(st.nextToken().trim());

			// hashMap ����
			nations.put(nation, people);
		}

		// ���� �˻�			
		while(true) {
			System.out.print("�α� �˻� >> ");
			String nation2 = scan.next();

			if(nation2.equals("�׸�")) {
				System.out.println("�α� �˻� ����");
				break;
			}else if(nations.containsKey(nation2)) {
				System.out.println(nation2 + "�� �α��� "+ nations.get(nation2));
				continue;
			}else {
				System.out.println(nation2 + "����� �����ϴ�. ");
				continue;
			}
		}

	}
}


