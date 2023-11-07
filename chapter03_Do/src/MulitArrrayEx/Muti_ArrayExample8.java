package MulitArrrayEx;

public class Muti_ArrayExample8 {

	public static void main(String[] args) {

		// 다차원 배열 10 20 30 40 50 60 70 80 90 3행 3열로 출력
		
		int[][] arr = new int[3][3];
		int k =1;
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = 10*k;
				k ++;
			System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		// 주소출력
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
