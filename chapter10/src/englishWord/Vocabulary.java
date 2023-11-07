package englishWord;
import java.util.*;

public class Vocabulary {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int questionsize = 4; // �����  ���� ����
	int[]  question = new int[4]; // ����� ������ index ��ȣ�� ��� �� ���� 
        
	ArrayList<Word> wordList = new ArrayList<>();
   
	public Vocabulary() {
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

	// ���� �ܾ� ���� ��� �޼���
	public void problemRun() {

		System.out.println("Java �ܾ� �׽�Ʈ�� �����մϴ�. -1�� �Է��ϸ� �����մϴ�.");
		System.out.println("���� "+ wordList.size()+"���� �ܾ ��� �ֽ��ϴ�.");

		while(true) {
		
			System.out.println("______________________________________");

			//-- wordList�� ����� �������� index�� �����ϰ� 4���� question �迭�� ��Ƶд�.  
			for(int i=0; i<4; i++) {
				question[i] = ran.nextInt(wordList.size());
				//System.out.println("i"+i+" ");
				for(int j=0; j<i; j++) {
					//System.out.println();
				//	System.out.println("j"+j+" ");
					if(question[i] == question[j]) { // ���� index�� ������ �����ϴ� ����ó��
						i = -1; // �ߺ����� ġƮŰ
						continue;
					}
				}
				//System.out.println(Arrays.toString(question));
			}
			//-----------------------------------------------------------------
			int answerNum = ran.nextInt(4); //0~3�� �����ȣ ����
			System.out.println("�����ȣ :"+answerNum);
			int answerIndex = question[answerNum]; // �����ȣ�� �������ִ� �迭 �ȿ� ����ִ� ���ڰ� �����̴�.
			System.out.println("index"+question[answerNum]);
			System.out.println(wordList.get(answerIndex).getEnglish() + "?");
		
				for(int k=0; k<question.length; k++) {
					System.out.print("("+(k+1)+")");
					System.out.print(wordList.get(question[k]).getKorea()+"  ");
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


