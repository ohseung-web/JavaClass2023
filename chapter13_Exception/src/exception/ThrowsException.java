package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

	// throws : 예외던지기, 예외미루기
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}

	public static void main(String[] args) {

		ThrowsException ex = new ThrowsException();
		try {
			ex.loadClass("c.txt", "java.lang.string");
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			String msg = e.getMessage();
			System.out.println("Exception :"+msg);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} 
		// 어떤 에외처리를 해야 할지 모를때 디폴트인 Exception으로 작성한다.
		// 단, 맨 앞에올 수 없다.
		// 이유는 Exception은 최상위 Exception이기때문에 다른 예외처리가 작동을 하지 않는다.
		catch(Exception e) { 
			System.out.println(e);
		}
        System.out.println("end");
	}
}
