package inheritance02;

public class FounctionPen extends BallPen {

	
	
	public FounctionPen() {}

	@Override
	public void Pencilinfo() {
		super.Residual =15;
		super.thickness =2;
		super.color = "blue";
		super.name="FounctionPen";
		System.out.println(name+" : ÀÜ¿©·® : "+Residual+", ±½±â :"+thickness+"»ö»ó : "+color);
	}

	

}
