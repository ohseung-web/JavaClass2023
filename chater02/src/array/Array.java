package array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		int[] arr2 = null;
		int[] arr3 = null;
		System.out.println(arr1);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(arr2);
		arr3=arr1;
		System.out.println(arr3);

	}

}
