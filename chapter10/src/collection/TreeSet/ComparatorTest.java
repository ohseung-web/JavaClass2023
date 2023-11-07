package collection.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String st1, String st2) {
		return st1.compareTo(st2)*(-1) ;
	}
	
}

public class ComparatorTest {

	public static void main(String[] args) {
		
		TreeSet<String>  tree = new TreeSet<>(new MyComparator());
		
        tree.add("aaa");
        tree.add("bbb");
        tree.add("ccc");
        
        System.out.println(tree);

	}

}
