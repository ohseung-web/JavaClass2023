package shopmol_seungJun;

import java.util.*;

public class Shopping extends User {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	boolean run = true;
	int menu = -1;

	public void menu() {
		while (run) {
			System.out.println("[1]�α���");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]����");
			System.out.println("[0]����");
			System.out.print("�޴�����: ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				login();
				break;
			case 2:
				logout();
				break;
			case 3:
				shopMenu();
				run = true;
				break;
			case 0:
				run = false;
				System.out.println("���θ� ����");
				break;
			}
		}
		scan.close();
	}

	public void shopMenu() {
		if (log == -1) {
			System.out.println("�α׾ƿ� �� �̿����ֽʽÿ�.");
		} 
		else {
			run = true;
			while (run) {
				System.out.println("[1]���θ��");
				System.out.println("[2]��ٱ���");
				System.out.println("[0]�ڷΰ���");
				System.out.println();
				System.out.println("�޴� ����");
				menu = scan.nextInt();
				switch (menu) {
				case 1:
					im.printCategory();
					System.out.println("���θ�� ���� [�ڷΰ���: -1] :");
					menu = scan.nextInt();
					for (int i = 0; i < im.category.size(); i++) {
						if (menu == i) {
							im.printItemList(menu);
							System.out.println("�׸��� ���� : ");
							menu = scan.nextInt();
							im.addBasket(menu);
							menu = -1;
						}
					}
					break;
				case 2:
					im.printBasket();
					break;
				case 0:
					run = false;
					break;
				}
			}
		}
	}

	public void login() {
		if (log != -1) {
			System.out.println("�̹� �α��ε� �����Դϴ�.");
		}
		else {
			System.out.print("ID�Է�: ");
			String inputId = scan.next();
			System.out.print("PW�Է�: ");
			String inputPw = scan.next();
			for (int i = 0; i < id.length; i++) {
				if (id[i].equals(inputId) && pw[i].equals(inputPw))
					log = i;
			}
			if (log == -1)
				System.out.println("���̵�� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
			else
				im.fillBasket(log);
				System.out.println("[" + id[log] + "]��, ȯ���մϴ�.");
		}

	}

	public void logout() {
		if (log == -1) {
			System.out.println("�α׾ƿ� �� �̿����ֽʽÿ�.");
		}
		else {
			im.saveUserBasket(log);
			im.clearBasket();
			log = -1;
			System.out.println("�ȳ����輼��.");
		}
	}

}
