package array;
import java.util.*;
public class ArrayExample12 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] answer = {1, 3, 4, 2, 5};
		int[] hgdwer = new int[5];
		
		for(int i=0;i<hgdwer.length;i++) {
			hgdwer[i] = ran.nextInt(5)+1;
		}
		System.out.print("answer = {");
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		
		System.out.print("hgdwer = {");
		for(int i=0;i<hgdwer.length;i++) {
			System.out.print(hgdwer[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		
		int cnt = 0;
		System.out.print("정오표  = {");
		for(int i=0;i<5;i++) {
			if(answer[i] == hgdwer[i]) {
				System.out.print("○ ");
				cnt += 1;
			}else {
				System.out.print("X ");
			}
		}
		System.out.print("}");
		System.out.println();
		System.out.println("성적 = "+ cnt*20+"점");
	}

}
