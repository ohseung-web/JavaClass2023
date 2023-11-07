package megabox;

import java.util.Scanner;

public class Megabox extends MegaboxElements{
	Scanner scan = new Scanner(System.in);
	
	public void run() {
		while(run) {
			System.out.println("=�ް� ��ȭ��=");
			System.out.println("1.�¼�����");
			System.out.println("2.�������");
			System.out.println("3.����");
			System.out.print("�޴� ���� : ");
			int menu = scan.nextInt();
			if(menu==1) {
				reserveSeat();
			}
			else if(menu==2) {
				cancelSeat();
			}
			else if(menu==3) {
				end();
			}
			else {
				System.out.println("��ȿ���� ���� �޴��Դϴ�.");
			}
		}
	}
	
	public void reserveSeat() {
		convertReservedSeats();
		printScreen();
		System.out.print("�ο� ����(1~8)(0.����): ");
		personnel = scan.nextInt();
		if(personnel>0 && personnel<9) {
			if(personnel==1) { // 1���� ��
				oneBook();
			}
			else if(personnel % 2 == 1) { // Ȧ���� �� (1���� ��� ����)
				oddBook();
			}
			else { // ¦���� ��
				evenBook();
			}
			System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
			System.out.println();
		}
	}
	
	public void oneBook() {
		while(personnel!=0) {
			oneSetSeat();	
		}
	}
	
	public void oddBook() {
		while(personnel!=0) {
			if(personnel == 1) {
				oneSetSeat();
			}
			else {
				twoSetSeat();
			}	
		}
	}
	
	public void evenBook() {
		while(personnel!=0) {
			twoSetSeat();
		}
	}
	
	public void cancelSeat() {
		cancelReservedSeats();
		printScreen();
		System.out.println();
	}
	
	public void end() {
		System.out.println("�� ����� = "+revenue);
		run = false;
	}
	
	public void inputSeat() { // ������ �¼� �Է�
		System.out.print("�����¼�1(A~I): ");
		reserveRow = scan.next();
		for(int i=0;i<row;i++) {
			if(rowAlphabet[i].equals(reserveRow)) {
				reserveSeat1 = i;
			}
		}
		System.out.print("�����¼�2(1~8): ");
		reserveSeat2 = scan.nextInt()-1;
	}
	
	public void oneSetSeat() { // �� ���� ���� �¼� �����ϱ�
		disableEvenColumns();
		printScreen();
		inputSeat();
		if(screen[reserveSeat1][reserveSeat2] == 0) {
			screen[reserveSeat1][reserveSeat2] = 1;
			personnel -= 1;
			revenue += 12000;
		}
		else if(screen[reserveSeat1][reserveSeat2] == 1) {
			screen[reserveSeat1][reserveSeat2] = 0;
			if(reserveSeat2 % 2 == 0) {
				screen[reserveSeat1][reserveSeat2+1] = 0;
			}
			else {
				screen[reserveSeat1][reserveSeat2-1] = 0;
			}
			personnel += 2;
			revenue -= 24000;
		}
		else if(screen[reserveSeat1][reserveSeat2] == 2) {
			System.out.println("���� �Ұ����� �ڸ��Դϴ�.");
		}
		else {
			System.out.println("�̹� ���ŵ� �ڸ��Դϴ�.");
		}
		initializeDisabledColumns();
	}
	
	public void twoSetSeat() { // �� ���� ���� �¼� �����ϱ�
		printScreen();
		inputSeat();
		if(screen[reserveSeat1][reserveSeat2] == 0) {
			screen[reserveSeat1][reserveSeat2] = 1;
			if(reserveSeat2 % 2 == 0) {
				screen[reserveSeat1][reserveSeat2+1] = 1;
			}
			else {
				screen[reserveSeat1][reserveSeat2-1] = 1;
			}
			personnel -= 2;
			revenue += 24000;
		}
		else if(screen[reserveSeat1][reserveSeat2] == 1) {
			screen[reserveSeat1][reserveSeat2] = 0;
			if(reserveSeat2 % 2 == 0) {
				screen[reserveSeat1][reserveSeat2+1] = 0;
			}
			else {
				screen[reserveSeat1][reserveSeat2-1] = 0;
			}
			personnel += 2;
			revenue -= 24000;
		}
		else {
			System.out.println("�̹� ���ŵ� �ڸ��Դϴ�.");
		}
	}
}
