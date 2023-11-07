package leejunhun;
/*
 
 	public String seller;
	public String primaryType;
	public String secondaryType;
	public String name;
	public int price;
	
 */
public class PurchasedProduct extends Product{
	int amount;
	boolean paied;
	public PurchasedProduct() {}
	
	public PurchasedProduct(Product p, int amount)	{
		super(p.productNumber, p.seller, p.primaryType, p.secondaryType, p.name, p.price);
		this.amount = amount;
		this.paied = false;
		
	}
	
	public PurchasedProduct(Product p, int amount, boolean paied)	{
		super(p.productNumber, p.seller, p.primaryType, p.secondaryType, p.name, p.price);
		this.amount = amount;
		this.paied = paied;
		
	}

	
	public boolean isPaied() {
		return paied;
	}

	public void setPaied(boolean paied) {
		this.paied = paied;
	}

	public String PrintPurchasedInfo() {
		String str = super.printProductInfo();
		if(this.paied == true) {
			str += "\tPayed";
		}else {
			str += "\tNotpayed";
		}
		return str;
	}
	

}
