package array;
import java.util.*;
public class ArrayExample15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = {10, 20, 30, 40, 50};

		System.out.println(">>>문제2");
		System.out.print("값1 입력 : ");
		int data1 = scan.nextInt();
		System.out.print("값2 입력 : ");
		int data2 = scan.nextInt();

		int idx1 = 0;
		int idx2 = 0;

		for(int i=0; i<5; i++) {
			if(arr[i] == data1) {
				idx1 = i;
			}
			if(arr[i] == data2) {
				idx2 = i;
			}
		}
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;

		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
