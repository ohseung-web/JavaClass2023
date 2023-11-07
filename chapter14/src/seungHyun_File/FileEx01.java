package seungHyun_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEx01 {

	public static void main(String[] args) {
        //폴더가 존재하지 않으면 생성하는 코드
	    File file = new File("D:/temp4");
	    if(file.exists()==false) {file.mkdir();}
		
	    //File 클래스는 AutoCloseable 사용 불가
	   // File f = null;
	   // FileWriter fw = null;
	    try {
	    	
	    	File f = new File("D:/temp4/phone.txt");
	    	FileWriter fw = new FileWriter(f,true);
	    	System.out.println("전화번호 입력 프로그램 입니다.");
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    	while(true) {
	    		System.out.print("이름 전화번호 >>");
		    	String s = br.readLine();
		    	if(s.equals("그만")) {break;}
		    	fw.write(s+"\n");
	    	}
	    	 System.out.println(f.getPath()+"저장 하였습니다.");
	    	 fw.close();
	    	 br.close();
	    	
	    }catch(IOException e) {
	    	System.out.println(e);
	    }
	}
}
