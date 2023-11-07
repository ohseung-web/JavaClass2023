package collection.hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> pointmanagement = new HashMap<>();

		System.out.println("**  ����Ʈ ���� ���α׷��Դϴ�. **");

		while(true) {

			System.out.print("�̸��� ����Ʈ �Է� >>");
			String keyvalue = scan.nextLine();
			StringTokenizer st = new StringTokenizer(keyvalue);
			String name = st.nextToken().trim();
			if(name.equals("�׸�")) {
				System.out.println("����Ʈ ���� ����");
				break;
			}
			Integer point = Integer.parseInt(st.nextToken().trim());
			if(pointmanagement.containsKey(name)) {
				point += pointmanagement.get(name);
			}
			pointmanagement.put(name, point);

			for(String keys : pointmanagement.keySet()) {
				Integer pointScore = pointmanagement.get(keys);
				System.out.print("("+keys+","+pointScore+") ");
			}
			System.out.println();
		}
	
	}

}




