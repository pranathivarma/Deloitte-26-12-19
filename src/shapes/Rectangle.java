package shapes;

public class Rectangle extends Shape {

	
	

	public Rectangle(double len, double wid) {
		super(len,wid);
	}

	
	
	@Override
	public void computeArea() {
		System.out.println("area="+length*width);

	}

	@Override
	public void computePerimeter() {
		System.out.println("perimeter="+2*(length+width));
	}
	
	@Override 
	public String toString() {
		return "this is a rectangle";
	}

}
