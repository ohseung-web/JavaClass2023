package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEx01 {

	public static void main(String[] args) {

		 File file = new File("D:/temp4");
		 if(file.exists()==false) { file.mkdir();}
		 
		 File f=null; //AutoCloseable를 지원하지 않음
		 FileWriter fw=null;
		 
		Scanner scan=new Scanner(System.in);
		System.out.println("전화번호 입력 프로그램입니다.");
		String temp="";

		try {
			f=new File("D:\\temp4\\phone.txt");
			fw=new FileWriter(f);
						
			while(true) {
				System.out.print("이름 전화번호 >> ");
				temp=scan.nextLine();
				if(temp.equals("그만")) {
					break;
				}
				
				fw.write(temp+"\n");
			}
			scan.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println(f.getPath()+"에 저장하였습니다.");
	}

}
