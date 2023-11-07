package meagmart;
import java.util.*;
public class Shopping {
Scanner scan = new Scanner(System.in);
	
	Basket basket = new Basket();
	User user = new User();

	String[] id = user.id;
	String[] item = basket.item;
	int[] price = basket.price;
	static int log = -1; //모두 공유
	
	String menu = "[MEGA MART]\n[1]로그인\n[2]로그아웃\n[3]쇼핑\n[4]장바구니\n[0]종료\n";
	
//	MEGA MART 메뉴
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("-----------");
			state();
			System.out.println("-----------");
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
			} else if(select==4) {
				if(log<0) {
					System.out.println("로그인 후 이용 가능");
				} else {
					basket.Cart();
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
			System.out.println("[상품목록]");
			for(int i=0; i<item.length; i++) {
				System.out.printf("[%d]%s\t%d원\n",(i+1), item[i], price[i]);
			}
			System.out.println("[0]뒤로가기");
			int select = basket.selectItem();
			
			if(select==0) {
				break;
			} 
		}
	}
	
//	-----------------------------------------------------------------------
	
//	로그인 상태
	public void state() {
		if(log<0) {
			System.out.println("상태: 로그아웃");
		} else {
			System.out.printf("상태: %s님 로그인\n", id[log]);
		}
	}
	
//	로그인
	public void login() {
		if(log>-1) {
			System.out.println("이미 로그인 중입니다.");
		} else {
			log = user.userLog();
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


