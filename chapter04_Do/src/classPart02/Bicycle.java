package classPart02;

public class Bicycle {
   String color;
   int price;
   
   public Bicycle() {
	   System.out.println("-----  Bicycle  Consturctor-I -----");
   }
   public Bicycle(String c, int p) {
	   System.out.println("-----  Bicycle  Consturctor-II -----");
	   color = c;
	   price = p;
   }
   
   public void info() {
	   System.out.println("---  info ---");
	   System.out.println("color : "+ color);
	   System.out.println("price :" + price);
   }
   
}
