package inheritance3;

public class ColorTV  extends TV{
	
	 protected int resolution; //�÷�
	   
	   public ColorTV() {}
	   public ColorTV(int size, int resolution) {
	     // super(size);
	      size = size;
	      this.resolution = resolution;
	   }
	   public void printProperty() {
	      System.out.print(size+"��ġ "+resolution+"�÷�");
	   }
}
