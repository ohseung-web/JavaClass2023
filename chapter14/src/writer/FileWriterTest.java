package writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {

		try(FileWriter fw = new FileWriter("writer.txt")){
			fw.write("A"); //���� �ϳ� ���
			char[] ch = {'B','C','D'};
	 		fw.write(ch); // ���ڹ迭 ���
			fw.write("�ȳ��ϼ���"); //���ڿ� ���
			fw.write(ch, 1, 2);//���ڹ迭�� �Ϻ� ���
			fw.write("123");// ���ڸ� �״�� ���
			
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("end");
	}

}
