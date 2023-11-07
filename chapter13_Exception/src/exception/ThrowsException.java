package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

	// throws : ���ܴ�����, ���̷ܹ��
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
		// � ����ó���� �ؾ� ���� �𸦶� ����Ʈ�� Exception���� �ۼ��Ѵ�.
		// ��, �� �տ��� �� ����.
		// ������ Exception�� �ֻ��� Exception�̱⶧���� �ٸ� ����ó���� �۵��� ���� �ʴ´�.
		catch(Exception e) { 
			System.out.println(e);
		}
        System.out.println("end");
	}
}
