package muti_array;

import java.util.Scanner;

public class String_Example03_seungjun {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111", "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		int MAX_SIZE = 100;
		int[][] jang = new int [MAX_SIZE][2];
		int menu;

		boolean run = true;
		String inputId; // 입력한 ID
		String inputPw; // 입력한 PW
		String currentStatus = new String("로그아웃"); // 현재 상태 (초기값: 로그아웃)
		int log = -1; // 로그인 회원의 인덱스 번호 (-1일 경우 아이디/비밀번호 불일치)
		int productNum; // 상품번호
		boolean run_product = true; // 쇼핑을 선택했을 때 상품번호 입력 반복 key
		int cnt = 0; // 생성된 장바구니 배열의 개수
		int apple_1 = 0;
		int banana_1 = 0;
		int berry_1 = 0;
		int apple_2 = 0;
		int banana_2 = 0;
		int berry_2 = 0;
		int apple_3 = 0;
		int banana_3 = 0;
		int berry_3 = 0;

		while(run) {
			System.out.println("------------");
			System.out.println("상태 : "+currentStatus);
			System.out.println("------------");
			System.out.println("[MEGA MART]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[0]종료");
			System.out.println("[5]전체 출력");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				if(currentStatus.equals("로그아웃")) {
					System.out.print("ID입력 : ");
					inputId = scan.next();
					System.out.print("PW입력 : ");
					inputPw = scan.next();
					for(int i=0;i<ids.length;i++) {
						if(ids[i].equals(inputId)&&pws[i].equals(inputPw)) {
							System.out.println(ids[i]+"님, 환영합니다.");
							currentStatus = ids[i]+" 로그인";
							log = i;
							run_product = true;
						}
					}
					if(log==-1) {
						System.out.println("ID와 PW를 확인해주세요.");
					}
				}
				else {
					System.out.println("이미 로그인 된 상태입니다.");
				}	
				break;
			case 2:
				if(currentStatus.equals("로그아웃")) {
					System.out.println("로그인 후 이용 가능합니다.");
				}
				else {
					System.out.println("로그아웃 되었습니다.");
					currentStatus = "로그아웃";
					log = -1;
				}
				break;
			case 3:
				if(currentStatus.equals("로그아웃")) {
					System.out.println("로그인 후 이용 가능합니다.");
				}
				else {
					while(run_product) {
						System.out.println("[상품목록]");
						System.out.println("[1]사과");
						System.out.println("[2]바나나");
						System.out.println("[3]딸기");
						System.out.println("[4]뒤로가기");
						System.out.println("상품번호를 선택하세요 : ");
						productNum = scan.nextInt();
						switch(productNum) {
						case 1:
							if(cnt>=MAX_SIZE) {
								System.out.println("더 이상 추가할 수 없습니다.");
								continue; // skip 해서 while문으로 다시 감
							}
							else {
								jang[cnt][0] = log;
								jang[cnt][1] = 0;
								cnt++;
							}
							break;
						case 2:
							if(cnt>=MAX_SIZE) {
								System.out.println("더 이상 추가할 수 없습니다.");
								continue; // skip 해서 while문으로 다시 감
							}
							else {
								jang[cnt][0] = log;
								jang[cnt][1] = 1;
								cnt++;
							}
							break;
						case 3:
							if(cnt>=MAX_SIZE) {
								System.out.println("더 이상 추가할 수 없습니다.");
								continue; // skip 해서 while문으로 다시 감
							}
							else {
								jang[cnt][0] = log;
								jang[cnt][1] = 2;
								cnt++;
							}
							break;
						case 4:
							run_product = false;
							break;
						}
					}
				}
				break;
			case 4:
				if(currentStatus.equals("로그아웃")) {
					System.out.println("로그인 후 이용 가능합니다.");
				}
				else {
					/*for(int i=0;i<cnt;i++) {
						if(jang[i][0]==log&&jang[i][1]==0) {
							apple++;
						}
						else if(jang[i][0]==log&&jang[i][1]==1) {
							banana++;
						}
						else if(jang[i][0]==log&&jang[i][1]==2) {
							berry++;
						}
					}
					System.out.println("사과 : "+apple+"개");
					System.out.println("바나나 : "+banana+"개");
					System.out.println("딸기 : "+berry+"개");*/
					if(log==0) {
						for(int i=0;i<cnt;i++) {
							if(jang[i][1]==0) {
								apple_1++;
							}
							else if(jang[i][1]==1) {
								banana_1++;
							}
							else if(jang[i][1]==2) {
								berry_1++;
							}
						}
						System.out.println("사과 : "+apple_1+"개");
						System.out.println("바나나 : "+banana_1+"개");
						System.out.println("딸기 : "+berry_1+"개");
					}
					else if(log==1) {
						for(int i=0;i<cnt;i++) {
							if(jang[i][1]==0) {
								apple_2++;
							}
							else if(jang[i][1]==1) {
								banana_2++;
							}
							else if(jang[i][1]==2) {
								berry_2++;
							}
						}
						System.out.println("사과 : "+apple_2+"개");
						System.out.println("바나나 : "+banana_2+"개");
						System.out.println("딸기 : "+berry_2+"개");
					}
					else if(log==2) {
						for(int i=0;i<cnt;i++) {
							if(jang[i][1]==0) {
								apple_3++;
							}
							else if(jang[i][1]==1) {
								banana_3++;
							}
							else if(jang[i][1]==2) {
								berry_3++;
							}
						}
						System.out.println("사과 : "+apple_3+"개");
						System.out.println("바나나 : "+banana_3+"개");
						System.out.println("딸기 : "+berry_3+"개");
					}
				}
				break;
			case 0:
				System.out.println("프로그램 종료");
				run = false;
				break;
			case 5:
				for(int i=0;i<cnt;i++) {
					
						System.out.print(jang[i][0]+" ");
						System.out.println(jang[i][1]);
				}
				break;
			}
		}
		scan.close();
	}
}

