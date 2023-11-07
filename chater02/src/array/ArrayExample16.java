package array;
import java.util.*;
public class ArrayExample16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		// 문제 3) 학번 2개를 입력받아 성적 교체하기
		// 예    3) 학번1 입력 : 1002
		//        학번2 입력 : 1003
		//		 {87, 45, 11, 98, 23}
		System.out.println(">>>문제3");
		System.out.print("학번1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("학번2 입력 : ");
		int num2 = scan.nextInt();
		
		int idx1 = 0;
		int idx2 = 0;
		
		for(int i=0; i<5; i++) {
			if(hakbuns[i] == num1) {
				idx1 = i;
			}
			if(hakbuns[i] == num2) {
				idx2 = i;
			}
		}
		
		int temp = scores[idx1];
		scores[idx1] = scores[idx2];
		scores[idx2] = temp;
		
		for(int i=0; i<5; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();
         

     scan.close();
	}

}
