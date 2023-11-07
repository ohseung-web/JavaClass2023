package decorater;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInoutStreamTest {

	public static void main(String[] args) {

		// 자료형이 보존되는 스트림 DataInputStream, DataoutputStream 이다.
		try(FileOutputStream fos = new FileOutputStream("data.txt");
			DataOutputStream dos = new DataOutputStream(fos)){
			dos.write(100);
			dos.writeInt(10);
			dos.writeChar('A');
			dos.writeUTF("hello");
		}catch(IOException  e) {
			System.out.println(e);
		}
		
		// 데이타를 자료형에 만족하게 저장하고 읽어 들인다.
		try(FileInputStream fis = new FileInputStream("data.txt");
				DataInputStream dis = new DataInputStream(fis)){
			System.out.println(dis.read());
			System.out.println(dis.readInt());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			}catch(IOException  e) {
				System.out.println(e);
			}
	}

}
