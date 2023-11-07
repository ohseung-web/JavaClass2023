package muti_array;

public class Muti_Array2 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int k = 1;
		int tot = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = 10 * k;
				k += 1;
				System.out.print(arr[i][j]+" ");
				tot += arr[i][j];
			}
			System.out.println();
		}
		System.out.print("전체 합 출력 : "+tot);

	}

}
