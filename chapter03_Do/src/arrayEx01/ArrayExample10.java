package arrayEx01;
import java.util.*;
public class ArrayExample10 {

	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
		
		int[] arr = {10, 20, 30, 40, 50};
		
		// ���� 1) �ε��� 2���� �Է¹޾� �� ��ü�ϱ�
		// ��    1) �ε���1 �Է� : 1
		//		   �ε���2 �Է� : 3
		//		  {10, 40, 30, 20, 50}
		System.out.println(">>>����1");
		System.out.print("�ε���1 �Է� : ");
		int idx1 = scan.nextInt();
		System.out.print("�ε���2 �Է� : ");
		int idx2 = scan.nextInt();
		
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	
	
	//---------------------------------------------------------------------------------------
	
	System.out.println(">>>����2");
	System.out.print("��1 �Է� : ");
	int data1 = scan.nextInt();
	System.out.print("��2 �Է� : ");
	int data2 = scan.nextInt();

	int idx3 = 0;
	int idx4 = 0;

	for(int i=0; i<5; i++) {
		if(arr[i] == data1) {
			idx1 = i;
		}
		if(arr[i] == data2) {
			idx2 = i;
		}
	}
	int temp2 = arr[idx3];
	arr[idx3] = arr[idx4];
	arr[idx4] = temp2;

	for(int i=0; i<5; i++) {
		System.out.print(arr[i] + " ");
	}
	System.out.println();
}

}
