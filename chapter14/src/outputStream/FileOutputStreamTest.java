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
		//write는 콘솔창에 아무것도 출력되지 않으므로 샘플용으로 출력해준다.
        System.out.println("end");
        
	}

	
	// 출력할때는 파일이 존재하지 않으면 자동으로 파일을 생성해준다.
			// FileOutputStream("output.txt") : 출력된 파일의 데이터가 override가 된다.
			// FileOutputStream("output.txt",true) :Override가 되지 않고 연결하여 데이터를 출력하고자 할때
			// FileOutputStream("output.txt",false) : 디폴트
}
