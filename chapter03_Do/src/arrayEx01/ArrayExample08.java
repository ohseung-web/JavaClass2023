package arrayEx01;
import java.util.*;
public class ArrayExample08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7];

		int cnt = 0; //�¼����� ����
		boolean run = true;
		while(run) {
			for(int i=0; i<seat.length; i++) {
				if(seat[i] == 0) {
					System.out.print("[ ]");
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
				System.out.print("�¼���ȣ ����[1~7] : ");
				int idx = scan.nextInt();
				idx -= 1; // �迭�� index��ȣ�� 0������ �����ϱ⶧���� �ʱⰪ�� 0���� ����� �ִ� ��

				if(seat[idx] == 0) {
					seat[idx] = 1;
					cnt += 1;
				}else {
					System.out.println("�̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.");
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
