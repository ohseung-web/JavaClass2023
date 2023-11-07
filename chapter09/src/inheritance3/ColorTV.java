package inheritance3;

public class ColorTV  extends TV{
	
	 protected int resolution; //컬러
	   
	   public ColorTV() {}
	   public ColorTV(int size, int resolution) {
	     // super(size);
	      size = size;
	      this.resolution = resolution;
	   }
	   public void printProperty() {
	      System.out.print(size+"인치 "+resolution+"컬러");
	   }
}
