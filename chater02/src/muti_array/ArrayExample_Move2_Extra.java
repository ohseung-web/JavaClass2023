package muti_array;

import java.util.Scanner;

public class ArrayExample_Move2_Extra {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7];
		int menu; 
		int ppl; // ���� �ο�
		int index; // �¼� ��ȣ
		int total = 0; // �� �����
		for(int i=0;i<7;i++) {
			seat[i] = 0; // �¼�
		}
		boolean run = true; // �ݺ��� �⺻��
		while(run) {
			/*for(int i=0;i<7;i++) {
				if(seat[i]==0) {
					System.out.print("[ ]");
				}
				if(seat[i]==1) {
					System.out.print("[O]");
				}
				if(seat[i]==2) {
					System.out.print("[X]");
				}
			}*/
			System.out.println();
			for(int j=0;j<3;j++) {
				if(seat[2*j+1] == 2) {
					seat[2*j+1] = 0; // ���� �Ұ��� �¼� ǥ�� ����
				}
			}
			System.out.println("=�ް� ��ȭ��=");
			System.out.println("1.�¼�����");
			System.out.println("2.�������");
			System.out.println("3.����");
			System.out.print("�޴� ���� : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: // �¼�����
				// Ȧ�� �ο��� �Է��ϸ� 2��, 2�� ... 1��
				// 2���� ��� ¦�� �ڸ��� �Է��ϸ� Ȧ���� �ڵ����� ä����. �ݴ� ��쵵 �������� (+24000)
				// 1���� ��� ¦�� �ڸ��� �Է��ϸ� Ȧ�� �ڸ��� �Է��� ������ �ݺ��ؼ� �Է��϶�� ���� (+12000)
				// ¦�� �ο��� �Է��ϸ� 2��, 2�� ... 2�� 
				// �̹� ä���� �ڸ��� �ߺ��ؼ� �ڸ��� ä������ ���� ���� �ڵ��� ���� �� �̷����
				System.out.print("���� �ο��� �Է��ϼ���[1~7] : ");
				ppl = scan.nextInt();
				for(int i=0;i<7;i++) {
					if(seat[i]==0) {
						System.out.print("[ ]");
					}
					if(seat[i]==1) {
						System.out.print("[O]");
					}
					if(seat[i]==2) {
						System.out.print("[X]");
					}
				}
				System.out.println();
				// ���� �ο��� 1���� ���
				if(ppl==1) { 
					System.out.print("�¼���ȣ ����[1~7] : ");
					index = scan.nextInt();
					// �¼���ȣ�� ¦���� ���
					if(index % 2 == 0) { // ¦���� ���� �Ұ���
						System.out.println("���� �Ұ��� (¦�� ��ȣ�� �¼����� ���Ű� �Ұ����մϴ�.)");
						for(int j=0;j<3;j++) {
							if(seat[2*j+1] != 1) {
								seat[2*j+1] = 2; // ���� �Ұ��� �¼� ǥ��
							}	
						}
					}
					// �¼���ȣ�� ¦���� �ƴ� ���(Ȧ���� ���)
					else {
						if(seat[index-1]==1) { // ���Ű� �Ϸ�� �ڸ��� ���
							System.out.println("�̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.");
						}
						else { // ���� ����
							seat[index-1] = 1;
							total += 12000;
						}
					}
				}
				// ���� �ο��� 2�� �̻��� ���
				if(ppl>1) { 
					// ���� �ο��� ¦���� ���
					if(ppl%2==0) {
						for(int i=0;i<ppl/2;i++) {
							System.out.print("�¼���ȣ ����: ");
							index = scan.nextInt();
							// �¼���ȣ�� ¦���� ���
							if(index%2==0) {
								seat[index-1] = 1;
								seat[index-2] = 1;
								total += 24000;
								//System.out.println("¦���ڸ�");
								for(int j=0;j<7;j++) {
									if(seat[j]==0) {
										System.out.print("[ ]");
									}
									if(seat[j]==1) {
										System.out.print("[O]");
									}
									if(seat[j]==2) {
										System.out.print("[X]");
									}
								}
								System.out.println();
							}
							// �¼���ȣ�� Ȧ���� ���
							else {
								System.out.println("Ȧ���ڸ�");
								seat[index-1] = 1;
								seat[index] = 1;
								total += 24000;
								for(int j=0;j<7;j++) {
									if(seat[j]==0) {
										System.out.print("[ ]");
									}
									if(seat[j]==1) {
										System.out.print("[O]");
									}
									if(seat[j]==2) {
										System.out.print("[X]");
									}
								} 
								System.out.println();
							}
						}
					}
					// �����ο��� Ȧ���� ���
					else { 
						for(int i=0;i<(ppl-1)/2;i++) {
							System.out.print("�¼���ȣ ����: ");
							index = scan.nextInt();
							// �¼���ȣ�� ¦���� ���
							if(index%2==0) {
								seat[index-1] = 1;
								seat[index-2] = 1; // ���ڸ�
								total += 24000;
								for(int j=0;j<7;j++) {
									if(seat[j]==0) {
										System.out.print("[ ]");
									}
									if(seat[j]==1) {
										System.out.print("[O]");
									}
									if(seat[j]==2) {
										System.out.print("[X]");
									}
								}
								System.out.println();
							} 
							// �¼���ȣ�� Ȧ���� ���
							else {
								seat[index-1] = 1;
								seat[index] = 1; // ���ڸ�
								total += 24000;
								for(int j=0;j<7;j++) {
									if(seat[j]==0) {
										System.out.print("[ ]");
									}
									if(seat[j]==1) {
										System.out.print("[O]");
									}
									if(seat[j]==2) {
										System.out.print("[X]");
									}
								}
								System.out.println();
							}
						}
						// ���������� 1�ڸ� ����
						System.out.print("�¼���ȣ ����: ");
						index = scan.nextInt();
						// Ȧ�� ��ȣ�� �¼��� ������ ������ �ݺ�
						while(index%2==0) {
							System.out.println("Ȧ�� ��ȣ�� �¼��� �������ֽʽÿ�.");
							System.out.print("�¼���ȣ ����: ");
							index = scan.nextInt();
						}
						seat[index-1] = 1;
						total += 12000;
						for(int i=0;i<7;i++) {
							if(seat[i]==0) {
								System.out.print("[ ]");
							}
							if(seat[i]==1) {
								System.out.print("[O]");
							}
							if(seat[i]==2) {
								System.out.print("[X]");
							}
						}
					}

				}
				break;

			case 2: // �������
				// Ȧ���� �Է��ϸ� �� �ڿ� �ִ� �¼���ȣ�� 0���� �ٲ� (-24000)
				// ¦���� �Է��ϸ� �� �տ� �ִ� �¼���ȣ�� 0���� �ٲ� (-24000)
				// ���̳� �ڿ� �ִ� �¼���ȣ�� 0�̶�� �Է��� �ڸ��� 0���� �ٲ� (-12000)
				System.out.print("����� �¼���ȣ �Է� : ");
				index = scan.nextInt();
				// �¼���ȣ�� ¦���� ���
				if(index%2==0) {
					// �¼���ȣ, �� ���ڸ� �� �� ��� ���Ű� �Ǿ�������
					if(seat[index-1]==1 && seat[index-2]==1) { 
						seat[index-1] = 0;
						seat[index-2] = 0;
						total -= 24000;
						for(int i=0;i<7;i++) {
							if(seat[i]==0) {
								System.out.print("[ ]");
							}
							if(seat[i]==1) {
								System.out.print("[O]");
							}
							if(seat[i]==2) {
								System.out.print("[X]");
							}
						}
					}
					// �¼���ȣ �� �ڸ����� ���Ű� �Ǿ������� (���ڸ� ���� x)
					else {
						seat[index-1] = 0;
						total -= 12000;
						for(int i=0;i<7;i++) {
							if(seat[i]==0) {
								System.out.print("[ ]");
							}
							if(seat[i]==1) {
								System.out.print("[O]");
							}
							if(seat[i]==2) {
								System.out.print("[X]");
							}
						}
					}
				}
				// �¼���ȣ�� Ȧ���� ���
				else {
					// �¼���ȣ, �� ���ڸ� �� �� ��� ���Ű� �Ǿ�������
					if(seat[index-1]==1 && seat[index]==1) {
						seat[index-1] = 0;
						seat[index] = 0;
						total -= 24000;
						for(int i=0;i<7;i++) {
							if(seat[i]==0) {
								System.out.print("[ ]");
							}
							if(seat[i]==1) {
								System.out.print("[O]");
							}
							if(seat[i]==2) {
								System.out.print("[X]");
							}
						}
					}
					// �¼���ȣ �� �ڸ����� ���Ű� �Ǿ������� (���ڸ� ���� x)
					else {
						seat[index-1] = 0;
						total -= 12000;
						for(int i=0;i<7;i++) {
							if(seat[i]==0) {
								System.out.print("[ ]");
							}
							if(seat[i]==1) {
								System.out.print("[O]");
							}
							if(seat[i]==2) {
								System.out.print("[X]");
							}
						}
					}
				}
				break;
			case 3: // ����
				run = false;
				System.out.println("�� ����� = "+total); // �� ����� ���
				break;
			}
		}
		scan.close();
		
	}

}
