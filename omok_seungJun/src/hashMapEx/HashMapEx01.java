package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<>();
		
		System.out.println("���� �̸��� �α��� �Է��ϼ���.(��: korea 5000");
		while(true) {
			System.out.print("���� �̸�, �α� >> ");
			String input = scan.nextLine();
			if(input.equals("�׸�")) {
				break;
			}
			else {
				StringTokenizer st = new StringTokenizer(input);
				String nation = st.nextToken().trim();
				// parseInt�� �Ľ� ���α׷�����, ������ �м��ؼ� �ڷ����� �����Ѵ�.
				// �� �� parseInt�� ����Ŭ���� �ڷ����� ��� ����
				// (int, double ���� ��� �Ұ�)
				Integer population = Integer.parseInt(st.nextToken().trim());
				nations.put(nation, population);
			}
		}
		while(true) {
			System.out.print("�α� �˻� >> ");
			String searchPop = scan.nextLine();
			if(searchPop.equals("�׸�")) {
				System.out.println("�α� �˻� ����");
				break;
			}
			else if(nations.containsKey(searchPop)){
				System.out.println(searchPop+"�� �α��� "+nations.get(searchPop));
			}
			else {
				System.out.println(searchPop+"����� �����ϴ�.");
			}
		}
	}

}
