package chapter03;

public class ClassEx04 {

	public static void main(String[] args) {
		Ex03 ex = new Ex03();
		int tot = 0;
		for(int i=0;i<ex.arr.length;i++) {
			tot += ex.arr[i];
		}
		System.out.println("¹è¿­ÀÇ ÃÑÇÕ :"+tot);
	}

}
