package seung_part05;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random ran = new Random();
		ClassEx05 ex05 = new ClassEx05();
		int size = ex05.answer.length;
		
		// hgd에 랜덤하게 5개 수를 저장한다.
		for(int i=0; i<size; i++) {
		   ex05.hgd[i] = ran.nextInt(5)+1;	
		}
		// O와 x를 출력하고 점수를 계산한다.
	    for(int i=0; i<size; i++) {
	    	if(ex05.answer[i] == ex05.hgd[i]) {
	    		ex05.ling ="○";
	    		//ex05.cnt ++;
	    		ex05.score += 20;
	    	}else {
	    		ex05.ns ="x";
	    	}
	    }
		ex05.answerInfo();
		ex05.TotalScore();
	}

}
