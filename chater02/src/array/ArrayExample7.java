package array;
import java.util.*;
public class ArrayExample7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[]  arr = {87,11,45,98,23};
		System.out.println("성적입력 :");
		int score = scan.nextInt();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==score) {
				System.out.println(i);
			}
		}
	}

}
