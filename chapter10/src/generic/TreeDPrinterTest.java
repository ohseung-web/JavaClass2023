package generic;

public class TreeDPrinterTest {

	public static void main(String[] args) {
		
          TreeDPrinter<Powder> printerpowder = new TreeDPrinter<Powder>();
         // printerpowder.setMaterial(new Powder());  
         // Powder powder =printerpowder.getMaterial();
          //System.out.println(printerpowder);
          
          TreeDPrinter<Material> printerMaterial = new TreeDPrinter<Material>();
        //  printerplastic.setMaterial(new Plastic());  
        //  Plastic plastic = printerplastic.getMaterial();
          //System.out.println(printerplastic);
         
       /*
          TreeDPrinter<Water>  printwater = new TreeDPrinter<Water>();
          printwater.setMaterial(new Water());
          Water water = printwater.getMaterial();
          System.out.println(printwater);
       */
         // printerplastic.printing();
         // printerpowder.printing();
          
           
          printerpowder.add(new Powder());
          printerMaterial.add(new Plastic());
          printerMaterial.add(new Powder());
          
          System.out.println(printerMaterial);
       //   System.out.println(printerplastic);
	}

}
