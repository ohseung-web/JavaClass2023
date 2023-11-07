package lambda;

import javax.swing.text.StringContent;

public class TestStringConcat {

	public static void main(String[] args) {
		StringConcatImpl sc = new StringConcatImpl();
		sc.makeStirng("hello", "java");
		
		//람다식
		//구현부
		StringConcat concat = (s1,s2)->System.out.println(s1+" "+s2);
		//호출부
		concat.makeStirng("hello", "java");
	
		StringConcat concat2 = new StringConcat() {
			
			@Override
			public void makeStirng(String s1, String s2) {
			System.out.println(s1+" "+s2);
				
			}
		};
		concat2.makeStirng("hello ", "java");
	}

}
