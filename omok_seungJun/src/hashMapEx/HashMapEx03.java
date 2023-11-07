package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> scholarshipMap = new HashMap<>();
		
		System.out.println("�̷� ���б� ���� �ý����Դϴ�.");
		for(int i=0;i<5;i++) {
			System.out.print("�̸��� ���� >> ");
			String input = scan.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			String name = st.nextToken().trim();
			Double credit = Double.parseDouble(st.nextToken().trim());
			if(credit >= 0.0 && credit <= 4.5) {
				scholarshipMap.put(name, credit);
			}
		}
		System.out.print("���л� ���� �л� ���� �Է� >> ");
		Double standard = scan.nextDouble();
		System.out.print("���л� ��� : ");
		for(String names : scholarshipMap.keySet()) {
			if(scholarshipMap.get(names) > standard) {
				System.out.print(names+" ");
			}
		}
		
		scan.close();
	}

}
