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
		
		System.out.println("�ۡܡܡܡܡܡ�");
		System.out.println("�۰��ӡ������");
		System.out.println("�ۡܡܡܡܡܡ�");
	
		System.out.println("[1]ȸ������");
		System.out.println("[2]ȸ��Ż��");
		System.out.println("[3]�α���");
		System.out.println("[4]�α׾ƿ�");
		System.out.println("[5]�����ϱ�");
		System.out.println("[6]��ٸ�����");
		System.out.println("[7]����������");
		System.out.println("[8]������(������Ʈ��)");
		System.out.println("[9]��ŷȮ��");
		System.out.println("[10]��������");
		System.out.println("�޴��� �����ϼ���");
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
		    	System.out.println("�̹� �α��� �����Դϴ�.");
		    }
		       
			}else if (sel == 4) {
				if(log != -1) {
					d();
				}else {
					System.out.println("�α��� ���� ���ּ���.");
				}
		    
			}else if (sel == 5) {
			if(log != -1) {
				e();
				f();
			}else {
				System.out.println("�α����� �̿����ּ���");
			}
				
		       
			}else if (sel == 6) {
				if(log != -1) {
					h();
				}else {
					System.out.println("�α����� �̿����ּ���");
				}
					
			       
				}else if (sel == 9) {
		        g();
		       
			}else if (sel == 10) {
		     System.out.println("��������");
		     break;
			}else if (sel == 7) {
		        q();
		       
			}else if(sel ==8) {
				zz();
			}
			
		}
		
		
	}
}
