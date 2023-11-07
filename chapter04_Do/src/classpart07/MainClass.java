package classpart07;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ClassEx07 e = new ClassEx07();
		e.name = "Mega Bank";

		while(true) {
			System.out.println("-------------------------");
			System.out.println("���¹�ȣ\t��й�ȣ\t�����ܾ�");
			System.out.println("-------------------------");
			for(int i=0; i<e.count; i++) {
				System.out.println(e.arAcc[i] + "\t" + e.arPw[i] + "\t" + e.arMoney[i]);
			}
			System.out.println("-------------------------");
			System.out.print("���� : ");
			//----------  ����Ȯ��
			
			if(e.loginCheck == -1) {
				System.out.println("�α׾ƿ�");
			}else {
				System.out.println(e.arAcc[e.loginCheck] + " �α���");
			}
			System.out.println("-------------------------");

			System.out.println("[" + e.name + "]");
			System.out.println("[1]ȸ������");
			System.out.println("[2]ȸ��Ż��");
			System.out.println("[3]�α���");
			System.out.println("[4]�α׾ƿ�");
			System.out.println("[5]�Ա��ϱ�");
			System.out.println("[6]��ü�ϱ�");
			System.out.println("[7]�ܾ���ȸ");
			System.out.println("[0]�����ϱ�");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.print("[����]���¹�ȣ�� �Է��ϼ��� : ");
				String acc = scan.next();

				int check = 1;
				for(int i=0; i<e.arAcc.length; i++) {
					if(e.arAcc[i].equals(acc)) {
						check = -1;
					}
				}

				if(check == -1) {
					System.out.println("[�޼���]�ߺ��Ǵ� ���¹�ȣ �Դϴ�.");
				}else {
					System.out.print("[����]��й�ȣ�� �Է��ϼ��� : ");
					String pw = scan.next();

					System.out.print("[����]�ݾ��� �Է��ϼ��� : ");
					int money = scan.nextInt();

					e.arAcc[e.count] = acc;
					e.arPw[e.count] = pw;
					e.arMoney[e.count] = money+1000;
					e.count += 1; // �߰��� index ��ȣ�� 4�� ��� 5�� �Ǿ�� ���¸� ����ϴ� ȭ�鿡 ����� �Ǳ⶧��
                   System.out.println("���簳��:"+e.count);
					System.out.println("[�޼���]������ �����մϴ�.");
				}
			}
			else if(sel == 2) {
				if(e.loginCheck == -1) {
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					continue;
				}

				for(int i=e.loginCheck; i<e.count - 1; i++) {
					e.arAcc[i] = e.arAcc[i + 1];
					e.arPw[i] = e.arPw[i + 1];
					e.arMoney[i] = e.arMoney[i + 1];
				}

				e.count -= 1;
				e.loginCheck = -1;
				System.out.println("[�޼���]Ż��Ǿ����ϴ�. �ȳ������ʽÿ�.");
			}
			else if(sel == 3) {
				if(e.loginCheck != -1) {
					System.out.println("[�޼���]���� " + e.arAcc[e.loginCheck] + "��, �α��� ��...");
					continue;
				}
				System.out.print("[�α���]���¹�ȣ�� �Է��ϼ��� : ");
				String acc = scan.next();

				System.out.print("[�α���]��й�ȣ�� �Է��ϼ��� : ");
				String pw = scan.next();

				for(int i=0; i<e.count; i++) {
					if(e.arAcc[i].equals(acc) && e.arPw[i].equals(pw)) {
						e.loginCheck = i;
					}
				}

				if(e.loginCheck == -1) {
					System.out.println("[�޼���]���¹�ȣ�� ��й�ȣ�� Ȯ�����ּ���.");
				}else {
					System.out.println("[�޼���]" + e.arAcc[e.loginCheck] + "��, ȯ���մϴ�.");
				}
			}
			else if(sel == 4) {
				if(e.loginCheck == -1) {
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					continue;					
				}

				e.loginCheck = -1;
				System.out.println("[�޼���]�α׾ƿ� �Ǿ����ϴ�.");
			}
			else if(sel == 5) {
				if(e.loginCheck == -1) {
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					continue;					
				}
				System.out.print("[�Ա�]�Ա��� �ݾ��� �Է��ϼ��� : ");
				int money = scan.nextInt();

				e.arMoney[e.loginCheck] += money;
				System.out.println("[�޼���]�Ա��� �Ϸ��Ͽ����ϴ�.");
			}
			else if(sel == 6) {
				if(e.loginCheck == -1) {
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					continue;					
				}

				System.out.print("[��ü]���¹�ȣ�� �Է��ϼ��� : ");
				String acc = scan.next();

				int check = -1;
				for(int i=0; i<e.count; i++) {
					if(e.arAcc[i].equals(acc)) {
						check = i;
					}
				}

				if(check == -1) {
					System.out.println("[�޼���]���¹�ȣ�� Ȯ�����ּ���.");
				}else {
					System.out.print("[��ü]�ݾ��� �Է��ϼ��� : ");
					int money = scan.nextInt();

					if(e.arMoney[e.loginCheck] >= money) {
						e.arMoney[e.loginCheck] -= money;
						e.arMoney[check] += money;
						System.out.println("[�޼���]��ü�� �Ϸ��Ͽ����ϴ�.");
					}else {
						System.out.println("[�޼���]�����ܾ��� �����մϴ�.");
					}
				}
			}
			else if(sel == 7) {
				if(e.loginCheck == -1) {
					System.out.println("[�޼���]�α��� �� �̿밡���մϴ�.");
					continue;					
				}		
				System.out.println(e.arAcc[e.loginCheck] + "���� �����ܾ��� " + e.arMoney[e.loginCheck] + "�� �Դϴ�.");
			}
			else if(sel == 0) {
				System.out.println("���α׷� ����");
				break;
			}

		}

		scan.close();

	}

}
