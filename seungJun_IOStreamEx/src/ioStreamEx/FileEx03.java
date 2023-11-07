package ioStreamEx;

//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx03 {

	public static void main(String[] args) {
		File file = null;
		long len = 0; 
		int i = 0;
		try (FileInputStream fis = new FileInputStream("D:/temp4/spring.jpg");
			 FileOutputStream fos = new FileOutputStream("D:/temp4/copy.jpg"))
			 //BufferedInputStream bis = new BufferedInputStream(fis);
			 //BufferedOutputStream bos = new BufferedOutputStream(fos))
		 	 //�̰� ���� �ʹ� ���� ���� ���� �ӵ��� �� ���δ�..
				{
			file = new File("D:/temp4/spring.jpg");
			System.out.println("spring.jpg�� copy.jpg�� �����մϴ�.");
			System.out.println("10%���� *�� ����մϴ�.");
			while ((i = fis.read()) != -1) {
				fos.write(i);
				len++;
				if(len == (file.length()/10)) {
					System.out.print("*");
					len = 0;
				}
			}

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

}