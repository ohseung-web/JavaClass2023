package Omok;
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
				if(ge.checkerboard[column-1][row-1].equals("��") || ge.checkerboard[column-1][row-1].equals("��")) {
					System.out.println("�̹� ���� ������ �ڸ��Դϴ�.");
				}
				else {
					ge.placeStone1(row, column);
					ge.printCheckerboard();
					if(ge.fiveRowCheck()) {
						System.out.println("���� �� : �÷��̾� 1 �¸�");
						ge.player1Win++;
						ge.player2Lose++;
						run = false;
					}
					break;
				}
			}
			
			if(ge.fiveRowCheck()==false) {
				while(true) {
					System.out.print("����(1~13) : ");
					int row = scan.nextInt();
					System.out.print("����(1~13) : ");
					int column = scan.nextInt();
					if(ge.checkerboard[column-1][row-1].equals("��") || ge.checkerboard[column-1][row-1].equals("��")) {
						System.out.println("�̹� ���� ������ �ڸ��Դϴ�.");
					}
					else {
						ge.placeStone2(row, column);
						ge.printCheckerboard();
						if(ge.fiveRowCheck()) {
							System.out.println("���� �� : �÷��̾� 2 �¸�");
							ge.player2Win++;
							ge.player1Lose++;
							run = false;
						}
						break;
					}
				}
			}
		}
	}
	
	public void showGameRecord() {
		System.out.println("�÷��̾� 1 : "+ge.player1Win+"�� "+ge.player1Lose+"��");
		System.out.println("�÷��̾� 2 : "+ge.player2Win+"�� "+ge.player2Lose+"��");
	}
}
