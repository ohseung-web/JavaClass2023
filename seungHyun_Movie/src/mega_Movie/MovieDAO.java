package mega_Movie;

import java.text.SimpleDateFormat;
import java.util.*;

public class MovieDAO {
	Scanner scan = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	HashMap<String, String> movieLocalType = new HashMap<>();
	ArrayList<MovieDTO> movieDto = new ArrayList<>();
	MovieDTO mdto = new MovieDTO();
	int num=0;

	public MovieDAO() {
		info();
	}

	public void info() {
		addMovie(new MovieDTO(num++, "서울", "강남","s"));
		addMovie(new MovieDTO(num++, "서울", "종로","s"));
		addMovie(new MovieDTO(num++, "서울", "동대문","s"));
		movieLocalType.put("서울", "s");
		addMovie(new MovieDTO(num++, "경기", "부천","k"));
		addMovie(new MovieDTO(num++, "경기", "남양주","k"));
		addMovie(new MovieDTO(num++, "경기", "동두천","k"));
		movieLocalType.put("경기", "k");
		addMovie(new MovieDTO(num++, "인천", "부평","i"));
		addMovie(new MovieDTO(num++, "인천", "검단","i"));
		addMovie(new MovieDTO(num++, "인천", "청라","i"));
		movieLocalType.put("인천", "i");
	}

	// 영화추가 메서드
	public void addMovie(MovieDTO m) {
		movieDto.add(m);
	}

	// 영화목록 메서드
	public void movieList() {

		System.out.println("\t\t-- [영화 목록] --");
		System.out.println("--------------------------------------------");
		System.out.println("영화이름\t\t\t\t상영일");
		for(int i=0; i<mdto.getMovie().length; i++) {
			System.out.println("["+(i+1)+"]"+mdto.getMovie()[i]+"\t\t\t"
					+sdf.format(mdto.getDay()[i]));
		}
		System.out.println("--------------------------------------------");
		while(true) {
			System.out.println("[1]예매");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();
			if(select == 1) {
				localChoice();
				break;
			}else {
				break;
			}
		}

	}

	// 영화검색 메서드
	public void movieSearch() {
		System.out.print("영화명 검색");
		String movieName = scan.next();
		int check=0;

		System.out.println("\t\t-- [영화 목록] --");
		System.out.println("--------------------------------------------");
		System.out.println("영화이름\t\t\t\t상영일");
		for(int i=0; i<mdto.getMovie().length; i++) {
			if(mdto.getMovie()[i].equals(movieName)) {
				check = i;
			}
		}
		System.out.println("["+(1)+"]"+mdto.getMovie()[check]+"\t\t\t"
				+sdf.format(mdto.getDay()[check]));
		System.out.println("--------------------------------------------");
		while(true) {
			System.out.println("[1]예매");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();
			if(select == 1) {
				localChoice();
				//break;
			}else {
				break;
			}
		}
	}

	//지역선택 메서드
	public void localChoice() {
		int num = 1;
		int num1 = 1;
		
		while(true) {
			System.out.println();
			System.out.println("-- [지역 선택] --");
			for(String local : movieLocalType.keySet()) {
				System.out.println("["+(num++)+"]"+local);
			}
			System.out.println("--------------");
			System.out.println("[1]지역선택");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.print("지역 선택:");
				int localsel = scan.nextInt();
				System.out.println();
				System.out.println("-- [극장 선택] --");
				if(localsel == 1) {
					for(MovieDTO mo : movieDto) {
						if(mo.getFirstTheater().equals("s")) {
							System.out.println("["+(num1++)+"]" + mo.getTheater());  
						}
					}
					
				}else if(localsel == 2) {
					for(MovieDTO mo : movieDto) {
						if(mo.getFirstTheater().equals("k")) {
							System.out.println("["+(num1++)+"]" + mo.getTheater());  
						}
					}
				}else {
					for(MovieDTO mo : movieDto) {
						if(mo.getFirstTheater().equals("i")) {
							System.out.println("["+(num1++)+"]" + mo.getTheater());  
						}
					}
				}
			}else {
				break;
			}
			theaterChoice();
		}
		
	}

	// 극장선택 메서드
	public void theaterChoice() {
		while(true) {
				System.out.println("--------------");
				System.out.println("[1]극장선택");
				System.out.println("[2]이전");
				System.out.print("메뉴 선택:");
				int sel1 = scan.nextInt();
				if(sel1==1) {
					System.out.print("극장 선택");
					int theatersel = scan.nextInt();
					if(theatersel == 1 ) {
						dayChoice();
					}else if(theatersel == 2 ) {
						dayChoice();
					}else {
						dayChoice();
					}
				}else {
					break;
				}
			}
		}

	// 일자선택 메서드
	public void dayChoice() {
		int num3 = 1;
		while(true) {
			System.out.println();
			System.out.println("-- [날짜 선택] --");
			System.out.println("["+num3+"]"+mdto.day1+"일");
			System.out.println("["+(num3+1)+"]"+mdto.day2+"일");
			System.out.println("["+(num3+2)+"]"+mdto.day3+"일");
			System.out.println("--------------");
			System.out.println("[1]날짜선택");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.print("날짜 선택");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1 ) {
					timeChoice1();
				}else if(daysel == 2) {
					timeChoice2();
				}else {
					timeChoice3();
				}
			}else {
				break;
			}
		}
	}

	// 시간선택 메서드----------------------------------------------------------------
	public void timeChoice1() {
		int num4 = 1;
		while(true) {
			System.out.println("-- [시간 선택] --");
			for(int i=0; i<mdto.getTime().length; i++) {
				System.out.println("["+(num4++)+"]" + sdf2.format(mdto.getTime()[i])
				+"~"+(mdto.getTime()[i].getHours()+2)+":"+(mdto.getTime()[i].getMinutes()+20)); 
			}
			System.out.println("--------------");
			System.out.println("[1]시간선택");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();

			if(select == 1) {
				System.out.print("SCREEN");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1) {

				}
			}else {
				break;
			}
		}
	}

	public void timeChoice2() {
		int num4 = 1;
		while(true) {
			System.out.println();
			System.out.println("-- [시간 선택] --");

			for(int i=0; i<mdto.getTime2().length; i++) {
				System.out.println("["+(num4++)+"]" + sdf2.format(mdto.getTime2()[i])
				+"~"+(mdto.getTime2()[i].getHours()+1)+":"+(mdto.getTime2()[i].getMinutes()+50));
			}
			System.out.println("--------------");
			System.out.println("[1]시간선택");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();

			if(select == 1) {
				System.out.print("SCREEN");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1) {

				}
			}else {
				break;
			}
		}
	}

	public void timeChoice3() {
		int num4 = 1;
		while(true) {
			System.out.println();
			System.out.println("-- [시간 선택] --");
			for(int i=0; i<mdto.getTime3().length; i++) {
				System.out.println("["+(num4++)+"]" + sdf2.format(mdto.getTime3()[i])
				+"~"+(mdto.getTime3()[i].getHours()+2)+":"+(mdto.getTime3()[i].getMinutes()+10)); 
			}
			System.out.println("--------------");
			System.out.println("[1]시간선택");
			System.out.println("[2]이전");
			System.out.print("메뉴 선택:");
			int select = scan.nextInt();

			if(select == 1) {
				System.out.print("SCREEN");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1) {

				}
			}else {
				break;
			}
		}
	}
	//-----------------------------------------------------------------

}
