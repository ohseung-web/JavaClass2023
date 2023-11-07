package array;

public class ArrayExample3 {

	public static void main(String[] args) {
		int[]  arr = new int[5];
		int tot = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			if(arr[i] % 4 == 0) {
				tot += arr[i];
			}
		}
		System.out.print(tot);
	}

}
