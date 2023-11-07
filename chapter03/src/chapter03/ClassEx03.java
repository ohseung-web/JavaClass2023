package chapter03;
class Ex03{
	int[] arr = {87, 100, 11, 72, 92};
}
public class ClassEx03 {

	public static void main(String[] args) {
		Ex03 ex = new Ex03();
		int tot = 0;
		for(int i=0;i<ex.arr.length;i++) {
			tot += ex.arr[i];
		}
		System.out.println("¹è¿­ÀÇ ÃÑÇÕ :"+tot);
	}
 
}
