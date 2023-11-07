package arrayListWord_seungjun;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		ArrayList<Word> wordlist = new ArrayList<>();
		
		wordlist.add(new Word("extends","���"));
		wordlist.add(new Word("character","����"));
		wordlist.add(new Word("overriding","������"));
		wordlist.add(new Word("constructor","������"));
		wordlist.add(new Word("abstract","�߻�"));
		wordlist.add(new Word("integer","����"));
		wordlist.add(new Word("implement","�����ϴ�"));
		wordlist.add(new Word("double","�Ǽ�"));
		wordlist.add(new Word("array","�迭"));
		wordlist.add(new Word("string","���ڿ�"));
		
		System.out.println("Java �ܾ� �׽�Ʈ�� �����մϴ�. -1�� �Է��ϸ� �����մϴ�.");
		System.out.println("���� "+wordlist.size()+"���� �ܾ ��� �ֽ��ϴ�.");
		while(true) {
			System.out.println("----------------------------------------");
			int ranNum = ran.nextInt(wordlist.size());
			String question = wordlist.get(ranNum).getEngWord(); // ����(���� �ܾ�)
			System.out.println(question+"?");
			String answer = wordlist.get(ranNum).getKorWord(); // ����(�ѱ� �ܾ�)
			
			HashSet<String> options = new HashSet<>();
			
			options.add(answer);
			while(options.size()!=4) {
				options.add(wordlist.get(ran.nextInt(wordlist.size())).getKorWord());
			}
			/*
			String[] option = new String[4];
			for(int i=0;i<option.length;i++) {
				int answerIndex = ran.nextInt(option.length); // ������ �ִ� ��ġ
				option[answerIndex] = answer;
				// ������ �κ��� ���� �� �ٸ� �ܾ��� ��� ä���.
				if(i==answerIndex) { // ������ �ִ� ��ġ�� �Ѿ ��
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
			int userAns = scan.nextInt(); // ������ ���� ��ȣ
			
			if(userAns == -1) { // -1�� ���� ��� ����
				System.out.println("�����մϴ�.");
				break;
			}
			else {
				// ������ ���� ��ȣ�� �ش�Ǵ� �ܾ ����� ��ġ�� ���
				// *****************************************
				if(options.equals(answer)) {
				// *****************************************
					System.out.println("Excellent !!");
				}
				else { // ��ġ���� ���� ���
					System.out.println("No !!");
				}
			}
		}
	}
}
