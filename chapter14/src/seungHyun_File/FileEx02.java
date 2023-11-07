package seungHyun_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.IIOException;

public class FileEx02 {

	public static void main(String[] args) {
      
		File file = new File("D:/temp4/phone.txt");
		
	  try(FileReader fr = new FileReader(file);
		  BufferedReader br = new BufferedReader(fr)){
		  
		  System.out.println(file.getPath()+"를 출력합니다.");
		  String str = null;
		  // BufferedReader로 (i=br.read()) != -1는 정수로 출력됨으로 한줄 문자를 출력할때는 적합하지 않다
		  while((str = br.readLine()) != null) {
			  System.out.println(str);
		  }
		  
	  }catch(IOException e) {
		  System.out.println(e);
	  }
	}
}
