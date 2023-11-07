package inheritance02;

public class Main {

	public static void main(String[] args) {

		ShapPencil pencil1 = new ShapPencil();
		ShapPencil  pencil2 = new BallPen();
		ShapPencil  pencil3= new FounctionPen();

		pencil1.Pencilinfo();
		pencil2.Pencilinfo();
		pencil3.Pencilinfo();
	}

}
