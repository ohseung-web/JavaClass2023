package classpart05;

import java.util.Random;

public class MainClass {

	public static void main(String[] args) {
		Random ran = new Random();
		ClassEx05 e = new ClassEx05();
		int size = e.answer.length;

		for(int i=0;i<size;i++) {
			e.hgd[i] = ran.nextInt(5)+1;
		}

		for(int i=0;i<size;i++) {
			if(e.answer[i]==e.hgd[i]) {
				e.cnt += 1;
				e.score += 20;
				e.ling = "¡Û";
			}else {
				e.ns = "x";
			}
		}

		e.answerInfo();
		e.TotalScore();
	}

}
