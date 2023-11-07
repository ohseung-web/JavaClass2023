package streamEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListTesst {

	public static void main(String[] args) {

		List<String> sList = new ArrayList<>();
		Collections.addAll(sList,"Tomas","James","Edward");
		
		Stream<String> stream = sList.stream(); // stream 변수에 담음
		stream.forEach(s->System.out.println(s));
		System.out.println("========");
		// sList.stream().sorted() => 중간연산자
		// forEach(s->System.out.println(s)) => 최총연산자
	    sList.stream().sorted().forEach(s->System.out.println(s)); // Asd(오름차순) 기본
	    
		
	}

}
