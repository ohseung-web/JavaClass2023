package classpart13;

public class MainClass {

	public static void main(String[] args) {
		Card c1 = new Card();
		c1.number = 4;
		c1.shape = "heart";
		
		Card c2 = new Card();
		c2.number = 7;
		c2.shape = "spade";
		
		c1.width = 300;
		c1.height = 150;
		
		System.out.println(Card.width);		// 300
		System.out.println(Card.height);	// 150

        System.out.println(c1.width);		// 300
		System.out.println(c1.height);	// 150

        System.out.println(c2.width);		// 300
		System.out.println(c2.height);	// 150
	}

}
