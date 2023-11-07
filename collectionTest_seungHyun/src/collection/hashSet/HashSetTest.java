package collection.hashSet;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		HashSet<String>  hset = new HashSet<>();
		hset.add("aaa");
		hset.add("bbb");
		hset.add("ccc");
		System.out.println(hset);
		
		hset.add("aaa");
		System.out.println(hset);
	}

}
