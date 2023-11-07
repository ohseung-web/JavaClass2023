package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> pointMap = new HashMap<>();
		
		System.out.println("** 포인트 관리 프로그램입니다. **");
		while(true) {
			System.out.print("이름과 포인트 입력 >> ");
			String input = scan.nextLine();
			if(input.equals("그만")) {
				System.out.println("포인트 관리 종료");
				break;
			}
			else {
				StringTokenizer st = new StringTokenizer(input);
				String name = st.nextToken().trim();
				Integer point = Integer.parseInt(st.nextToken().trim());
				
				if(pointMap.containsKey(name)){
					pointMap.replace(name, pointMap.get(name)+point);
				}
				else {
					pointMap.put(name, point);
				}
				for(String names : pointMap.keySet()) {
					System.out.print("("+names+","+pointMap.get(names)+") ");
				}
				System.out.println();
			}
		}
		scan.close();
	}

}
