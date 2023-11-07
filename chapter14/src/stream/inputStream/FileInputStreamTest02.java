package stream.inputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest02 {

	public static void main(String[] args) {

		try( FileInputStream files = new FileInputStream("input2.txt") ){
			
			byte[] bs = new byte[10]; // 읽은 자료의 바이트수를 반환한다.
			int i; // 읽어들인 개수 저장됨
			while( (i=files.read(bs)) != -1) {
				// 버퍼를 통째로 출력 
				for(byte b : bs) {
					System.out.print((char)b);
				}System.out.println();
			   
				// 읽어들인 개수만큼만 출력
			//	for(int j=0; j<i; j++) {
			//		System.out.print((char)bs[j]);
			//	}System.out.println(": "+ i+"바이트 읽음");
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("end");
	}

}

