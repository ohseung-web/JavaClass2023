package arrayEx01;

import java.util.Scanner;

public class ArrayExample_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] arr = {10, 20, 30, 40, 50};
		int cnt = 5;


		boolean run = true;
		while(run) {
			for(int i=0; i<cnt; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("[2].����");
			System.out.print("�޴�����:");
			int select = scan.nextInt();

			switch(select) {
			case 2:
				System.out.println("������ ���� �Է��ϼ���");
				int data = scan.nextInt();

				int delindex = -1;// ������ ���� �����ϴ��� ���� ġƮŰ
				for(int i=0; i<cnt; i++) {
					if(arr[i] == data) {
						delindex = i;	 // delindex = 1	   
					}
				}
				if(delindex == -1) {
					System.out.println("���� ���� �ʴ� ���Դϴ�.");
					break;
				}else {
					for(int i=delindex; i<cnt-1;i++) { 
						arr[i] = arr[i+1];
					}
				}
				cnt -= 1;
				break;
			}

		}

	}

}
