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
			return "������ :"+ this.point +"�̰�, �������� :"+ this.radius + "�Դϴ�.";
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}


public class ObjectCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
         Circle circle = new Circle(10,20,5);
         //������ �ٿ�ĳ�����Ѵ�.
         Circle circleclone = (Circle)circle.clone();
         
         System.out.println(System.identityHashCode(circle));
         System.out.println(System.identityHashCode(circleclone));
         
         System.out.println(circle);
         System.out.println(circleclone);
	}

}
