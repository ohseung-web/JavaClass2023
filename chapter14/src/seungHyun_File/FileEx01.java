package seungHyun_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEx01 {

	public static void main(String[] args) {
        //������ �������� ������ �����ϴ� �ڵ�
	    File file = new File("D:/temp4");
	    if(file.exists()==false) {file.mkdir();}
		
	    //File Ŭ������ AutoCloseable ��� �Ұ�
	   // File f = null;
	   // FileWriter fw = null;
	    try {
	    	
	    	File f = new File("D:/temp4/phone.txt");
	    	FileWriter fw = new FileWriter(f,true);
	    	System.out.println("��ȭ��ȣ �Է� ���α׷� �Դϴ�.");
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    	while(true) {
	    		System.out.print("�̸� ��ȭ��ȣ >>");
		    	String s = br.readLine();
		    	if(s.equals("�׸�")) {break;}
		    	fw.write(s+"\n");
	    	}
	    	 System.out.println(f.getPath()+"���� �Ͽ����ϴ�.");
	    	 fw.close();
	    	 br.close();
	    	
	    }catch(IOException e) {
	    	System.out.println(e);
	    }
	}
}
