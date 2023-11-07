package wordGame;

import java.util.Scanner;

public class Player {

	String name;
	String word;
	
	public Player(String str)
	{
		name=str;
	}
	
	public void getWordFromUser()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(name+">>");
		word = scan.next();
	}
	
	public boolean checkSuccess(String str)
	{
		if(str.charAt(str.length()-1) == word.charAt(0))
			return true;
		return false;
	}
}
