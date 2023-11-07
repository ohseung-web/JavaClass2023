package file;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileEx05 {

	public static void main(String[] args) {

		FileReader fr=null;
		ArrayList<String> A;
		Scanner sc;
		
		try {
			fr=new FileReader(new File("D:\\temp3\\words.txt"));
			A=new ArrayList<String>();
			sc=new Scanner(fr);
			
			String word="";
			while(sc.hasNext()) {
				word=sc.next();
				A.add(word);
			}
			
			
			System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다...");
			
			sc.close();
			sc=new Scanner(System.in);
			
			while(true) {
				boolean find=false;
				System.out.print("단어>>");
				word=sc.next();
				if(word.equals("그만")) break;
				for(int i=0;i<A.size();i++) {
					String w=A.get(i);
					if(w.length()<word.length()) continue;
					
					String sub=w.substring(0,word.length());
					if(sub.equals(word)){
						System.out.println(w);
						find=true;
					}
				}
				if(!find) System.out.println("발견할 수 없음.");
			}
			System.out.println("종료합니다...");
			sc.close();
			fr.close();
		}catch(Exception e) {
		   System.out.println(e);
		}

	}

}