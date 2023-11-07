package lambda;

public class Cal {

	int num3;
	int total;
	int cal;
	
	
	public Cal() {}
	public Cal(int num3) {
		this.num3 = num3;
	}
	
	public SeungInterface Show() {
		return (int n1, int n2) -> System.out.println( n1 >= n2? n1:n2);
	}
}
