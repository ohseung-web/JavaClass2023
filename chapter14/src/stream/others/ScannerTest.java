package stream.others;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�̸�");
		String name = scan.nextLine();
		System.out.println("����");
		String job = scan.next();
		System.out.println("���");
		int num = scan.nextInt();
		
		System.out.println(name);
		System.out.println(job);
		System.out.println(num);
		
	}

}
