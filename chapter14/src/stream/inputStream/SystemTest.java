package stream.inputStream;

import java.io.IOException;

public class SystemTest {

	public static void main(String[] args) {
        // system.in => 1byte�� �о���δ�.
		System.out.println("���ĺ� �������� ���� ���͸� ��������");
		int i =0;
		try {
			while((i = System.in.read()) != '\n') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 //���ڷ� ���
		//System.out.println(i); //�ƽ�Ű�ڵ�� ���
	}

}
