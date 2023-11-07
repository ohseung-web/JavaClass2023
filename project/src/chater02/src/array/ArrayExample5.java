package array;

public class ArrayExample5 {

	public static void main(String[] args) {
		int[]  arr = new int[5];
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			if(arr[i] % 2 == 0) {
				cnt += 1;
			}
		}
		System.out.print(cnt);
	}

}
