package arrayAddDelInTest;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = {10,20,0,0,0};
		int cnt =2;

		boolean run = true;
		while(run) {
			// arr�� ������ ���
			for(int i=0; i<cnt; i++) {
				System.out.print(arr[i]+" ");
			}
		
			//�޴�
			System.out.println();
			System.out.println("[1].����");
			System.out.println("[2].�߰�");
			System.out.println("[3].����");
			System.out.println("[0].����");
			System.out.print("�޴����� :");
			int select = scan.nextInt();
			
			// arr�� ������ ����
			switch(select) {
			case 1:
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
			case 2:
				if(cnt == 5) {
					System.out.println("�� �̻� �߰��� �� �����ϴ�.");
					continue;
				}
				System.out.print("�߰��� ������ �Է�");
				int data1 = scan.nextInt();
				arr[cnt] = data1;
				cnt ++;
				break;
			case 3:
				if(cnt == 5) {
					System.out.println("�� �̻� ������ �� �����ϴ�.");
					break;
				}
				System.out.print("�����͸� ������ ��ġ�� �Է�");
				int insertIndex = scan.nextInt();
				if(cnt< insertIndex || insertIndex < 0) {
					System.out.println("������ ���� �Ұ���");
					continue;
				}
				System.out.print("������ ������ �Է�");
				int data2  = scan.nextInt();
				for(int i=cnt; i > insertIndex; i--) {
					 arr[i] = arr[i-1];
				}
				arr[insertIndex] = data2;
				cnt ++;
				break;
			case 0:
				System.out.println("����");
				run = false;
				break;
			}
		}

		scan.close();    
	}

}
