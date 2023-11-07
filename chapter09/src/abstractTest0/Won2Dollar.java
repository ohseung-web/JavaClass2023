package abstractTest0;

public class Won2Dollar extends Converter {

	public Won2Dollar(double ratio) {
		this.ratio = ratio;
	}

	protected double convert(double src) {
		return src/ratio;
	}

	protected String getSrcString() {
		return "¿ø";

	}
	protected String getDestString() {
		return "´Þ·¯";
	}


}
