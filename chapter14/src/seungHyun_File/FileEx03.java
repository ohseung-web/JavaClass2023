package seungHyun_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx03 {

	public static void main(String[] args) {
        // 파일복사  10% * 하나 출력
		File f1 = new File("D:/temp4/spring.jpg");
		File f2 = new File("D:/temp4/scopy.jpg");
		
		try(FileInputStream fis = new FileInputStream(f1);
			FileOutputStream fos = new FileOutputStream(f2);
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			System.out.println(f1.getName()+"를 "+f2.getName()+"로 복사합니다.");
			System.out.println("10%마다 *를 출력합니다.");
			
            int i= 0;
            int len = 0; //바이트 
            long tot = f1.length(); //length()는 파일크기를 리턴하는 File의 메서드
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
