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
			
			System.out.println("프로젝트 폴더 밑의 "+file.getName()+" 파일을 읽었습니다...");
			while(true) {
				System.out.print("단어>>");
				Scanner scan = new Scanner(System.in);
				String word = scan.next();
				int wordCount = 0;
				
				if(word.equals("그만")) {
					System.out.println("종료합니다...");
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
						System.out.println("발견할 수 없음.");
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
