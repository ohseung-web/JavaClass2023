package stream.inputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest02 {

	public static void main(String[] args) {

		try( FileInputStream files = new FileInputStream("input2.txt") ){
			
			byte[] bs = new byte[10]; // ���� �ڷ��� ����Ʈ���� ��ȯ�Ѵ�.
			int i; // �о���� ���� �����
			while( (i=files.read(bs)) != -1) {
				// ���۸� ��°�� ��� 
				for(byte b : bs) {
					System.out.print((char)b);
				}System.out.println();
			   
				// �о���� ������ŭ�� ���
			//	for(int j=0; j<i; j++) {
			//		System.out.print((char)bs[j]);
			//	}System.out.println(": "+ i+"����Ʈ ����");
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("end");
	}

}

