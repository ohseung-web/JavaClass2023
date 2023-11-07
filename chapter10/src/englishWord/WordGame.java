package englishWord;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int questionsize = 4; // �����  ���� ����
	int[]  question = new int[4]; // ����� ������ index ��ȣ�� ��� �� ���� 
        
	ArrayList<Word> wordList = new ArrayList<>();
   
	public WordGame() {
		wordSave();
	}

	// ����ܾ�  ArrayList�� �����ϴ� �޼���
	public void wordSave() {

		wordList.add(new Word("extends","���"));
		wordList.add(new Word("character","����"));
		wordList.add(new Word("overriding","������"));
		wordList.add(new Word("constructor","������"));
		wordList.add(new Word("abstract","�߻�"));
		wordList.add(new Word("integer","����"));
		wordList.add(new Word("String","���ڿ�"));
		wordList.add(new Word("implements","�����ϴ�"));
		wordList.add(new Word("array","�迭"));
		wordList.add(new Word("double","�Ǽ�"));

	}
	
	// 4������ �����ϰ� ����ܾ��� indext ��ȣ�� ����Ǵ� �޼���
	public void questionSave() {
		for(int i=0; i < 4; i++ ) {
			  question[i] = ran.nextInt(wordList.size());
			  for(int j=0; j<i; j++) {
				  if(question[i]==question[j]) {
					  i = -1; // �ߺ�üũŰ
					  continue;
				  }
			  }
		}
	}	
	
	// ����ܾ� gamePlay �޼���
	public void gamePlay() {
		System.out.println("Java �ܾ� �׽�Ʈ�� �����մϴ�. -1�� �Է��ϸ� �����մϴ�.");
		System.out.println("���� "+ wordList.size()+"���� �ܾ ��� �ֽ��ϴ�.");
		
		while(true) {
			System.out.println("____________________________________________");
			questionSave();
			int answerNum = ran.nextInt(4); // 0~3���� �����ȣ �����ϰ� ����
			int answerIndex = question[answerNum]; // ������ index ��ȣ�� ����
			System.out.println(wordList.get(answerIndex).getEnglish());
					
			// (1)~ (2)~ (3)~ (4)~ ���亸�� ���
			for(int i=0; i < question.length; i++) {
			     System.out.print("("+ (i+1) + ")");
			     System.out.print(wordList.get(question[i]).getKorea()+"  ");
			}
			
			System.out.print(": >");
			int  select = scan.nextInt();

			if(select == -1) {
				System.out.println("��ǰ��� �����մϴ�. !!");
				break;
			}else if(answerNum == (select-1) ) {
				System.out.println("Excellent !!");
			}else {
				System.out.println("No !!");
			}
		}
	}
		
		
		

}












