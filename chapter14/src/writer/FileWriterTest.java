package writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {

		try(FileWriter fw = new FileWriter("writer.txt")){
			fw.write("A"); //문자 하나 출력
			char[] ch = {'B','C','D'};
	 		fw.write(ch); // 문자배열 출력
			fw.write("안녕하세요"); //문자열 출력
			fw.write(ch, 1, 2);//문자배열의 일부 출력
			fw.write("123");// 숫자를 그대로 출력
			
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("end");
	}

}
