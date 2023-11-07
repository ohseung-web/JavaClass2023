package arrayEx01;
import java.util.*;
public class ArrayExample06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		int maxscore =0;
		int check = 0;
		for(int i=0;i<scores.length;i++) {
			for(int j=i+1;j<scores.length;j++) {
				if(scores[i]>scores[j]) {
					maxscore = scores[i];
					check = i;
				}
			}
		}
		System.out.println("우등생:"+hakbuns[check]+"("+maxscore+"점)");
		
		/*
		    int maxScore = 0;
		    int maxIdx = 0;
		    for(int i=0; i<5; i++) {
		      	if(maxScore < scores[i]) {
				maxScore = scores[i];
				maxIdx = i;
			}
		}
		
		System.out.println("1등 학생 = " + hakbuns[maxIdx] + "번(" + maxScore + "점)");
		*/
		
	}

}
