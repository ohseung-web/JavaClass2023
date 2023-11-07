package seungHyun_File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileEx04 {

	private String fileName = "D:/temp4/phone.txt";
	private HashMap<String, String> phoneMap = new HashMap<>(); 
	private BufferedReader br = null;
	public FileEx04() {}

	// phone.txt ������ �ڷḦ �о���̴� �޼���
	public void readPhone() {

		File file = null;
		FileReader fr = null;

		try {
			phoneMap = new HashMap<>();
			file = new File(fileName);
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
		}catch(IOException e) {
			System.out.println(e);
		}
	}

	// �о���� phone.txt�� �ڷḦ ���ǿ� �����ϴ� �����͸� ����ϴ� �޼���
	public void phoneAcess() {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.print("�̸�>>");
				String name2=br.readLine();
				System.out.println(name2);
				if(name2.equals("�׸�")) {break;}
				String tel2=phoneMap.get(name2);
				if(tel2==null) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}else {System.out.println(tel2);}
			}
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}		

	// ����޼���
	public void run() {
		readPhone();
	    phoneAcess();
	}

	public static void main(String[] args) {

		FileEx04 f04 = new FileEx04();
		f04.run();
	}

}
