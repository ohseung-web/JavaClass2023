package collection.hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> excellentStudent = new HashMap<>();


		System.out.println("�̷� ���б� ���� �ý��� �Դϴ�.");
		// ���� ����
		for(int i=0; i<5; i++) {
			System.out.print("�̸��� ���� >> ");
			String keyvalue = scan.nextLine();
			StringTokenizer st = new StringTokenizer(keyvalue);
			String name = st.nextToken().trim();
			Double grade = Double.parseDouble(st.nextToken().trim());
			excellentStudent.put(name, grade);
		}

		System.out.print("���л� ���� �л� ���� �Է� >>");
		double standard = scan.nextDouble();

		// �������� �̻� ���
		System.out.print("���л� ��� :"); 
		for(String student : excellentStudent.keySet()) {
			double sg = excellentStudent.get(student);
			if(sg >= standard ) {
                 System.out.print(student+" ");
			}
		}



	}

}
