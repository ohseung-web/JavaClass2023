package exception;

public class Main2 {

	Integer x;
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("java.lang.String2");
            //ClassNotFoundException �߻�.

            // ���� catch �߻����� ����
            Main2 main = new Main2();
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
