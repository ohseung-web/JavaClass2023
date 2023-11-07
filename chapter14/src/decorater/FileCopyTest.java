package decorater;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		// 버퍼링 기능을 제공하는 스트림
		// a.exe 파일을 b.exe 파일로 1byte씩 복사
		// System.currentTimeMillis() : 1970년1월1일부터 경과한 시간을 long 값으로 리턴하며
		//                              밀리세컨 1/1000초 값을 리턴한다.
		long millisconds = 0; // 복사 시간체크
		int len = 0; // 바이트 체크
		try(FileInputStream fis = new FileInputStream("KScreenPen.exe"); 
			FileOutputStream fos = new FileOutputStream("scopy.exe");
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
		
			millisconds = System.currentTimeMillis();
			int i= 0;
			while((i=bis.read()) != -1) { // end of 파일의 retrun 값은 -1 이다.
				bos.write(i);
				len++;
			}
					
			millisconds = (System.currentTimeMillis() - millisconds)/1000;
		}catch(IOException e) {
			System.out.println(e);
		}
         System.out.println("바이트 :"+len);
         System.out.println("복사 실행시간 :"+millisconds+"초");
	}

}
