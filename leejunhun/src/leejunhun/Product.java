package leejunhun;
import java.text.*;
public class Product {
	public int productNumber;
	public String seller;
	public String primaryType;
	public String secondaryType;
	public String name;
	public int price;
	public int vailidity;
	
	public Product() {}
	public Product(int productNumber, String seller, String primaryType, String secondaryType,
			String name, int price) {
		this.productNumber = productNumber;
		this.seller = seller;
		this.primaryType = primaryType;
		this.secondaryType = secondaryType;
		this.name = name;
		this.price = price;
		this.vailidity = 1;
	}
	// TODO 출력문 개선은 여기서
	public String printProductInfo()	{ 
		DecimalFormat df = new DecimalFormat("#,##0");
		
		String str = "";
		str += seller;
		if(seller.length()<5) {
			str += "     ";
		}else {
			str += "  ";
		}
		str += primaryType;
		if(primaryType.length() < 4)	{
			str += "     ";
		}else {
			str += "   ";
		}
		str += secondaryType;
		if(primaryType.length() < 4)	{
			str += "     ";
		}else {
			str += "   ";
		}
		str += name;
		str += "      " + df.format(price);
		return str;
	}
	
}
