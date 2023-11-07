package englishWord;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int questionsize = 4; // 출력할  문제 개수
	int[]  question = new int[4]; // 출력할 문제의 index 번호를 담아 둘 변수 
        
	ArrayList<Word> wordList = new ArrayList<>();
   
	public WordGame() {
		wordSave();
	}

	// 영어단어  ArrayList에 저장하는 메서드
	public void wordSave() {

		wordList.add(new Word("extends","상속"));
		wordList.add(new Word("character","문자"));
		wordList.add(new Word("overriding","재정의"));
		wordList.add(new Word("constructor","생성자"));
		wordList.add(new Word("abstract","추상"));
		wordList.add(new Word("integer","정수"));
		wordList.add(new Word("String","문자열"));
		wordList.add(new Word("implements","구현하다"));
		wordList.add(new Word("array","배열"));
		wordList.add(new Word("double","실수"));

	}
	
	// 4문제씩 랜덤하게 영어단어의 indext 번호가 저장되는 메서드
	public void questionSave() {
		for(int i=0; i < 4; i++ ) {
			  question[i] = ran.nextInt(wordList.size());
			  for(int j=0; j<i; j++) {
				  if(question[i]==question[j]) {
					  i = -1; // 중복체크키
					  continue;
				  }
			  }
		}
	}	
	
	// 영어단어 gamePlay 메서드
	public void gamePlay() {
		System.out.println("Java 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 "+ wordList.size()+"개의 단어가 들어 있습니다.");
		
		while(true) {
			System.out.println("____________________________________________");
			questionSave();
			int answerNum = ran.nextInt(4); // 0~3까지 정답번호 랜덤하게 저장
			int answerIndex = question[answerNum]; // 정답의 index 번호를 저장
			System.out.println(wordList.get(answerIndex).getEnglish());
					
			// (1)~ (2)~ (3)~ (4)~ 정답보기 출력
			for(int i=0; i < question.length; i++) {
			     System.out.print("("+ (i+1) + ")");
			     System.out.print(wordList.get(question[i]).getKorea()+"  ");
			}
			
			System.out.print(": >");
			int  select = scan.nextInt();

			if(select == -1) {
				System.out.println("명품영어를 종료합니다. !!");
				break;
			}else if(answerNum == (select-1) ) {
				System.out.println("Excellent !!");
			}else {
				System.out.println("No !!");
			}
		}
	}
		
		
		

}












