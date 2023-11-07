package collection.TreeSet;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String 클래스는 이미 comparable 메서드가 구현되어 있기떄문에 정렬되어 출력됨
           TreeSet<String>  tree = new TreeSet<>();
           tree.add("aaa");
           tree.add("bbb");
           tree.add("ccc");
           System.out.println(tree);
	}

}
