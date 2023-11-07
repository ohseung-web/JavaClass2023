package arrayListWord_seungjun;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		ArrayList<Word> wordlist = new ArrayList<>();
		
		wordlist.add(new Word("extends","상속"));
		wordlist.add(new Word("character","문자"));
		wordlist.add(new Word("overriding","재정의"));
		wordlist.add(new Word("constructor","생성자"));
		wordlist.add(new Word("abstract","추상"));
		wordlist.add(new Word("integer","정수"));
		wordlist.add(new Word("implement","구현하다"));
		wordlist.add(new Word("double","실수"));
		wordlist.add(new Word("array","배열"));
		wordlist.add(new Word("string","문자열"));
		
		System.out.println("Java 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 "+wordlist.size()+"개의 단어가 들어 있습니다.");
		while(true) {
			System.out.println("----------------------------------------");
			int ranNum = ran.nextInt(wordlist.size());
			String question = wordlist.get(ranNum).getEngWord(); // 질문(영어 단어)
			System.out.println(question+"?");
			String answer = wordlist.get(ranNum).getKorWord(); // 정답(한국 단어)
			
			HashSet<String> options = new HashSet<>();
			
			options.add(answer);
			while(options.size()!=4) {
				options.add(wordlist.get(ran.nextInt(wordlist.size())).getKorWord());
			}
			/*
			String[] option = new String[4];
			for(int i=0;i<option.length;i++) {
				int answerIndex = ran.nextInt(option.length); // 정답이 있는 위치
				option[answerIndex] = answer;
				// 나머지 부분은 정답 외 다른 단어들로 모두 채운다.
				if(i==answerIndex) { // 정답이 있는 위치는 넘어갈 것
					continue;
				}
				else {
					while(true) {
						option[i] = wordlist.get(ran.nextInt(wordlist.size())).getKorWord();
						if(!option[i].equals(answer)) {
							break;
						}
					}
				}
			}
			*/
			
			int num =1;
			for(String option : options) {
				
				System.out.print("("+num+")"+option+" ");
				num ++;
			}
			System.out.print(">> ");
			
			Iterator<String> it = options.iterator(); 
			int userAns = scan.nextInt(); // 유저가 적은 번호
			
			if(userAns == -1) { // -1을 적을 경우 종료
				System.out.println("종료합니다.");
				break;
			}
			else {
				// 유저가 적은 번호에 해당되는 단어가 정답과 일치할 경우
				// *****************************************
				if(options.equals(answer)) {
				// *****************************************
					System.out.println("Excellent !!");
				}
				else { // 일치하지 않을 경우
					System.out.println("No !!");
				}
			}
		}
	}
}
