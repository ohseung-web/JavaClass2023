package muti_array;

public class Muti_Array01 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int k = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = 10 * k;
				k += 1;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
