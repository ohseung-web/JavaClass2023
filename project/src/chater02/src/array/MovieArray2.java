package array;
import java.util.*;
public abstract class MovieArray2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		int[] seat = new int[7];

		int cnt = 0;

		boolean run = true;
		while(run) {

			for(int i=0; i<7; i++) {
				if(seat[i] == 0) {
					System.out.print("[ ]");
				}else if(seat[i]==2) {
					System.out.print("[X]");
				}else {
					System.out.print("[O]");
				}
			}
			System.out.println();

			System.out.println("=�ް� ��ȭ��=");
			System.out.println("1.�¼�����");
			System.out.println("2.����");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.print("���� �ο��� �Է��ϼ���[1~7] :");
				int inwon = scan.nextInt();
				System.out.print("�¼���ȣ ����[1~7] : ");
				int idx = scan.nextInt();
				idx -= 1;

				if(inwon ==1) {
					if( idx % 2  != 0) {
						seat[idx] = 2;
						System.out.println("���� �Ұ���");
					}else if(seat[idx]==0) {
						seat[idx] =1;
						cnt += 1;
					}else {
						System.out.println("�̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.");
					}
				}else if(inwon >= 2 && inwon <=7) {

					if(seat[idx]==0) {
						seat[idx]=1;
						for(int i=1;i<inwon;i++) {
							seat[idx+i]=1;
						}
						cnt += inwon;
					}else {
						System.out.println("�̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.");
					}
				}
				else {
					//			------------ �����ο����� 1�̻��� ��� ¦�� �ڸ� ���� �ڵ� -------
					if(idx % 2 != 0 && seat[idx] != 1) {
						seat[idx] = 0;
					}
					//		  ----------------------------------------------------------------------------			    
					if(seat[idx] == 0) {
						seat[idx] = 1;
						cnt += 1;
					}else {
						System.out.println("�̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.");
					}
				}
			}


			else if(sel == 2) {

				int total = cnt * 12000;
				System.out.println("����� = " +total + "��");

				run = false;
			}
		}

		scan.close();

	}
}
