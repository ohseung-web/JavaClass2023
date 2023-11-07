package shopMol02_OT;
import java.util.*;
public class Shooping extends UserMenu {

	ItemManager it = new ItemManager();
    UserMenu user = new UserMenu();
	Scanner scan = new Scanner(System.in);
	String menu =  "[1]�α���\n[2]�α׾ƿ�\n[3]����\n[0]����\n";
	String mageMenu ="[1]�α׾ƿ�\n[2][�����۰���]\n[3][��ٱ��ϸ���Ʈ]\n";
	String itemMenu ="[1][item �߰�]\n[2][item ����]\n[3][item ����]\n[0]����\n";

	//	�޴� ----------------------------------------------------------------------------
	public void menu() {
		while(true) {
			System.out.println();
			System.out.print(menu);
			System.out.print("�޴�����: ");
			int select = scan.nextInt();

			if(select==1) {
				login();
				if(log == 0) {
					managerMenu();
				}
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

	//	���θ޴� ----------------------------------------------------------------------------
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
				int caID=scan.nextInt();

				int n=0;
				for(int i=0 ; i< it.itemList.size(); i++) {
					if(it.category.get(caID).equals(it.itemList.get(i).category)) {
						System.out.print("[" + i + "]");
						it.itemList.get(i).printInfo();
					}else if(caID == -1){
						break;				}
				}
				System.out.println("�׸��� ���� :");
				int itemID = scan.nextInt();
				it.addCart(super.id[log], caID , itemID);
				
			}else if(select ==2) {
				System.out.println("=============��  ��ٱ��� ===========");
				for (int i = 0; i < it.jangList.size(); i++) {
					if(it.jangList.get(i).userId.equals(id[log])) {
						it.jangList.get(i).printCart();
					}
				}
				System.out.println("================================");
			}
		}
	}


	// ������ �޴� ----------------------------------------------------------------------------
	public void managerMenu() {
		while(true) {
			System.out.println();
			System.out.println(mageMenu);
			System.out.println("�޴� ����");
			int select = scan.nextInt();	

			if(select==1) {
				logout();
				break;
			}else if(select ==2) {
				itemmage();
				continue;
			}else if(select ==3) {
				System.out.println("============ ��ٱ��� ����Ʈ ========");
				it.printJang();
				System.out.println("================================");
			}
		}

	}

	// ������ �����޴� ----------------------------------------------------------------------------
	public void itemmage() {
		while(true) {
			System.out.println();
			System.out.println(itemMenu);
			System.out.println("�޴� ����");
			int select = scan.nextInt();	

			if(select==1) {
				System.out.println("�߰��� item �̸��� �Է��ϼ���");
				String addname = scan.next();
				System.out.println("�߰��� item �ݾ��� �Է��ϼ���");
				int addprice  = scan.nextInt();
				System.out.println("�߰��� item�� categorry��ȣ�� �Է��ϼ���");
				System.out.println("[0]���� [1]���� [2]���� [3]�����");
				int addcategory = scan.nextInt();
				it.addItem(addname, addprice, addcategory);
				it.printItemList();

			}else if(select ==2) {
				System.out.println("������ item  ��ȣ�� �Է��ϼ���");
				int deleteindex = scan.nextInt();
				it.deleteItem(deleteindex);
				it.printItemList();

			}else if(select ==3) {
				System.out.println("������ item ��ȣ�� �Է��ϼ���");
				int indexNUM = scan.nextInt(); 
				System.out.println("������ item �̸��� �Է��ϼ���");
				System.out.println("[item �ݾ׸� �����Ҷ�  item �̸��� �����״�� �Է��ϼ���]");
				String updatename = scan.next();
				System.out.println("������ item �ݾ��� �Է��ϼ���");
				System.out.println("[item �̸��� �����Ҷ�  item �ݾ��� �����״�� �Է��ϼ���]");
				int updateprice  = scan.nextInt();
				it.updateItem(indexNUM, updatename, updateprice);
				it.printItemList();

			}else if(select==0) {
				System.out.println("�����۰��� ����");
				user.logindex = -1;
				break;
			}
		}
	}

	//	�α��� �޼��� ----------------------------------------------------------------------------
	public void login() {
		if(log>-1) {
			System.out.println("�̹� �α��� ���Դϴ�.");
		} else {
			log = super.userLog();
		}
	}

	//	�α׾ƿ� �޼��� ----------------------------------------------------------------------------
	public void logout() {
		if(log<0) {
			System.out.println("�̹� �α׾ƿ� �����Դϴ�.");
		} else {
			log = -1;
			System.out.println("�ȳ����輼��.");
		}
	}

}
