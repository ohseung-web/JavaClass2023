package muti_array;

import java.util.Scanner;

public class String_Example03_seungjun {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111", "2222", "3333"};
		String[] items = {"���", "�ٳ���", "����"};
		int MAX_SIZE = 100;
		int[][] jang = new int [MAX_SIZE][2];
		int menu;

		boolean run = true;
		String inputId; // �Է��� ID
		String inputPw; // �Է��� PW
		String currentStatus = new String("�α׾ƿ�"); // ���� ���� (�ʱⰪ: �α׾ƿ�)
		int log = -1; // �α��� ȸ���� �ε��� ��ȣ (-1�� ��� ���̵�/��й�ȣ ����ġ)
		int productNum; // ��ǰ��ȣ
		boolean run_product = true; // ������ �������� �� ��ǰ��ȣ �Է� �ݺ� key
		int cnt = 0; // ������ ��ٱ��� �迭�� ����
		int apple_1 = 0;
		int banana_1 = 0;
		int berry_1 = 0;
		int apple_2 = 0;
		int banana_2 = 0;
		int berry_2 = 0;
		int apple_3 = 0;
		int banana_3 = 0;
		int berry_3 = 0;

		while(run) {
			System.out.println("------------");
			System.out.println("���� : "+currentStatus);
			System.out.println("------------");
			System.out.println("[MEGA MART]");
			System.out.println("[1]�α���");
			System.out.println("[2]�α׾ƿ�");
			System.out.println("[3]����");
			System.out.println("[4]��ٱ���");
			System.out.println("[0]����");
			System.out.println("[5]��ü ���");
			System.out.print("�޴� ���� : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				if(currentStatus.equals("�α׾ƿ�")) {
					System.out.print("ID�Է� : ");
					inputId = scan.next();
					System.out.print("PW�Է� : ");
					inputPw = scan.next();
					for(int i=0;i<ids.length;i++) {
						if(ids[i].equals(inputId)&&pws[i].equals(inputPw)) {
							System.out.println(ids[i]+"��, ȯ���մϴ�.");
							currentStatus = ids[i]+" �α���";
							log = i;
							run_product = true;
						}
					}
					if(log==-1) {
						System.out.println("ID�� PW�� Ȯ�����ּ���.");
					}
				}
				else {
					System.out.println("�̹� �α��� �� �����Դϴ�.");
				}	
				break;
			case 2:
				if(currentStatus.equals("�α׾ƿ�")) {
					System.out.println("�α��� �� �̿� �����մϴ�.");
				}
				else {
					System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
					currentStatus = "�α׾ƿ�";
					log = -1;
				}
				break;
			case 3:
				if(currentStatus.equals("�α׾ƿ�")) {
					System.out.println("�α��� �� �̿� �����մϴ�.");
				}
				else {
					while(run_product) {
						System.out.println("[��ǰ���]");
						System.out.println("[1]���");
						System.out.println("[2]�ٳ���");
						System.out.println("[3]����");
						System.out.println("[4]�ڷΰ���");
						System.out.println("��ǰ��ȣ�� �����ϼ��� : ");
						productNum = scan.nextInt();
						switch(productNum) {
						case 1:
							if(cnt>=MAX_SIZE) {
								System.out.println("�� �̻� �߰��� �� �����ϴ�.");
								continue; // skip �ؼ� while������ �ٽ� ��
							}
							else {
								jang[cnt][0] = log;
								jang[cnt][1] = 0;
								cnt++;
							}
							break;
						case 2:
							if(cnt>=MAX_SIZE) {
								System.out.println("�� �̻� �߰��� �� �����ϴ�.");
								continue; // skip �ؼ� while������ �ٽ� ��
							}
							else {
								jang[cnt][0] = log;
								jang[cnt][1] = 1;
								cnt++;
							}
							break;
						case 3:
							if(cnt>=MAX_SIZE) {
								System.out.println("�� �̻� �߰��� �� �����ϴ�.");
								continue; // skip �ؼ� while������ �ٽ� ��
							}
							else {
								jang[cnt][0] = log;
								jang[cnt][1] = 2;
								cnt++;
							}
							break;
						case 4:
							run_product = false;
							break;
						}
					}
				}
				break;
			case 4:
				if(currentStatus.equals("�α׾ƿ�")) {
					System.out.println("�α��� �� �̿� �����մϴ�.");
				}
				else {
					/*for(int i=0;i<cnt;i++) {
						if(jang[i][0]==log&&jang[i][1]==0) {
							apple++;
						}
						else if(jang[i][0]==log&&jang[i][1]==1) {
							banana++;
						}
						else if(jang[i][0]==log&&jang[i][1]==2) {
							berry++;
						}
					}
					System.out.println("��� : "+apple+"��");
					System.out.println("�ٳ��� : "+banana+"��");
					System.out.println("���� : "+berry+"��");*/
					if(log==0) {
						for(int i=0;i<cnt;i++) {
							if(jang[i][1]==0) {
								apple_1++;
							}
							else if(jang[i][1]==1) {
								banana_1++;
							}
							else if(jang[i][1]==2) {
								berry_1++;
							}
						}
						System.out.println("��� : "+apple_1+"��");
						System.out.println("�ٳ��� : "+banana_1+"��");
						System.out.println("���� : "+berry_1+"��");
					}
					else if(log==1) {
						for(int i=0;i<cnt;i++) {
							if(jang[i][1]==0) {
								apple_2++;
							}
							else if(jang[i][1]==1) {
								banana_2++;
							}
							else if(jang[i][1]==2) {
								berry_2++;
							}
						}
						System.out.println("��� : "+apple_2+"��");
						System.out.println("�ٳ��� : "+banana_2+"��");
						System.out.println("���� : "+berry_2+"��");
					}
					else if(log==2) {
						for(int i=0;i<cnt;i++) {
							if(jang[i][1]==0) {
								apple_3++;
							}
							else if(jang[i][1]==1) {
								banana_3++;
							}
							else if(jang[i][1]==2) {
								berry_3++;
							}
						}
						System.out.println("��� : "+apple_3+"��");
						System.out.println("�ٳ��� : "+banana_3+"��");
						System.out.println("���� : "+berry_3+"��");
					}
				}
				break;
			case 0:
				System.out.println("���α׷� ����");
				run = false;
				break;
			case 5:
				for(int i=0;i<cnt;i++) {
					
						System.out.print(jang[i][0]+" ");
						System.out.println(jang[i][1]);
				}
				break;
			}
		}
		scan.close();
	}
}

