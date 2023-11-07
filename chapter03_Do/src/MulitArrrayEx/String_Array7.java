package MulitArrrayEx;
import java.util.*;
public class String_Array7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] ids = {"qwer", "javaking", "abcd","kjb1045"};
		String[] pws = {"1111",     "2222", "3333","1045"};

		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2]; // 전체 장바구니 목록

		int count = 0; // 아이템을 사는 개수 
		String[] items = {"사과", "바나나", "딸기"};
		int[][] cartcount = new int[ids.length][items.length]; // 회원별 아이템 개수 저장

		int log = -1; // 로그인 체크키

		// 전체메뉴 선택 -------------------------------------------------------------------------
		while(true) {

			System.out.println("------------");
			System.out.print("상태 : ");
			if(log ==  -1) {
				System.out.println("로그아웃");
			}else {
				System.out.println(ids[log] + " 로그인");
			}
			System.out.println("------------");

			System.out.println("[MEGA MART]");
			System.out.println("[1]로 그 인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼     핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]전체출력");
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
          // 1번메뉴 선택 시 ------------------------------------------------------------------------------------
			if(sel == 1) {
				System.out.print("ID입력 : ");
				String myId = scan.next();
				System.out.print("Pw입력 : ");
				String myPw = scan.next();
               
				for(int i=0; i<ids.length; i++) {
					if(myId.equals(ids[i]) && myPw.equals(pws[i])) {
						log = i;
					}
				}
				if(log == -1) {
					System.out.println("ID와 PW를 확인해주세요.");
				}else {
					System.out.println(ids[log] + "님, 환영합니다.");
				}
				
			} // 2번메뉴 선택 시 ------------------------------------------------------------------------------------
			else if(sel == 2) {
				log = -1;
				System.out.println("로그아웃 되었습니다.");
			}
			 // 3번메뉴 선택 시 ------------------------------------------------------------------------------------
			else if(sel == 3) {
				if(log == -1) {
					System.out.println("로그인 후 이용가능합니다.");
					continue;
				}
                // 쇼핑 목록 메뉴 -------------------------------------------------------------------------------------
				while(true) {
					System.out.println("[상품목록]");
					for(int i=0; i<items.length; i++) {
						System.out.println("[" + (i+1) + "]" + items[i]);
					}
					System.out.println("[4]뒤로가기");

					System.out.print("상품번호를 선택하세요 : ");
					int choice = scan.nextInt();
					if(choice == 4) {
						break;
					}
					// id별 쇼핑한 itemt들의 개수를 item별로 cartcount에 담는다.
					jang[count][0] = log; // 장바구니 0번째 열에 log인 한 index 번호를 담는다.
					jang[count][1] = choice -1; // 장바구니 1번째 열에 내가 산 item index 번호를 담는다.
					cartcount[log][choice-1] ++; // id별 쇼핑한 itemt들의 개수를 item별로 cartcount에 담는다.
					count++;
				}
				
			}
			 // 4번메뉴 선택 시 ------------------------------------------------------------------------------------
				else if(sel == 4) {
                   // 내장바구니 출력 단 로그인상태에서만 가능 함
					if( log == -1 ) {
						System.out.println("로그인을 해주세요~");
					}else {
						System.out.println();
						System.out.println("---- 내 장바구니 목록 -----");
						for(int i=0; i<items.length; i++) {
							if(cartcount[log][i] != 0 ) { 
								System.out.println(items[i]+":"+cartcount[log][i] + "개");
							}
						}
					}
				}
			 // 0번메뉴 선택 시 ------------------------------------------------------------------------------------
				else if(sel == 0) {
					System.out.println("프로그램 종료");
					break;
				}
			 // 5번메뉴 선택 시 ------------------------------------------------------------------------------------
				else if(sel == 5) {
					// 전체장바구니 출력 단, 로그아웃 상태에서만 가능 함
					if(log != -1) {
						System.out.println("로그아웃 후 이용하여 주세요");
						continue;
					}
					System.out.println();
					System.out.println("--- 전체 장바구니 목록 ---");
					for(int i=0;i<count;i++) {
						System.out.println("|"+ids[jang[i][0]]+"|"+items[jang[i][1]]+"|");
					}
				}
			}
			scan.close();
		}

	}
