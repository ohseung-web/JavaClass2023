package outputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.WriteAbortedException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		
		byte[] bs = new byte[26];
		byte data = 65;
		for(int i=0; i<bs.length; i++) {
			bs[i] = data++;
		}
		
		try(FileOutputStream fos = new FileOutputStream("output3.txt")) {
			fos.write(bs,2,10); // write(byte b[ ], int off, int len)
		}catch(IOException e) {
			System.out.println(e);
		}
		//write�� �ܼ�â�� �ƹ��͵� ��µ��� �����Ƿ� ���ÿ����� ������ش�.
        System.out.println("end");
        
	}

	
	// ����Ҷ��� ������ �������� ������ �ڵ����� ������ �������ش�.
			// FileOutputStream("output.txt") : ��µ� ������ �����Ͱ� override�� �ȴ�.
			// FileOutputStream("output.txt",true) :Override�� ���� �ʰ� �����Ͽ� �����͸� ����ϰ��� �Ҷ�
			// FileOutputStream("output.txt",false) : ����Ʈ
}
