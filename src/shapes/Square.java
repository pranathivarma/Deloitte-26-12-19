package shapes;

public class Square extends Shape {

	public Square(double len) {
		super(len);
		
	}

	@Override
	public void computeArea() {
		System.out.println("area="+length*length);

	}

	@Override
	public void computePerimeter() {
		System.out.println("perimeter"+4*length);

	}
	@Override
	public String toString() {
		return "this is a square";
	}

}
