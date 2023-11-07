package array;
import java.util.*;
public abstract class MovieArray_new {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/*
		[�Ű��ڽ� ��ȭ����]
		1. ����ڷκ��� �¼���ȣ(index)�� �Է¹޾� �����Ѵ�.
		2. �����ο��� 1~8 ������ �ο��� �Է¹޾� �����Ѵ�.
		      ��, 1~8 ������ �ο��� �ƴϸ� ����ó�� �Ѵ�.
		      ex) �ο��� Ȯ���ϼ���.
		3. �̹� ���Ű� �Ϸ�� �¼��� �籸���� �� ����.
		4. �� �¼��� ���Ű��� 12,000��
		5. ���α׷� ���� �� �ش� ��ȭ �� ����� ���
		6. �����ο��� 1���� ��� 
		      ¦�� �¼��� ���źҰ� [!]
		7. �̹� ���Ű� �� �¼��� ��� [X]
		8. �� ���� �¼��� [ ]
		9. ������ �¼� [O]    
		10. �����ο��� 2�� �̻��� ���
		 */

		int[] seat = new int[10];
		int cnt = 0;
		int seatcnt = 0 ; //�¼���[o]�� �ο�����
		boolean run = true;
		while(run) {

			System.out.println(); 
			System.out.println("=�ް� ��ȭ��=");
			System.out.println("1.�¼�����");
			System.out.println("2.����");
			System.out.println("3.���");
			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.print("���� �ο��� �Է��ϼ���[1~8] :");
				int inwon = scan.nextInt();

				if(inwon>=1 && inwon<=8) {		
					//	------------- �����ο��� 1���϶� ¦�� �¼��� !�� ����ϴ� �ڵ� --------------------------------				
					if(inwon ==1) {
						for(int i=0; i<10; i++) {
							if(i % 2 != 0) {
								seat[i] = 3;
							}
						}
						for(int i=0; i<10; i++) {
							if(seat[i] == 0) {
								System.out.print("[ ]"); //���Ű���
							}else if(seat[i]==2) {     // ���ſϷ�
								System.out.print("[X]");
							}else if(seat[i]==3) {
								System.out.print("[!]");  //���źҰ���
							}else {
								System.out.print("[O]"); // ���ż���
							}
						}
						System.out.println();

						//	-------------- ¦�� �ڸ� ���ý� ���źҰ��� Ȧ�� �ڸ� ���ý� ���ſϷ� �ڵ�---------------
						System.out.print("�¼���ȣ ����[1~10] : ");
						int idx = scan.nextInt();
						idx -= 1;     // index��ȣ�� 0���� �����ϱ� ������   
						if(idx % 2 != 0 ) {
							System.out.println("���źҰ���");
						}else {
							seat[idx] = 1;
							System.out.println("���ſϷ�");
							cnt += 1;
						}
						for(int i=0; i<10; i++) {
							if(seat[i] == 0) {
								System.out.print("[ ]"); //���Ű���
							}else if(seat[i]==2) {     // ���ſϷ�
								System.out.print("[X]");
							}else if(seat[i]==3) {
								System.out.print("[!]");  //���źҰ���
							}else {
								System.out.print("[O]"); // ���ż���
							}
						}
					}
					// -----------------------------------------------------------------------------------------
					if(inwon>=2 && inwon<=8) {  // 2���̻� 8���� �������� ���
						for(int i=0; i<10; i++) {
							if(seat[i] == 0) {
								System.out.print("[ ]"); //���Ű���
							}else if(seat[i]==2) {     // ���ſϷ�
								System.out.print("[X]");
							}else if(seat[i]==3) {
								System.out.print("[!]");  //���źҰ���
							}else {
								System.out.print("[O]"); // ���ż���
							}
						}
						System.out.println();
						System.out.println();
						if(inwon % 2 == 0) { // �ο����� ¦�� Ȧ���϶� �����ϴ� �¼����� �޶����⶧��
							for(int k=0;k<(inwon/2);k++) {
								if(seat[k] == 1) {
									seatcnt = seatcnt + 2;
								}
								if(inwon != seatcnt) {
									System.out.print("�����¼�: ");
									int idx1 = scan.nextInt();
									idx1 -= 1;     // index��ȣ�� 0���� �����ϱ� ������
									seat[idx1+1] = 1; 
									seat[idx1] = 1;
									cnt += 2;
									
									for(int i=0; i<10; i++) {
										if(seat[i] == 0) {
											System.out.print("[ ]"); //���Ű���
										}else if(seat[i]==2) {     // ���ſϷ�
											System.out.print("[X]");
										}else if(seat[i]==3) {
											System.out.print("[!]");  //���źҰ���
										}else {
											System.out.print("[O]"); // ���ż���
										}
									}
									System.out.println();
								}
							}
							
						}else {
							for(int k=0;k<(inwon/2)+1;k++) {
								if(seat[k] == 1) {
									seatcnt = seatcnt + 2;
								}
								System.out.println("�¼������ο� :"+seatcnt);
								if(inwon != seatcnt) {
									System.out.print("�����¼�: ");
									int idx1 = scan.nextInt();
									idx1 -= 1;     // index��ȣ�� 0���� �����ϱ� ������
									
									if(seatcnt == inwon-1) {
										seat[idx1] = 1;
										cnt += 1;
									}else {
										seat[idx1+1] = 1; 
										seat[idx1] = 1;
										cnt += 2;
									}
									
									
									for(int i=0; i<10; i++) {
										if(seat[i] == 0) {
											System.out.print("[ ]"); //���Ű���
										}else if(seat[i]==2) {     // ���ſϷ�
											System.out.print("[X]");
										}else if(seat[i]==3) {
											System.out.print("[!]");  //���źҰ���
										}else {
											System.out.print("[O]"); // ���ż���
										}
									}
									System.out.println();
								}
							}
						}
						
						

						/*		if(idx1==9) { //�¼�10�� ���� �Ұ�. 						
							System.out.println("���źҰ����� �¼�");
						} else {
//	------------------- Ȧ���¼� ���� �ڵ� ------------------------------------------------						
							if(idx1 % 2 != 0) { 
								if(seat[idx1+1]==2 || seat[idx1]==2) { 
									System.out.println("���źҰ����� �¼�");
									continue;
								}
//	------------ ������ �¼��� ���� �¼� ���� �Ϸ� �ڵ� -------------------------------							
								seat[idx1+1] = 1; 
								seat[idx1] = 1; 
								System.out.println("���ſϷ�");
								cnt= cnt+2;
								seatcnt = seatcnt +2;
// -----------------------¦�� �¼� ���� �ڵ� --------------------------------------------								
							} else if(idx1 % 2 ==0) { //������ �¼� ¦��
								if(seat[idx1+1]==2 || seat[idx1]==2) {
									System.out.println("���źҰ���");
									continue;
								}
								seat[idx1+1] = 1; 
								seat[idx1] = 1; 
								//System.out.println("���ſϷ�");
								//cnt= cnt+2;

							}
						}*/
					}	
						
						// ---------------------------- ����  [!]�� �ڸ��� [ ], [O]���ŵ� �ڸ��� [X]�� -----------------  
						for(int i=0; i<seat.length; i++) {
							if(seat[i]==3) { 
								seat[i]=0; 
							} else if(seat[i]==1) { 
								seat[i]=2; 
							}
						}	 

						// -------------------- �����ο��� 1~8 ���̰� �ƴѰ�� ����ó�� �ڵ� ----------------------
					}else {
						System.out.println("�����ο��� Ȯ���ϼ���~");
					}
					//-------------------- ���α׷� ���� �� ����� ��� �ڵ� ----------------------------------------
				}
				else if(sel == 2) {
					int total = cnt * 12000;
					System.out.println("����� : " +total + "��");
					run = false;
					//------------------- �����¼� ��� �ڵ� -------------------------------				
				}else if(sel == 3) {
					System.out.print("����� �¼����� :");
					int index1 = scan.nextInt();
					index1 -= 1;
					seat[index1] = 0;
					if(seat[index1+1] == 0) {
						seat[index1-1] = 0; 
					}
					seat[index1+1] = 0; 
					cnt -= 2;

					for(int i=0; i<10; i++) {

						if(seat[i] == 0) {
							System.out.print("[ ]"); //���Ű���
						}else if(seat[i]==2) {     // ���ſϷ�
							System.out.print("[X]");
						}else if(seat[i]==3) {
							System.out.print("[!]");  //���źҰ���
						}else {
							System.out.print("[O]"); // ���ż���
						}
					}
					System.out.println();
					System.out.println("������ҿϷ�");
				}
			}
			//-----------------------------------------------------------------------------------------------
			scan.close();

		}
	}
