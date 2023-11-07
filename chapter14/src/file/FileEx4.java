package file;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class FileEx4 {

	public static void main(String[] args) {

		File f=null;
		FileReader fr=null;
		HashMap<String,String> phone;
		Scanner sc;
		
		try {
			phone=new HashMap<String,String>();
			f=new File("D:\\temp3\\phone.txt");
			fr=new FileReader(f);
			sc=new Scanner(fr);

			while(sc.hasNext()) {
				String n=sc.next();
				String t=sc.next();
				phone.put(n,t);
				System.out.println("key:"+n+"value:"+phone.get(n));
			}
			System.out.println("�� "+phone.size()+"���� ������ �о����ϴ�.");
			sc.close();
			sc=new Scanner(System.in);
			String temp="";
			while(true) {
				System.out.print("�̸�>>");
				temp=sc.next();
				System.out.println(temp);
				if(temp.equals("�׸�")) {
					break;
				}
				String tel=phone.get(temp);
				if(tel==null) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}
				else {
					System.out.println(tel);
				}
			}
		} catch (Exception e) {
			System.out.println(e);

		}

	}

}