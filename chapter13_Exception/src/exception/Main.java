package exception;

public class Main {

	Integer x;
	public static void main(String[] args) {
		
		try {
			Class clazz = Class.forName("java.lang.String2");
			//ClassNotFoundException �߻�.

			// ���� catch �߻����� ����
			Main main = new Main();
			System.out.println(main.x + 1);
			// NullPointerException �߻�
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException �߻�");
			e.printStackTrace();
			// Error ���� Ʈ���̽� ����.
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("NullPointerException �߻�");
		} finally {
			System.out.println("HelloWorld");
			// HelloWorld ���.
		}
	}
}

