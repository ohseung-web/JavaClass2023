package arrayEx01;

import java.util.*;
public class ArrayExample02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int total = 0;
		int ave = 0;
		
		String[] name = {"홍길동","개나리","진달래","김백합","최동훈"};
		int[] score = new int[5];

		for(int i=0; i<name.length; i++) {
			System.out.printf("%s의 점수를 입력하세요 ",name[i]);
			score[i] = scan.nextInt();
		}

		for(int i=0; i<score.length; i++) {
			System.out.printf("%s의 점수는 %d",name[i],score[i]);
			total += score[i];
			ave =(int) total/score.length;
			System.out.println();
		}
		
		System.out.println("---------------------------------");
		System.out.println("평점 :"+ ave);

	}

}
