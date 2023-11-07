package seungHyun_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileEx04_anthor {

	public static void main(String[] args) {

		File file = null;
		FileReader fr = null;
		HashMap<String, String> phoneMap = null;
		BufferedReader br = null;

		try {
			phoneMap = new HashMap<>();
			file = new File("D:/temp4/phone.txt");
			//	fr = new FileReader(file);
			br = new BufferedReader(new FileReader(file));

			String str = null;
			while((str = br.readLine()) != null) {
				StringTokenizer	st = new StringTokenizer(str);
				String name = st.nextToken();
				String tel = st.nextToken();
				phoneMap.put(name, tel);
				System.out.println("key:"+name+" value:"+phoneMap.get(name));
			}
			System.out.println("�� "+phoneMap.size()+"���� ��ȭ��ȣ�� �о����ϴ�.");
			br.close();

			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.print("�̸�>>");
				String name2=br.readLine();
				System.out.println(name2);
				if(name2.equals("�׸�")) {
					break;
				}
				String tel2=phoneMap.get(name2);
				if(tel2==null) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}
				else {
					System.out.println(tel2);
				}
			}
			br.close();

		}catch(IOException e) {
			System.out.println(e);
		}

	}

}
