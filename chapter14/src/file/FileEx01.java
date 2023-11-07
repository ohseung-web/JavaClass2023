package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEx01 {

	public static void main(String[] args) {

		 File file = new File("D:/temp4");
		 if(file.exists()==false) { file.mkdir();}
		 
		 File f=null; //AutoCloseable�� �������� ����
		 FileWriter fw=null;
		 
		Scanner scan=new Scanner(System.in);
		System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�.");
		String temp="";

		try {
			f=new File("D:\\temp4\\phone.txt");
			fw=new FileWriter(f);
						
			while(true) {
				System.out.print("�̸� ��ȭ��ȣ >> ");
				temp=scan.nextLine();
				if(temp.equals("�׸�")) {
					break;
				}
				
				fw.write(temp+"\n");
			}
			scan.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println(f.getPath()+"�� �����Ͽ����ϴ�.");
	}

}
