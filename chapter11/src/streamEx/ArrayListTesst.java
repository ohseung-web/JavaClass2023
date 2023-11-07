package streamEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListTesst {

	public static void main(String[] args) {

		List<String> sList = new ArrayList<>();
		Collections.addAll(sList,"Tomas","James","Edward");
		
		Stream<String> stream = sList.stream(); // stream ������ ����
		stream.forEach(s->System.out.println(s));
		System.out.println("========");
		// sList.stream().sorted() => �߰�������
		// forEach(s->System.out.println(s)) => ���ѿ�����
	    sList.stream().sorted().forEach(s->System.out.println(s)); // Asd(��������) �⺻
	    
		
	}

}
