package lambdaEx;

public class LambdaEx01 {

	public int max(int a, int b) { 
		return a>b?a:b;
	}
	
	public void printVar(String name, int i) {
		System.out.println(name+"="+i);
	}
	
	public int square(int x) {
		return x*x;
	}
	
	public int roll() {
	  return (int) (Math.random()*6);
	}
	
}
