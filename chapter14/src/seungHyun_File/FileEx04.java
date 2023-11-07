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

	// phone.txt 파일의 자료를 읽어들이는 메서드
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
			System.out.println("총 "+phoneMap.size()+"개의 전화번호를 읽었습니다.");
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}

	// 읽어들인 phone.txt의 자료를 조건에 만족하는 데이터만 출력하는 메서드
	public void phoneAcess() {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.print("이름>>");
				String name2=br.readLine();
				System.out.println(name2);
				if(name2.equals("그만")) {break;}
				String tel2=phoneMap.get(name2);
				if(tel2==null) {
					System.out.println("찾는 이름이 없습니다.");
				}else {System.out.println(tel2);}
			}
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}		

	// 실행메서드
	public void run() {
		readPhone();
	    phoneAcess();
	}

	public static void main(String[] args) {

		FileEx04 f04 = new FileEx04();
		f04.run();
	}

}
