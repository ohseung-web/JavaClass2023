package inheritance02;

public class VIPCustomer extends Customer{
 private int agentID;
 double salePoint;
 
 //������
 public VIPCustomer(int customerID, String customerName ) {
	 customerGrade ="VIP";
	 bonusRatio =0.05;
	 salePoint = 0.1;
	 System.out.println("VIPcustomer() ȣ��");
 }
 
 //�޼���
 @Override
 public int calcprice(int price) {
	 bounsPoint += 	price * bonusRatio;
	 return price - (int)(price*salePoint);
 }
 
 public int getAgentID() {
	 return agentID;
 }
}
