package fruit;

public class FruitTest {

	public static void main(String[] args) {
		
		Box<Fruit> fruitbox = new Box<>();
		Box<Apple> applebox = new Box<>();
		Box<Grape> grapebox = new Box<>();
	//	Box<Toy> toybox = new Box<>();
						
		fruitbox.add(new Fruit());
		fruitbox.add(new Apple());
		fruitbox.add(new Grape());
		
		applebox.add(new Apple());
		applebox.add(new Apple());
		
		grapebox.add(new Grape());
		
		
		System.out.println(fruitbox);
		System.out.println(applebox);
		System.out.println(grapebox);
	}

}
