package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx02 {

	public static void main(String[] args) {
		HashMap<String, Location> hashmap = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("도시,경도,위도를 입력하시오.");
		for(int i=0;i<4;i++) {
			System.out.print(">> ");
			String input = scan.nextLine();
			StringTokenizer st = new StringTokenizer(input,",");
			String city = st.nextToken().trim();
			Integer latitude = Integer.parseInt(st.nextToken().trim());
			Integer longitude = Integer.parseInt(st.nextToken().trim());
			hashmap.put(city, new Location(city,latitude,longitude));
		}
		System.out.println("----------------------------------------");
		for(String key : hashmap.keySet()) {
			System.out.println(hashmap.get(key));
		}
		System.out.println("----------------------------------------");
		while(true) {
			System.out.print("도시 이름 >> ");
			String cityName = scan.next();
			if(cityName.equals("그만")) {
				System.out.println("정보 검색 종료");
				break;
			}
			else if(hashmap.containsKey(cityName)) {
				System.out.println(hashmap.get(cityName));
			}
			else {
				System.out.println(cityName+"는 없습니다.");
			}
		}
	}

}
