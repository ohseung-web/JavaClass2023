package shopmal;

import java.util.Scanner;

public class Shooping extends UserMenu{

	ItemManager it = new ItemManager();

	Scanner scan = new Scanner(System.in);
	String menu =  "[1]�α���\n[2]�α׾ƿ�\n[3]����\n[0]����\n";

	//	�޴�
	public void menu() {
		while(true) {
			System.out.println();
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
			System.out.println("[1]���θ��\n[2]��ٱ���\n[0]�ڷΰ���\n");
			System.out.println("�޴� ����");
			int select = scan.nextInt();		
			
			
			if(select==0) {
				break;
			}else if(select ==1) {
				
				it.printCategory();
				System.out.println("���θ�� ����    [�ڷΰ��� -1] : ");
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
				System.out.println("�׸��� ���� :");
				int k = scan.nextInt();
				
			}else if(select ==2) {

			}
		}
	}

	//	-----------------------------------------------------------------------

	//	�α���
	public void login() {
		if(log>-1) {
			System.out.println("�̹� �α��� ���Դϴ�.");
		} else {
			log = super.userLog();
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

