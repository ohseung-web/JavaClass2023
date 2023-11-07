package arrayEx01;

public class ArrayTest02 {

	public static void main(String[] args) {
		
		char[] alphabets = new char[26];
		char ch = 'A';
		
		for(int i=0 ; i<alphabets.length; i++) {
			alphabets[i] = ch;
			ch ++;
			System.out.println(alphabets[i]);
		}
	}

}
