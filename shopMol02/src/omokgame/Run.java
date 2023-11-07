package omokgame;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Run extends Ranking{
int sel ;
y s2 =new y();
public void a() {
	MemberAdd();
}public void b() {
	MemberSub();
}public void c() {
	Login();
}public void d() {
	Logout();
}public void e() {
	omokpan();
}public void f() {
	Game();
}public void g() {
	ranking();
}public void h() {
	game2();
}public void q() {
	tg();
}
public void zz() {
	
    s2.update();
	
}
	public void Menu() {
		
		System.out.println("○●●●●●○");
		System.out.println("○게임　랜드○");
		System.out.println("○●●●●●○");
	
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]오목하기");
		System.out.println("[6]사다리게임");
		System.out.println("[7]탕수육게임");
		System.out.println("[8]윷놀이(업데이트중)");
		System.out.println("[9]랭킹확인");
		System.out.println("[10]게임종료");
		System.out.println("메뉴를 선택하세요");
		System.out.println();
		System.out.print("Menu : ");
		sel = scan.nextInt();
		
	}
	
	public void run() {
		
		while(true) {
			Menu();
			
			if(sel ==1) {
				a();
			}else if (sel == 2) {
		   b();
		       
			}else if (sel == 3) {
		    if(log == -1) {
		    	c();
		    }else {
		    	System.out.println("이미 로그인 상태입니다.");
		    }
		       
			}else if (sel == 4) {
				if(log != -1) {
					d();
				}else {
					System.out.println("로그인 먼저 해주세요.");
				}
		    
			}else if (sel == 5) {
			if(log != -1) {
				e();
				f();
			}else {
				System.out.println("로그인후 이용해주세요");
			}
				
		       
			}else if (sel == 6) {
				if(log != -1) {
					h();
				}else {
					System.out.println("로그인후 이용해주세요");
				}
					
			       
				}else if (sel == 9) {
		        g();
		       
			}else if (sel == 10) {
		     System.out.println("게임종료");
		     break;
			}else if (sel == 7) {
		        q();
		       
			}else if(sel ==8) {
				zz();
			}
			
		}
		
		
	}
}
