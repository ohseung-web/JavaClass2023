package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<>();
		
		System.out.println("나라 이름과 인구를 입력하세요.(예: korea 5000");
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			String input = scan.nextLine();
			if(input.equals("그만")) {
				break;
			}
			else {
				StringTokenizer st = new StringTokenizer(input);
				String nation = st.nextToken().trim();
				// parseInt는 파싱 프로그램으로, 구문을 분석해서 자료형을 변경한다.
				// 이 때 parseInt는 레퍼클래스 자료형만 사용 가능
				// (int, double 등은 사용 불가)
				Integer population = Integer.parseInt(st.nextToken().trim());
				nations.put(nation, population);
			}
		}
		while(true) {
			System.out.print("인구 검색 >> ");
			String searchPop = scan.nextLine();
			if(searchPop.equals("그만")) {
				System.out.println("인구 검색 종료");
				break;
			}
			else if(nations.containsKey(searchPop)){
				System.out.println(searchPop+"의 인구는 "+nations.get(searchPop));
			}
			else {
				System.out.println(searchPop+"나라는 없습니다.");
			}
		}
	}

}
