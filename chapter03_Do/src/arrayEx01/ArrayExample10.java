package arrayEx01;
import java.util.*;
public class ArrayExample10 {

	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
		
		int[] arr = {10, 20, 30, 40, 50};
		
		// 문제 1) 인덱스 2개를 입력받아 값 교체하기
		// 예    1) 인덱스1 입력 : 1
		//		   인덱스2 입력 : 3
		//		  {10, 40, 30, 20, 50}
		System.out.println(">>>문제1");
		System.out.print("인덱스1 입력 : ");
		int idx1 = scan.nextInt();
		System.out.print("인덱스2 입력 : ");
		int idx2 = scan.nextInt();
		
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	
	
	//---------------------------------------------------------------------------------------
	
	System.out.println(">>>문제2");
	System.out.print("값1 입력 : ");
	int data1 = scan.nextInt();
	System.out.print("값2 입력 : ");
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
