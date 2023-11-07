package collection.ArrayList;

import java.util.HashSet;

public class HashTest {

	public static void main(String[] args) {
         HashSet<String>  set = new HashSet<>();
         
      boolean b1 =   set.add("aaa");
      System.out.println(b1);
         set.add("bbb");
         set.add("ccc");
         
         System.out.println(set);
         
        boolean b = set.add("aaa"); // 중복을 허용하지 않아서 같은 데이터는 입력되지 않는다.
        System.out.println(b);
         System.out.println(set);
         
	}

}
