package stream.inputStream;

import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {

		// FileNotFoundException이 IOException의 하위 클래스이다.
		// 그러므로 IOException 하나만 catch 구문으로 입력한다.
		// FileInputStream은 바이트 단위로 읽기때문에 한글일 입력하면 모두 깨진다.
		//FileInputStream file = null; // 바이트 스트림

		// FileReader : 파일로 부터 읽어들인다는 뜻
		FileReader file = null; //한글을 읽을 때 사용하는 문자 스트림이다.
		int i = 0;

		try {

			file = new FileReader("input.txt");//FileNotFoundException

			while((i = file.read()) != -1) {
				System.out.print((char)i); //IOException
			}

			//	file.close();

		}catch(IOException e) {
			System.out.println(e);
		}
		finally { 
			try {
				file.close();
			} catch (IOException e) {
				System.out.println(e);
			}// NullPointerException catch구문을 주지않으면 
			//file의 null Exception을 읽어들이지 못해 시스템이 멈춘다.
			// 모든 Exception을 다 지정 할 수 없을 떄는 Exception으로 지정해도 무방하다.
			catch(NullPointerException e) { 
				System.out.println(e);
			}
		}
		System.out.println("end");
	}

}
