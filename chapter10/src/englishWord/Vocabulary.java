package englishWord;
import java.util.*;

public class Vocabulary {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int questionsize = 4; // 출력할  문제 개수
	int[]  question = new int[4]; // 출력할 문제의 index 번호를 담아 둘 변수 
        
	ArrayList<Word> wordList = new ArrayList<>();
   
	public Vocabulary() {
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

	// 영어 단어 문제 출력 메서드
	public void problemRun() {

		System.out.println("Java 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 "+ wordList.size()+"개의 단어가 들어 있습니다.");

		while(true) {
		
			System.out.println("______________________________________");

			//-- wordList에 저장된 데이터의 index를 랜덤하게 4개만 question 배열에 담아둔다.  
			for(int i=0; i<4; i++) {
				question[i] = ran.nextInt(wordList.size());
				//System.out.println("i"+i+" ");
				for(int j=0; j<i; j++) {
					//System.out.println();
				//	System.out.println("j"+j+" ");
					if(question[i] == question[j]) { // 같은 index의 저장을 방지하는 예외처리
						i = -1; // 중복여부 치트키
						continue;
					}
				}
				//System.out.println(Arrays.toString(question));
			}
			//-----------------------------------------------------------------
			int answerNum = ran.nextInt(4); //0~3중 정답번호 생성
			System.out.println("정답번호 :"+answerNum);
			int answerIndex = question[answerNum]; // 정답번호를 가지고있는 배열 안에 들어있는 숫자가 정답이다.
			System.out.println("index"+question[answerNum]);
			System.out.println(wordList.get(answerIndex).getEnglish() + "?");
		
				for(int k=0; k<question.length; k++) {
					System.out.print("("+(k+1)+")");
					System.out.print(wordList.get(question[k]).getKorea()+"  ");
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


