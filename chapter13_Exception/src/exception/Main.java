package exception;

public class Main {

	Integer x;
	public static void main(String[] args) {
		
		try {
			Class clazz = Class.forName("java.lang.String2");
			//ClassNotFoundException 발생.

			// 다중 catch 발생하지 않음
			Main main = new Main();
			System.out.println(main.x + 1);
			// NullPointerException 발생
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException 발생");
			e.printStackTrace();
			// Error 스택 트레이스 찍음.
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("NullPointerException 발생");
		} finally {
			System.out.println("HelloWorld");
			// HelloWorld 출력.
		}
	}
}

