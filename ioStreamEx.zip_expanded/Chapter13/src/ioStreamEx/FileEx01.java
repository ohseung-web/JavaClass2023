package ioStreamEx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileEx01 {

	public static void main(String[] args) {
		File file = new File("D:/temp4");
		if(file.exists() == false) {file.mkdir();}
		
		File f = null; // File은 autoclosable 기능이 없다.
		FileWriter fw = null;
		ArrayList<String> array = null;
		
		try {
			f = new File("D:/temp4/phone.txt");
			fw = new FileWriter(f);
			array = new ArrayList<>();
			
			System.out.println("이름과 전화번호를 입력하는 프로그램입니다.");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = null;
			// BufferedReader로 입력받은 데이터를 Array에 저장하는 방법
//			while((s=br.readLine()) != null) {
//				array.add(s);
//			}
//			for(int i=0;i<array.size();i++) {
//				System.out.println(array.get(i));
//			}
			while(true) {
				System.out.print("이름 전화번호 >>");
				String str = br.readLine();
				if(str.equals("그만")) {
					break;
				}
				fw.write(str+"\n");
			}
			
			
			
			fw.close();
			br.close();
			
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

}
