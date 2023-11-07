package exception;

public class ArrayExceptionTest {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		try {
		   // try안의 코드가 수행되는 동안 오류가 발생한다면
		   for(int i=0; i<=5; i++) {
			  System.out.println(arr[i]);
		   }
		}catch(ArrayIndexOutOfBoundsException e) {
			// catch 구문안으로 들어와라
			System.out.println(e);
			return;
		}finally {
			// try 구문이 수행이 되면 어떤경우라도 무조건 수행되는 구문이다.
			System.out.println("finally");
		}
		System.out.println("end");
	}

}
