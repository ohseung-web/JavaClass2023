package MulitArrrayEx;
import java.util.*;
public class String_Array3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * int a = 5; int b = 7;
		 * 
		 * if (a == b) { System.out.println("true"); } else {
		 * System.out.println("false"); }
		 */
		    //=========================================
		    
		    String a = new String("hongpossible");        
		    String b = new String("hongpossible");
		     
		    // a客 b狼 拱府利 林家 免仿
		    System.out.println(System.identityHashCode(a));
		    System.out.println(System.identityHashCode(b));
		    
		    if(a==b) {
		        System.out.println("a==b");
		    }
		    if(a.equals(b)){
		        System.out.println("a.equals(b) // true");
		    }
		
	}

}
