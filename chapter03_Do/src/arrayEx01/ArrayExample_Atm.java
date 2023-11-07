package arrayEx01;
import java.util.*;
public class ArrayExample_Atm {

	public static void main(String[] args) {
		/*
		 * # ATM[3�ܰ�]
		 * 1. ����
		 * . ���¹�ȣ�� ��й�ȣ�� �Է¹޾� ����
		 * . ���¹�ȣ �ߺ��˻�
		 * 2. Ż��
		 * . ���¹�ȣ�� �Է¹޾� Ż��
		 */
	
       Scanner scan = new Scanner(System.in);
		
		int[] accs = {1001, 1002, 0, 0, 0};
		int[] pws  = {1111, 2222, 0, 0, 0};
		
		int cnt = 2;
		
		boolean run = true;
		while(run) {
			
			for(int i=0; i<cnt; i++) {
				System.out.println((i+1) + "." + accs[i] + ":" + pws[i]);
			}
			System.out.println();
			
			System.out.println("1.����");
			System.out.println("2.Ż��");
			
			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				if(cnt == 5) {
					System.out.println("���̻� ������ �� �����ϴ�.");
					continue;
				}
				
				System.out.print("[����]���¹�ȣ �Է� : ");
				int myAcc = scan.nextInt();
				
				int check = 1; // �ߺ����¹�ȣ üũŰ
				for(int i=0; i<cnt; i++) {
					if(accs[i] == myAcc) {
						check = -1; // �ߺ��Ǿ��� ��
					}
				}
				
				if(check == -1) {
					System.out.println("���¹�ȣ�� �ߺ��˴ϴ�.");
				}else {
					System.out.print("[����]��й�ȣ �Է� : ");
					int myPw = scan.nextInt();
					
					accs[cnt] = myAcc;
					pws[cnt] = myPw;
					cnt += 1;
				}
			}
			else if(sel == 2) {
				
				System.out.print("[Ż��]���¹�ȣ �Է� : ");
				int myAcc = scan.nextInt();
				
				int check = -1;// �ش���¹�ȣ �������� üũŰ;
				for(int i=0; i<cnt; i++) {
					if(accs[i] == myAcc) {
						check = i;
					}
				}
				
				if(check == -1) {
					System.out.println("�ش���¹�ȣ�� �������� �ʽ��ϴ�.");
				}else {
					for(int i=check; i<cnt-1; i++) {
						accs[i] = accs[i + 1];
						pws[i] = pws[i + 1];
					}
					cnt -= 1;
				}
				
			}
			
		}
		scan.close();
	}

}
