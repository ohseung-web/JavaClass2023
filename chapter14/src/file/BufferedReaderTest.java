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
		System.out.println("�ڷḦ �Է��ϼ���");
		// StringTokenizer �̿�
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken(".");
		// BufferedReader�� readLine() �̿�
	//	String s2 = br.readLine(); // readLIne() String ������ ����
	//	int num = br.read(); // ������ ����
		milliseconds = (System.currentTimeMillis()-milliseconds)/1000;
		System.out.println(s1);
		System.out.println("������ �о���̴� �ð� : "+milliseconds+"��");
	     
		
	//	int num = br.read(); // ������ ����
	//	System.out.println("br.read()"+num);
		
		System.out.println("=======================");
		Scanner scan = new Scanner(System.in);
		long milliseconds1 = System.currentTimeMillis();
		System.out.println("�ڷḦ �Է��ϼ���");
		String st1 = scan.nextLine();
		milliseconds1 = (System.currentTimeMillis()-milliseconds1)/1000;
		System.out.println(st1);
		System.out.println("������ �о���̴� �ð� : "+milliseconds1+"��");
		
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int num1 = Integer.parseInt(st.nextToken());
//		int num2 = Integer.parseInt(st.nextToken());
		
	//	System.out.println("������ �о���̴� �ð� : "+milliseconds);
	//	
	}

}
