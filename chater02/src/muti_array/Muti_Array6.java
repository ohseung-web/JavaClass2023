package muti_array;
import java.util.*;
public class Muti_Array6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[3][3];
		int k = 1;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		System.out.println("인덱스1 입력:");
		int index1 = scan.nextInt();
		System.out.println("인덱스2 입력:");
		int index2 = scan.nextInt();
		System.out.println("값 출력 :"+arr[index1][index2]);
        scan.close();
	}

}
