package array;
import java.util.*;
public class ArrayExample9_Asending {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = {90,23,67,100,34};
		int[] temp = new int[5];
		System.out.println("===== 오름차순 정렬  =======");
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp[i] = arr[i];
					arr[i] = arr[j];
					arr[j] = temp[i];
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
