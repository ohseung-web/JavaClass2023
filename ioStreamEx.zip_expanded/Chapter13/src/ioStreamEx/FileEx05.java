package ioStreamEx;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileEx05 {

	public static void main(String[] args) {
		int i = 0;
		File file = null;
		FileReader fr = null;
		try {
			file = new File("D:/temp4/words.txt");
			fr = new FileReader(file);
			ArrayList<String> words = new ArrayList<>();
			String str = "";
			while((i = fr.read()) != -1) {
				str += (char)i;
			}
			
			StringTokenizer st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				words.add(st.nextToken());
			}
			
			System.out.println("������Ʈ ���� ���� "+file.getName()+" ������ �о����ϴ�...");
			while(true) {
				System.out.print("�ܾ�>>");
				Scanner scan = new Scanner(System.in);
				String word = scan.next();
				int wordCount = 0;
				
				if(word.equals("�׸�")) {
					System.out.println("�����մϴ�...");
					scan.close();
					break;
				}
				else {
					for(String wds : words) {
						if(word.length()>wds.length()) {
							continue;
						}
						else if(word.equals(wds.substring(0, word.length()))) {
							System.out.println(wds);
							wordCount++;
						}
					}
					if(wordCount==0) {
						System.out.println("�߰��� �� ����.");
					}
				}
			}
			
		}catch(IOException ioe) {
			System.out.println(ioe);
		}finally {
			try {
				fr.close();
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}

	}

}
