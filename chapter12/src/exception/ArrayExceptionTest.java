package exception;

public class ArrayExceptionTest {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		try {
		   // try���� �ڵ尡 ����Ǵ� ���� ������ �߻��Ѵٸ�
		   for(int i=0; i<=5; i++) {
			  System.out.println(arr[i]);
		   }
		}catch(ArrayIndexOutOfBoundsException e) {
			// catch ���������� ���Ͷ�
			System.out.println(e);
			return;
		}finally {
			// try ������ ������ �Ǹ� ����� ������ ����Ǵ� �����̴�.
			System.out.println("finally");
		}
		System.out.println("end");
	}

}
