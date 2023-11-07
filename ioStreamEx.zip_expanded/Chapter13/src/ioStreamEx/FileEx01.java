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
		
		File f = null; // File�� autoclosable ����� ����.
		FileWriter fw = null;
		ArrayList<String> array = null;
		
		try {
			f = new File("D:/temp4/phone.txt");
			fw = new FileWriter(f);
			array = new ArrayList<>();
			
			System.out.println("�̸��� ��ȭ��ȣ�� �Է��ϴ� ���α׷��Դϴ�.");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = null;
			// BufferedReader�� �Է¹��� �����͸� Array�� �����ϴ� ���
//			while((s=br.readLine()) != null) {
//				array.add(s);
//			}
//			for(int i=0;i<array.size();i++) {
//				System.out.println(array.get(i));
//			}
			while(true) {
				System.out.print("�̸� ��ȭ��ȣ >>");
				String str = br.readLine();
				if(str.equals("�׸�")) {
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
