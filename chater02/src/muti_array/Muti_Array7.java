package muti_array;
import java.util.*;
public class Muti_Array7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[3][3];
		int k = 1;
		int temp = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		System.out.println("값1 입력:");
		int data1 = scan.nextInt();
		System.out.println("값2 입력:");
		int data2 = scan.nextInt();
		
		int index1_i =0, index1_j =0;
		int index2_i =0, index2_j =0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==data1)  {
					index1_i = i;
					index1_j = j;
				}
				if(arr[i][j]==data2)  {
					index2_i = i;
					index2_j = j;
				}
			}
		}
		temp = arr[index1_i][index1_j];
		arr[index1_i][index1_j] = arr[index2_i][index2_j];
		arr[index2_i][index2_j] = temp;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		scan.close();
	}

}
