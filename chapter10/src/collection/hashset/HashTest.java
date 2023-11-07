package collection.hashset;

import java.util.HashSet;

public class HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashSet<String>  set = new HashSet<>();
        
      boolean s =  set.add("aaa");
      System.out.println(s);
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);
        
   boolean k=  set.add("aaa");
   System.out.println(k);
        System.out.println(set);
        
	}

}
