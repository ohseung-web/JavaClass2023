package shopmal;

import java.util.Scanner;

public class Shooping extends UserMenu{

	ItemManager it = new ItemManager();

	Scanner scan = new Scanner(System.in);
	String menu =  "[1]로그인\n[2]로그아웃\n[3]쇼핑\n[0]종료\n";

	//	메뉴
	public void menu() {
		while(true) {
			System.out.println();
			System.out.print(menu);
			System.out.print("메뉴선택: ");
			int select = scan.nextInt();

			if(select==1) {
				login();
			} else if(select==2) {
				logout();
			} else if(select==3) {
				if(log<0) {
					System.out.println("로그인 후 이용 가능");
				} else {
					shopMenu();
				}
			} else if(select==0) {
				System.out.println("쇼핑몰 종료");
				break;
			}
		}
	}

	//	쇼핑메뉴
	public void shopMenu() {


		while(true) {
			System.out.println();
			System.out.println("[1]쇼핑목록\n[2]장바구니\n[0]뒤로가기\n");
			System.out.println("메뉴 선택");
			int select = scan.nextInt();		
			
			
			if(select==0) {
				break;
			}else if(select ==1) {
				
				it.printCategory();
				System.out.println("쇼핑목록 선택    [뒤로가기 -1] : ");
				int sel=scan.nextInt();
                
				int n=0;
				if(it.category.get(sel).equals(it.itemList.get(sel).category)) {
					//it.printItemList();
			    	System.out.print("[" + n + "]");
			         it.itemList.get(sel).print();;
                    n += 1; 
                }else if(sel == -1){
                	break;
                }
				System.out.println("항목을 선택 :");
				int k = scan.nextInt();
				
			}else if(select ==2) {

			}
		}
	}

	//	-----------------------------------------------------------------------

	//	로그인
	public void login() {
		if(log>-1) {
			System.out.println("이미 로그인 중입니다.");
		} else {
			log = super.userLog();
		}
	}

	//	로그아웃
	public void logout() {
		if(log<0) {
			System.out.println("이미 로그아웃 상태입니다.");
		} else {
			log = -1;
			System.out.println("안녕히계세요.");
		}
	}

}

