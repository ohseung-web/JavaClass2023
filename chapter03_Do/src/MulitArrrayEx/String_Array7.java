package MulitArrrayEx;
import java.util.*;
public class String_Array7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] ids = {"qwer", "javaking", "abcd","kjb1045"};
		String[] pws = {"1111",     "2222", "3333","1045"};

		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2]; // ��ü ��ٱ��� ���

		int count = 0; // �������� ��� ���� 
		String[] items = {"���", "�ٳ���", "����"};
		int[][] cartcount = new int[ids.length][items.length]; // ȸ���� ������ ���� ����

		int log = -1; // �α��� üũŰ

		// ��ü�޴� ���� -------------------------------------------------------------------------
		while(true) {

			System.out.println("------------");
			System.out.print("���� : ");
			if(log ==  -1) {
				System.out.println("�α׾ƿ�");
			}else {
				System.out.println(ids[log] + " �α���");
			}
			System.out.println("------------");

			System.out.println("[MEGA MART]");
			System.out.println("[1]�� �� ��");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]��     ��");
			System.out.println("[4]��ٱ���");
			System.out.println("[5]��ü���");
			System.out.println("[0]��     ��");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();
          // 1���޴� ���� �� ------------------------------------------------------------------------------------
			if(sel == 1) {
				System.out.print("ID�Է� : ");
				String myId = scan.next();
				System.out.print("Pw�Է� : ");
				String myPw = scan.next();
               
				for(int i=0; i<ids.length; i++) {
					if(myId.equals(ids[i]) && myPw.equals(pws[i])) {
						log = i;
					}
				}
				if(log == -1) {
					System.out.println("ID�� PW�� Ȯ�����ּ���.");
				}else {
					System.out.println(ids[log] + "��, ȯ���մϴ�.");
				}
				
			} // 2���޴� ���� �� ------------------------------------------------------------------------------------
			else if(sel == 2) {
				log = -1;
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
			}
			 // 3���޴� ���� �� ------------------------------------------------------------------------------------
			else if(sel == 3) {
				if(log == -1) {
					System.out.println("�α��� �� �̿밡���մϴ�.");
					continue;
				}
                // ���� ��� �޴� -------------------------------------------------------------------------------------
				while(true) {
					System.out.println("[��ǰ���]");
					for(int i=0; i<items.length; i++) {
						System.out.println("[" + (i+1) + "]" + items[i]);
					}
					System.out.println("[4]�ڷΰ���");

					System.out.print("��ǰ��ȣ�� �����ϼ��� : ");
					int choice = scan.nextInt();
					if(choice == 4) {
						break;
					}
					// id�� ������ itemt���� ������ item���� cartcount�� ��´�.
					jang[count][0] = log; // ��ٱ��� 0��° ���� log�� �� index ��ȣ�� ��´�.
					jang[count][1] = choice -1; // ��ٱ��� 1��° ���� ���� �� item index ��ȣ�� ��´�.
					cartcount[log][choice-1] ++; // id�� ������ itemt���� ������ item���� cartcount�� ��´�.
					count++;
				}
				
			}
			 // 4���޴� ���� �� ------------------------------------------------------------------------------------
				else if(sel == 4) {
                   // ����ٱ��� ��� �� �α��λ��¿����� ���� ��
					if( log == -1 ) {
						System.out.println("�α����� ���ּ���~");
					}else {
						System.out.println();
						System.out.println("---- �� ��ٱ��� ��� -----");
						for(int i=0; i<items.length; i++) {
							if(cartcount[log][i] != 0 ) { 
								System.out.println(items[i]+":"+cartcount[log][i] + "��");
							}
						}
					}
				}
			 // 0���޴� ���� �� ------------------------------------------------------------------------------------
				else if(sel == 0) {
					System.out.println("���α׷� ����");
					break;
				}
			 // 5���޴� ���� �� ------------------------------------------------------------------------------------
				else if(sel == 5) {
					// ��ü��ٱ��� ��� ��, �α׾ƿ� ���¿����� ���� ��
					if(log != -1) {
						System.out.println("�α׾ƿ� �� �̿��Ͽ� �ּ���");
						continue;
					}
					System.out.println();
					System.out.println("--- ��ü ��ٱ��� ��� ---");
					for(int i=0;i<count;i++) {
						System.out.println("|"+ids[jang[i][0]]+"|"+items[jang[i][1]]+"|");
					}
				}
			}
			scan.close();
		}

	}
