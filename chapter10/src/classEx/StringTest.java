package classEx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringTest {

	public static void main(String[] args) throws ClassNotFoundException {
        
		Class strClass = Class.forName("java.lang.String");
		Constructor[] cons = strClass.getConstructors();
		
		// java.lang.String의 constructor 의 정보를 가져온다.
		for(int i=0; i<cons.length; i++) {
			System.out.println(cons[i]);
		}
		System.out.println("======================");
		// Ctrl + Shift + O : import 메뉴
		Field[]  fields =  strClass.getFields();
		for(Field f : fields) {
			System.out.println(f);
		}
		// java.lang.String의 Method 의 정보를 가져온다.
		System.out.println("======================");
		Method[] methods = strClass.getMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
		
	}

}
