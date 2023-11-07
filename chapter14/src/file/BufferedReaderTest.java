package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferedReaderTest {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long milliseconds = System.currentTimeMillis();
		System.out.println("자료를 입력하세요");
		// StringTokenizer 이용
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken(".");
		// BufferedReader의 readLine() 이용
	//	String s2 = br.readLine(); // readLIne() String 한줄을 읽음
	//	int num = br.read(); // 정수를 읽음
		milliseconds = (System.currentTimeMillis()-milliseconds)/1000;
		System.out.println(s1);
		System.out.println("데이터 읽어들이는 시간 : "+milliseconds+"초");
	     
		
	//	int num = br.read(); // 정수를 읽음
	//	System.out.println("br.read()"+num);
		
		System.out.println("=======================");
		Scanner scan = new Scanner(System.in);
		long milliseconds1 = System.currentTimeMillis();
		System.out.println("자료를 입력하세요");
		String st1 = scan.nextLine();
		milliseconds1 = (System.currentTimeMillis()-milliseconds1)/1000;
		System.out.println(st1);
		System.out.println("데이터 읽어들이는 시간 : "+milliseconds1+"초");
		
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int num1 = Integer.parseInt(st.nextToken());
//		int num2 = Integer.parseInt(st.nextToken());
		
	//	System.out.println("데이터 읽어들이는 시간 : "+milliseconds);
	//	
	}

}
