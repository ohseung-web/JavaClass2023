package array;
import java.util.*;
public class ArrayExample10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		System.out.println("학번을 입력하세요 :");
		int hak = scan.nextInt();
		for(int i=0;i<hakbuns.length;i++) {
			if(hakbuns[i]==hak) {
				System.out.println("점수 :"+scores[i]+"점");
			}
		}
	}

}
