package array;
import java.util.*;
public class ArrayExample6 {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);

		int [] score = new int[5];
		String [] name = {"홍길동","개나리","진달래","김백합","최동훈"};
		int avg =0;
		int cnt = 0;
		int total =0;

		for(int i=0;i<5;i++) {
			System.out.printf("%s의 점수를 입력하세요", name[i]);
			score[i]=scan.nextInt();
			total =total + score[i];
			cnt = cnt + 1;
		}
		for(int j=0;j<5;j++) {
			System.out.printf("%s의 점수 :  %d",name[j],score[j]);
			System.out.println();
		}

		avg = total / cnt;
		System.out.println("---------------------------\n 평점 : \t"+ avg);
		scan.close();
	}
}
