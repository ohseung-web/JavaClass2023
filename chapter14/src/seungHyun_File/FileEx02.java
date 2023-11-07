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
		  
		  System.out.println(file.getPath()+"�� ����մϴ�.");
		  String str = null;
		  // BufferedReader�� (i=br.read()) != -1�� ������ ��µ����� ���� ���ڸ� ����Ҷ��� �������� �ʴ�
		  while((str = br.readLine()) != null) {
			  System.out.println(str);
		  }
		  
	  }catch(IOException e) {
		  System.out.println(e);
	  }
	}
}
