package wordGame;

import java.util.Scanner;

public class WordGameApp {

	int people;
	Player p[];
	String cur;
	
	public WordGameApp()
	{
		cur="�ƹ���";
	}
	
	public void run()
	{
		System.out.println("�����ձ� ������ �����մϴ�.");
		System.out.print("���ӿ� �����ϴ� �ο��� ����Դϱ�>>");
		Scanner scanner = new Scanner(System.in);
		people = scanner.nextInt();
		p = new Player[people];
		
		for(int i=0;i<people;i++)
		{
			String str;
			System.out.print("�������� �̸��� �Է��ϼ���>>");
			str = scanner.next();
			p[i]=new Player(str);
		}
		System.out.println("�����ϴ� �ܾ�� �ƹ����Դϴ�.");
		int idx=0;
		while(true)
		{
			p[idx].getWordFromUser();
			if(p[idx].checkSuccess(cur)) {
				cur=p[idx].word;
			}
			else
			{
				System.out.println(p[idx].name+"�� �����ϴ�.");
				break;
			}
			
			idx= (idx+1)%people;
		}
		
		
		
	}
	
	public static void main(String[] args) {

		WordGameApp game = new WordGameApp();
		game.run();
		
	}

}
