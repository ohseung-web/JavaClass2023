package openChangle_EnglishGame;
import java.util.*;

class Word {
	private String eng;
	private String kor;
	
	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	
	public String getEng() {
		return eng;
	}
	
	public String getKor() {
		return kor;
	}
	
}
public class OpenChallenge01 {
	Scanner scan = new Scanner(System.in);
	Vector<Word> v = new Vector<>();
	Random rand = new Random();
	final int MAX_CHOICE = 4;
	int[] question = new int[MAX_CHOICE];
	
	public OpenChallenge01() {
		setVector();			// ���Ϳ� ��+�� �ܾ� ��ü�� �����Ѵ�.
		System.out.println("Java �ܾ� �׽�Ʈ�� �����մϴ�. -1�� �Է��ϸ� �����մϴ�.");
		System.out.println("���� " + v.size() + "���� �ܾ ��� �ֽ��ϴ�.");
		System.out.println("__________________________________________________");
		game();
	}
	
	public void game() {
		while(true) {
			setChoice(); 	// ���� ���� 4��(������ ���ڸ�ŭ) �����ؼ� �迭�� ���
			int answerNum = rand.nextInt(4);	//0~3�� �����ȣ ����
			int answerIndex = question[answerNum]; // �����ȣ�� �������ִ� �迭 �ȿ� ����ִ� ���ڰ� �����̴�.
			
			System.out.println(v.get(answerIndex).getEng() + "?"); // ���� �ε����� ����ܾ �����
			
			for(int i=0; i<question.length; i++) {		//������ �ε����δ� question �迭�� ��� ������ �ϳ��� �����鼭
				System.out.print("(" + (i+1) + ")");	//�ش� �ε����� kor�� ����Ѵ�.
				System.out.print(v.get(question[i]).getKor() + " "); 
			}
			System.out.print(">> ");
			
			int choice = scan.nextInt();
			if(choice == -1) {
				System.out.println("�����մϴ�.");
				break;
			}
			else if(choice-1 == answerNum) { //���̽��� 1~4������ �ε����� 0~3�̱⶧���� ���̽�-1���ش�.
				System.out.println("Excellent !!");
				System.out.println("__________________________________________________");
			} else {
				System.out.println("No. !!");
				System.out.println("__________________________________________________");
			}
		}
		
		
	}
	
	public void setChoice() {
		for(int i=0; i<MAX_CHOICE; i++) {		// ���� 4���� �����ϰ� ��������� question�迭�� 0~3 ������ 4���� �ִ´�.
			question[i] = rand.nextInt(v.size()); // ���� ���Ⱑ ������ �ȵǱ⶧���� �ߺ����� �ʰ� �ִ´�.
			for(int j=0; j<i; j++) {
				if(question[i] == question[j]) {
					i--;
					continue;
				}
			}
			System.out.println(Arrays.toString(question));
		}
	}
	
	public void setVector() {
		v.add(new Word("constructor", "������"));
		v.add(new Word("overriding", "������"));
		v.add(new Word("extends", "���"));
		v.add(new Word("array", "�迭"));
		v.add(new Word("string", "���ڿ�"));
		v.add(new Word("character", "����"));
		v.add(new Word("integer", "����"));
		v.add(new Word("double", "�Ǽ�"));
		v.add(new Word("abstract", "�߻�"));
		v.add(new Word("implements", "�����ϴ�"));
	}
	
	public static void main(String[] args) {
		new OpenChallenge01();
	}

}
