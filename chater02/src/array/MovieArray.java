package array;
import java.util.*;
public abstract class MovieArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7]; // ��ȭ�� �¼��� �迭����
		int cnt = 0; // �����ο��� ���� ����
		
		boolean run = true; //���ѷ��� �ʱⰪ
		while(run) {
			for(int i=0;i<seat.length;i++) {
				if(seat[i]==0) {  // �����¼��� 1�� �񿹸��¼��� 0���� �¼� �ʱⰪ���� ����
					System.out.print("[ ]");
				}else {
					System.out.print("[O]");
				}
			}
			System.out.println();
			System.out.println("=== �ް���ȭ�� ===");
			System.out.println("1.�¼�����");
			System.out.println("2.����");
			System.out.print("�޴� ���� :");
			int menu = scan.nextInt();
			switch(menu) {
			case 1 :
				System.out.print("�¼���ȣ ����[1~7] : ");
				int seatnumber = scan.nextInt();
				seatnumber -= 1 ; // seatnumber = seatnumber-1�� ���� �ǹ̷� �¼���ȣ�� 1������ ���������� �迭�� 0������ �����ϱ⶧���� 
				if(seat[seatnumber]==0) {
					seat[seatnumber] = 1; // ���ŵ� �ڸ��� 1�� �Է����ش�.
					cnt += 1;
				}else {
					System.out.println("�̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.");
				}
				break;
			case 2 :
				System.out.println("����� :"+cnt*12000);
				run = false;
				break;
			}
		}
	}

}
