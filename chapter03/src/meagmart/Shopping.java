package meagmart;
import java.util.*;
public class Shopping {
Scanner scan = new Scanner(System.in);
	
	Basket basket = new Basket();
	User user = new User();

	String[] id = user.id;
	String[] item = basket.item;
	int[] price = basket.price;
	static int log = -1; //��� ����
	
	String menu = "[MEGA MART]\n[1]�α���\n[2]�α׾ƿ�\n[3]����\n[4]��ٱ���\n[0]����\n";
	
//	MEGA MART �޴�
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("-----------");
			state();
			System.out.println("-----------");
			System.out.print(menu);
			System.out.print("�޴�����: ");
			int select = scan.nextInt();
			
			if(select==1) {
				login();
			} else if(select==2) {
				logout();
			} else if(select==3) {
				if(log<0) {
					System.out.println("�α��� �� �̿� ����");
				} else {
					shopMenu();
				}
			} else if(select==4) {
				if(log<0) {
					System.out.println("�α��� �� �̿� ����");
				} else {
					basket.Cart();
				}
			} else if(select==0) {
				System.out.println("���θ� ����");
				break;
			}
		}
	}
	
//	���θ޴�
	public void shopMenu() {
		while(true) {
			System.out.println();
			System.out.println("[��ǰ���]");
			for(int i=0; i<item.length; i++) {
				System.out.printf("[%d]%s\t%d��\n",(i+1), item[i], price[i]);
			}
			System.out.println("[0]�ڷΰ���");
			int select = basket.selectItem();
			
			if(select==0) {
				break;
			} 
		}
	}
	
//	-----------------------------------------------------------------------
	
//	�α��� ����
	public void state() {
		if(log<0) {
			System.out.println("����: �α׾ƿ�");
		} else {
			System.out.printf("����: %s�� �α���\n", id[log]);
		}
	}
	
//	�α���
	public void login() {
		if(log>-1) {
			System.out.println("�̹� �α��� ���Դϴ�.");
		} else {
			log = user.userLog();
		}
	}
	
//	�α׾ƿ�
	public void logout() {
		if(log<0) {
			System.out.println("�̹� �α׾ƿ� �����Դϴ�.");
		} else {
			log = -1;
			System.out.println("�ȳ����輼��.");
		}
	}
	
}


