package stream.inputStream;

import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {

		// FileNotFoundException�� IOException�� ���� Ŭ�����̴�.
		// �׷��Ƿ� IOException �ϳ��� catch �������� �Է��Ѵ�.
		// FileInputStream�� ����Ʈ ������ �б⶧���� �ѱ��� �Է��ϸ� ��� ������.
		//FileInputStream file = null; // ����Ʈ ��Ʈ��

		// FileReader : ���Ϸ� ���� �о���δٴ� ��
		FileReader file = null; //�ѱ��� ���� �� ����ϴ� ���� ��Ʈ���̴�.
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
			}// NullPointerException catch������ ���������� 
			//file�� null Exception�� �о������ ���� �ý����� �����.
			// ��� Exception�� �� ���� �� �� ���� ���� Exception���� �����ص� �����ϴ�.
			catch(NullPointerException e) { 
				System.out.println(e);
			}
		}
		System.out.println("end");
	}

}
