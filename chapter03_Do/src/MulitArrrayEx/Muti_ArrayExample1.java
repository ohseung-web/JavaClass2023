package MulitArrrayEx;

public class Muti_ArrayExample1 {

	public static void main(String[] args) {

		// 각각 가로의 합, 세로의 합 출력
		
		int[][] arr = {
			      	{101, 102, 103, 104},
			    	{201, 202, 203, 204},
			    	{301, 302, 303, 304}
			}; 

		 int[] row = new int[3];
		 int[] colum = new int[4];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0; j<arr[0].length; j++) {
				row[i] += arr[i][j];
				colum[j] += arr[i][j];
			    System.out.println("row["+i+"]="+arr[i][j]);
				//System.out.println();
				//System.out.println("colum["+j+"]="+arr[i][j]);
			}
		}
		
			
		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.println("가로의 합 :"+row[i]+"");
		}
		System.out.println();
		for(int i=0; i<arr[0].length; i++) {
			System.out.println("세로의 합 :"+colum[i]+"");
		}
		
	}

}
