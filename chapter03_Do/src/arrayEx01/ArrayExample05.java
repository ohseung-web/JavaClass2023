package arrayEx01;
import java.util.*;
public class ArrayExample05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		System.out.println("학번을 입력하세요 :");
		int hak = scan.nextInt();
		int check = -1; //예외처리를 위한 체크키
		for(int i=0;i<hakbuns.length;i++) {
			if(hakbuns[i]==hak) {
				check = i;
			}
		}
		if(check != -1) {
			System.out.println("점수 :"+scores[check]+"점");
		}else {
			System.out.println("해당학번은 존재하지 않습니다.");
		}
	}

}
