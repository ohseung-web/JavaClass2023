package arrayEx01;

import java.util.Scanner;

public class ArrayExample_Addition {

	public static void main(String[] args) {
		// �迭�� ���� �߰�
		Scanner scan = new Scanner(System.in);
		int[] arr = {10, 20, 0, 0, 0};
		int cnt = 2;

		boolean run = true;
		while(run) {

			for(int i=0; i<cnt; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("[1].�߰�");
			System.out.println("[2].����");
			System.out.print("�޴����� :");
			int select = scan.nextInt();

			switch(select){
			case 1:
				if(cnt ==5) {
					System.out.println("�� �̻� �߰� �� �� �����ϴ�.");
					continue;
				}
				System.out.println("�߰��� �� �Է�");
				int data = scan.nextInt();
				arr[cnt] = data;
				cnt += 1;
				break;
			case 2:
				System.out.println("����");
				run = false;
				break;
			}
		}
	   scan.close();
//---------------------------------------------------------------------------------
	}
}
