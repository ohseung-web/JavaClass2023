package stream.inputStream;

import java.io.IOException;

public class SystemTest {

	public static void main(String[] args) {
        // system.in => 1byte씩 읽어들인다.
		System.out.println("알파벳 여러개를 쓰고 엔터를 누르세요");
		int i =0;
		try {
			while((i = System.in.read()) != '\n') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 //문자로 출력
		//System.out.println(i); //아스키코드로 출력
	}

}
