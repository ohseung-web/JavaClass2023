package muti_array;

public class Muti_Array5 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		int k = 1;
		int cnt =0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = 10 * k;
				k += 1;
				if(arr[i][j] % 4 == 0) {
					cnt += 1;
				}
			}
		}
		System.out.println("4의 배수개수 :"+cnt);

	}

}
