package array;

import java.util.Arrays;

public class Muti_Array1 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int k = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				arr[i][j] = 10 * k;
				k += 1;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
