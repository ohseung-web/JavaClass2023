package objectTest;

public class StringEqualsEx {

	public static void main(String[] args) {
       String str1 = new String("abd");
       String str2 = new String("abd");
       
       System.out.println(str1 == str2);
       System.out.println(str1.equals(str2));
       
       Integer i1 = new Integer(100);
       Integer i2 = new Integer(100);
       
       System.out.println(i1 == i2);
       System.out.println(i1.equals(i2));
	}
}
