package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> scholarshipMap = new HashMap<>();
		
		System.out.println("미래 장학금 관리 시스템입니다.");
		for(int i=0;i<5;i++) {
			System.out.print("이름과 학점 >> ");
			String input = scan.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			String name = st.nextToken().trim();
			Double credit = Double.parseDouble(st.nextToken().trim());
			if(credit >= 0.0 && credit <= 4.5) {
				scholarshipMap.put(name, credit);
			}
		}
		System.out.print("장학생 선발 학생 기준 입력 >> ");
		Double standard = scan.nextDouble();
		System.out.print("장학생 명단 : ");
		for(String names : scholarshipMap.keySet()) {
			if(scholarshipMap.get(names) > standard) {
				System.out.print(names+" ");
			}
		}
		
		scan.close();
	}

}
