package seungHyun_File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearch {

    private ArrayList<String> wordArray = new ArrayList<String>();
	
	public WordSearch() { }
	
	//  words.txt ���� �б� �޼���
	private boolean readFile() { 
		try {
			Scanner fScanner = new Scanner(new FileInputStream("D:\\temp3\\words.txt"));
			while(fScanner.hasNext()) 
				wordArray.add(fScanner.nextLine()); // �� ���ο� �ϳ��� �ܾ�
			fScanner.close();
		}catch(FileNotFoundException e) { 
			System.out.println("������Ʈ ���� ���� words.txt ������ �����ϴ�");
			return false;
		} 
		System.out.println("������Ʈ ���� ���� words.txt ������ �о����ϴ�...");
		return true;
	}
	
	// �ܾ� �˻� �޼���
	private void processQuery() { 
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean found = false;
			System.out.print("�ܾ�>>");
			String searchWord = scanner.nextLine(); // �˻��� �ܾ� �Է�
			if(searchWord.equals("�׸�")) { 
				break; // �˻� ����
			}
			
			// ArrayList���� �˻�
			for(int i=0; i<wordArray.size(); i++) {
				String word = wordArray.get(i); // ArrayList ���� ���ڿ�
				if(word.length() < searchWord.length()) // ArrayList�� ���ڿ��� �˻� ���ڿ����� ª�� ��� 
					continue;
				
				// ArrayList���ڿ��� �պκ��� �˻� ���ڿ� ũ�⸸ŭ �߶󳻱�
				String frontPart = word.substring(0, searchWord.length());
				
				if(searchWord.equals(frontPart)) { // �˻� ���ڿ��� �߶� �� �κ� ��
					System.out.println(word); // ArrayList���� �߰��� �ܾ� ���
					found = true;
				}
			}
			if(!found) // �� �ܾ �߰߸��� ����
				System.out.println("�߰��� �� ����");
		}
		scanner.close();

	}
	
	// ������ �������� ������ ���� �޼���
	public void run() {
		boolean res = readFile(); // res�� false�̸�  �ܾ� ���� �б� ����
		if(res == true)
			processQuery();
		System.out.println("�����մϴ�...");
	}
	
	
	public static void main(String[] args) {

		WordSearch word = new WordSearch();
		word.run();
		
	}

}
