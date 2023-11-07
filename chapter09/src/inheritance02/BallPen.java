package inheritance02;

public class BallPen extends ShapPencil {

    String color = "black";  	
	public BallPen() {}

	@Override
	public void Pencilinfo() {
		super.Residual =25;
		super.thickness =2;
		super.name ="BallPen";
		System.out.println(name+" : ÀÜ¿©·® : "+Residual+", ±½±â :"+thickness+"»ö»ó : "+color);
	}
	
	
	
}
