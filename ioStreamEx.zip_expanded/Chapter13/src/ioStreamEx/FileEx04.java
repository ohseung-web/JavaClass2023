package ioStreamEx;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileEx04 {

	public static void main(String[] args) {
		int i = 0;
		try(FileReader fr = new FileReader("D:/temp4/phone.txt")){
			HashMap<String,String> list = new HashMap<String,String>();
			String str = "";
			while((i = fr.read()) != -1) {
				str += (char)i;
			}
			StringTokenizer st = new StringTokenizer(str);
			
			while(st.hasMoreTokens()) {
				list.put(st.nextToken(),st.nextToken());
			}
			
			for(String keys : list.keySet()) {
				System.out.println("key:"+keys+"value:"+list.get(keys));
			}
			System.out.println("�� "+list.size()+"���� ������ �о����ϴ�.");
			
			while(true) {
				System.out.print("�̸�>>");
				Scanner scan = new Scanner(System.in);
				String name = scan.next();
				if(name.equals("�׸�")) {
					System.out.println("�׸�");
					break;
					}
				else {
					for(String keys : list.keySet()) {
						if(name.equals(keys)) {
							System.out.println(list.get(keys));
						}
					}
				}
				scan.close();
			}
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

}
