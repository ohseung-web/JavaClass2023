package Omok_Ver2;
import java.util.*;
public class Game {
	Scanner scan = new Scanner(System.in);
	GameElements ge = new GameElements();
	boolean run = true;
	int menu = -1;
	
	public void menu() {
		while(run) {
			System.out.println("[����]");
			System.out.println("[1]���� ����");
			System.out.println("[2]���� Ȯ��");
			System.out.println("[0]����");
			System.out.print("�޴�����: ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				playGame();
				run = true;
				break;
			case 2:
				showGameRecord();
				break;
			case 0:
				run = false;
				System.out.println("���� ����");
				break;
			}
		}
	}
	
	public void playGame() {
		System.out.println("���� ���� ���� (�÷��̾�1 : �浹, �÷��̾�2 : �鵹)");
		ge.setCheckerboard();
		ge.printCheckerboard();
		while(run) {
			System.out.println("�÷��̾�1 ���� - ���� ��ġ�� ����");
			while(true) {
				System.out.print("����(1~13) : ");
				int row = scan.nextInt();
				System.out.print("����(1~13) : ");
				int column = scan.nextInt();
				if(ge.checkerboard[row-1][column-1].equals("��") || ge.checkerboard[row-1][column-1].equals("��")) {
					System.out.println("�̹� ���� ������ �ڸ��Դϴ�.");
				}
				else {
					ge.playerPlaceStone(row, column);
					ge.printCheckerboard();
					if(ge.fiveRowCheck()) {
						System.out.println("���� �� : �÷��̾� 1 �¸�");
						ge.playerWin++;
						ge.cpuLose++;
						run = false;
					}
					break;
				}
			}
			
			if(ge.fiveRowCheck()==false) {
				System.out.println("��ǻ�� ����");
				ge.cpuPlaceStone();
				if(ge.fiveRowCheck()==true) {
					run = false;
				}
			}
		}
	}
	
	public void showGameRecord() {
		System.out.println("�÷��̾� : "+ge.playerWin+"�� "+ge.playerLose+"��");
		System.out.println("��ǻ�� : "+ge.cpuWin+"�� "+ge.cpuLose+"��");
	}
}
