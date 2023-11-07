package arrayEx01;

public class ArrayTest01 {

	public static void main(String[] args) {
		double[] data = new double[5];
         
		 int size = 0;
		 int total = 1;
		data[0] =10.0; size ++ ;
		data[1] =20.0; size ++ ;
		data[2] =30.0; size ++ ;
		
		for(int i=0 ; i<size; i++) {
			total *= data[i];
		}
		
		System.out.println("total °ª :" + total);
	}

}
