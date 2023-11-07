package array;

public class ArrayExample01 {

	public static void main(String[] args) {
		int[]  arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			System.out.print(arr[i]+" ");
		}
	}

}
