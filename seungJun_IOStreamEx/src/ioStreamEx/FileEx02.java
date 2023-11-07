package ioStreamEx;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileEx02 {

	public static void main(String[] args) {
		File file = new File("D:/temp4/phone.txt");
		int i = 0;
		try(FileReader fr = new FileReader("D:/temp4/phone.txt")){
			System.out.println(file+"을 출력합니다.");
			while((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

}

