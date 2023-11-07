package seungHyun_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx03 {

	public static void main(String[] args) {
        // ���Ϻ���  10% * �ϳ� ���
		File f1 = new File("D:/temp4/spring.jpg");
		File f2 = new File("D:/temp4/scopy.jpg");
		
		try(FileInputStream fis = new FileInputStream(f1);
			FileOutputStream fos = new FileOutputStream(f2);
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			System.out.println(f1.getName()+"�� "+f2.getName()+"�� �����մϴ�.");
			System.out.println("10%���� *�� ����մϴ�.");
			
            int i= 0;
            int len = 0; //����Ʈ 
            long tot = f1.length(); //length()�� ����ũ�⸦ �����ϴ� File�� �޼���
            while((i=bis.read()) != -1) {
            	bos.write(i);
            	len++;
            	
            	if(len == tot/10) {
            		System.out.print("*");
            		len = 0;
            	}
            }
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
