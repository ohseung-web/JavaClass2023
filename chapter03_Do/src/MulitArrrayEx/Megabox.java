package MulitArrrayEx;

import java.util.Scanner;

public class Megabox {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[][] seat = new int[9][8];
		boolean run = true;
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		int chekAlph = -1;
		int chekAlph2 = -1;
		int total = 0;
		int inwon =0;
		int cnt = 0;
		int chekSeat = -1;
		int chekindex1 = -1;
		int chekindex2= -1;
		
		while(run) {

			// screen ȭ�鱸��
			System.out.println("---------- SCREEN -----------");
			for(int i=0; i<seat.length; i++) {
				System.out.print(alphabet[i]+" ");
				for(int j=0; j<seat[i].length; j++) {
					if(seat[i][j]==1) {
						System.out.print("[��]");    	
					}else if(seat[i][j]==2) {
						System.out.print("[X]");
					}else if(seat[i][j]==3) {
						System.out.print("[��]");
						seat[i][j] = 0; //�ʱ�ȭ
					}else {
						System.out.print("[  ]");
					}
				}
				System.out.println();
			}
			System.out.println("--------------------------------");
            System.out.println("�� : ���� ,  X : ���ſϷ�, �� : ���úҰ�  ");
			System.out.println("= Mega Movie =");
			System.out.println("[1]�¼�����");
			System.out.println("[2]�������");
			System.out.println("[0]����");
			System.out.print("�޴����� :");
			int select = scan.nextInt();
			System.out.println();

			switch(select) {
			case 1:  // �¼�����
				
				System.out.print("�ο� ����(1~8)(0.����) ");
				inwon = scan.nextInt();
				if(inwon == 0) {
					continue;
				}
				if( inwon >= 1 && inwon <= 8) {
					System.out.print("�����¼�1(A~I) :");
					String seatName = scan.next();

					// �¼� A~I ���� üũ
					for(int i=0; i<alphabet.length; i++) { 
						if(alphabet[i].equals(seatName)) {
							chekAlph = i;
						}
					}
					System.out.print("�����¼�2(1~8) :");
					int seatNum2 = scan.nextInt();


					if(chekAlph == -1) {
						System.out.println("���� ���� �ʴ� �¼��Դϴ�.");
					}else {
						if( seatNum2 >=1 && seatNum2 <=8) {
							if(inwon == 1) { // �����ο� 1���� ���
								// ¦���¼� ���� ���ϰ� �ϱ� -------------------------------------------------------
								for(int i=0; i<seat.length; i++) { 
									for(int j=0; j<seat[i].length; j++) { 
										if((j+1)%2==0 && seat[i][j]!=2 && seat[i][j]!=1) {
											// ������ �¼��� : ¦���¼� / ���� �Ϸ� / ������ �϶�
											seat[i][j]=3; // ¦���¼� ���źҰ��� ���! 
											//	�տ� ������ �¼��� ¦���¼��� ���޾� ������ �� ¦���¼��� ���� �����ϰ� �ϴ� �ڵ�
											if( j != seat[0].length-1) {
												if(seat[i][j-1]==1 || seat[i][j+1]==1) {
													seat[i][j]=0;
												}
											} else {
												if(seat[i][j-1]==1) {
													seat[i][j]=0;
												}
											}
										}
									}
								}
								if(seatNum2 % 2 == 0) {
									System.out.println("���� �Ұ����� �¼�");
								}else {
									seat[chekAlph][seatNum2-1] = 1;
									cnt ++;
								}
								//-----------------------------------------------------------------------------------------------------
							}else if(inwon == 2) {
								for(int i=0; i<seat.length-1; i++) {
									if( seat[chekAlph][i] == 1 || seat[chekAlph][i] == 3) {
										chekSeat = i;
									}
								}
								if(chekSeat != -1) {
									System.out.println("���� �Ұ����� �¼�");
								}
								else {
									seat[chekAlph][seatNum2-1] = 1;
									seat[chekAlph][seatNum2] = 1;
									cnt += inwon;
								}
                       //-----------------------------------------------------------------------------------------
							}else if(inwon == 3) {
								for(int i=0; i<seat.length-1; i++) {
									if( seat[chekAlph][i] == 1 || seat[chekAlph][i] == 3) {
										chekSeat = i;
									}
								}
								if(chekSeat != -1) {
									System.out.println("���� �Ұ����� �¼�");
								}
								else {
									seat[chekAlph][seatNum2-1] = 1;
									seat[chekAlph][seatNum2] = 1;
									cnt += inwon;
								}
							}
						}
					}
				}else {
					System.out.println("���� �� �� ���� �ο��Դϴ�.");
				}
				break;
				
			case 2: // �¼����� ���
				System.out.println("����� �¼� ��ȣ�� �Է��� �ּ��� ");
				System.out.print("�����¼�1(A~I) :");
				String cancelName = scan.next();
				
				// �¼� A~I ���� üũ
				for(int i=0; i<alphabet.length; i++) { 
					if(alphabet[i].equals(cancelName)) {
						chekAlph2= i;
					}
				}
				System.out.print("�����¼�2(1~8) :");
				int cancelNum = scan.nextInt();
				
				if( seat[chekAlph2][cancelNum-1] == 0) {
					System.out.println("��� �� �� ���� �¼��Դϴ�.");
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+1] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+2] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					seat[chekAlph2][cancelNum+2] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+3] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					seat[chekAlph2][cancelNum+2] = 0;
					seat[chekAlph2][cancelNum+3] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+4] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					seat[chekAlph2][cancelNum+2] = 0;
					seat[chekAlph2][cancelNum+3] = 0;
					seat[chekAlph2][cancelNum+4] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+5] == 1 ){
						seat[chekAlph2][cancelNum-1] = 0;
						seat[chekAlph2][cancelNum] = 0;
						seat[chekAlph2][cancelNum+1] = 0;
						seat[chekAlph2][cancelNum+2] = 0;
						seat[chekAlph2][cancelNum+3] = 0;
						seat[chekAlph2][cancelNum+4] = 0;
						seat[chekAlph2][cancelNum+5] = 0;
						cnt = cnt - inwon;
					}else {
					seat[chekAlph2][cancelNum-1] = 0;
					cnt --;
				}
				break;
				
			case 0: // ���� �� ��ȭ�� ���
				total += (cnt * 12000);
				System.out.print("�� ����� :");
				System.out.println(total);
				run = false;

			}
		}
		
//-----------------------------------------------------------------------------------------------------------------------		
	}
}
