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
				ex.loadClass("b.txt", "java.lang.string");
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
	        System.out.println("end");

		}

}
