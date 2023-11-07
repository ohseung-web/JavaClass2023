package capitalGame;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
	private HashMap<String,String> capitalMap = new HashMap<>();
	
	public Game() {
		Scanner scan = new Scanner(System.in);
		initialCapitalMap();
		System.out.println("*** 수도 맞추기 게임을 시작합니다. ***");
		while(true) {
			System.out.print("입력 : 1, 퀴즈 : 2, 종료 : 3 >> ");
			int menu = scan.nextInt();
			if(menu==1) {
				put();
			}
			else if(menu==2) {
				quiz();
			}
			else if(menu==3) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			else {
				System.out.println("유효하지 않은 메뉴입니다.");
			}
		}
		scan.close();
	}

	public HashMap<String, String> getCapitalMap() {
		return capitalMap;
	}

	public void setCapitalMap(HashMap<String, String> capitalMap) {
		this.capitalMap = capitalMap;
	}
	
	public void initialCapitalMap() { // 8개 나라의 수도를 미리 입력하는 메서드
		capitalMap.put("한국", "서울");
		capitalMap.put("호주", "시드니");
		capitalMap.put("미국", "워싱턴DC");
		capitalMap.put("일본", "도쿄");
		capitalMap.put("중국", "베이징");
		capitalMap.put("독일", "베를린");
		capitalMap.put("캐나다", "오타와");
		capitalMap.put("브라질", "브라질리아");
	}
	
	public void put() { // 입력 메서드
		Scanner scan = new Scanner(System.in);
		System.out.println("현재 "+capitalMap.size()+"개 나라의 수도가 입력되어 있습니다.");
		while(true) {
			System.out.print("나라와 수도 입력"+(capitalMap.size()+1)+" >> ");
			String input = scan.nextLine();
			if(input.equals("그만")) {
				break;
			}
			else {
				StringTokenizer st = new StringTokenizer(input);
				String nation = st.nextToken().trim();
				String capital = st.nextToken().trim();
				if(capitalMap.containsKey(nation)) {
					System.out.println(nation+"는 이미 있습니다.");
				}
				else {
					capitalMap.put(nation, capital);
				}
			}
		}
	}
	
	public void quiz() { // 퀴즈 메서드
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print(capitalMap.get(null)+"의 수도는 ? ");
			String answer = scan.next();
			if(answer.equals("그만")) {
				break;
			}
			else if(answer.equals(capitalMap.get(null))) {
				System.out.println("정답!!");
			}
			else {
				System.out.println("아닙니다.!!");
			}
		}
	}
}
