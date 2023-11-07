package exception02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exception {

	public static void main(String[] args) {

		try( FileInputStream fis = new FileInputStream("a.txt") ) {
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		System.out.println("end");
	}

	

}
