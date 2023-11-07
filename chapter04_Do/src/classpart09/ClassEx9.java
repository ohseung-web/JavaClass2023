package classpart09;

import java.util.Random;

public class ClassEx9 {

	int sum =0;
	double avg = 0;
	int maxScore = 0;
	
	public ClassEx9() {}

	public void test(int[] x) {
		Random ran = new Random();
		System.out.print("[");
		for(int i=0; i<x.length; i++) {
			x[i] = ran.nextInt(100)+1;
			System.out.print(x[i]+" ");
		}System.out.print("]");
	}

	public int total(int[] x) {
		for(int i=0; i<x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

	public double avgInfo(int[] x) {
		return sum / x.length; 
	}

	// 1µî
	public int firstPlace(int[] x) {
		
		for(int i=0; i<x.length; i++) {
			if(x[i] > maxScore) {
				maxScore = x[i];
			}
		}
		return maxScore;
	}

	//²Ãµî
	public int lastPlace(int[] x) {
		int minScore = maxScore; 
		for(int i=0; i<x.length; i++) {
			if( minScore > x[i] ) {
				minScore = x[i]; 
			}
		}
		return minScore;
	}
}
