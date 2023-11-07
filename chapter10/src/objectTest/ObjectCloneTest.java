package objectTest;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "X : "+ x + ", Y : " + y;
	}
}
	
	class Circle implements Cloneable{
		Point point;
		private int radius;
		
		public Circle(int x, int y, int radius) {
			point = new Point(x, y);
			this.radius = radius;
		}
		public String toString() {
			return "원점은 :"+ this.point +"이고, 반지름은 :"+ this.radius + "입니다.";
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}


public class ObjectCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
         Circle circle = new Circle(10,20,5);
         //강제로 다운캐스팅한다.
         Circle circleclone = (Circle)circle.clone();
         
         System.out.println(System.identityHashCode(circle));
         System.out.println(System.identityHashCode(circleclone));
         
         System.out.println(circle);
         System.out.println(circleclone);
	}

}
