package shapes;

public class ShapeTest {

	public static void main(String[] args) {
		Shape box =new Rectangle(20,30);
		box.computeArea();
		box.computePerimeter();
		System.out.println(box.toString());
		
		Shape square =new Square(40);
		square.computeArea();
		square.computePerimeter();
		System.out.println(square.toString());
		ShapeDrawer sd=new ShapeDrawer();
		draw(sd, box);
		draw(sd, square);

		Drawable d= new Drawable() {

			@Override
			public void draw(Shape s) {
				if(s instanceof Rectangle) 
					System.out.println("Drawing Rectangle shape using my Drawable");
				if(s instanceof Square)
					System.out.println("Drawing Square shape using my Drawable");
			}
			
		};
		draw(d, square);
		
		draw(new MyDrawable(),square);
	}
	
	public static void draw(Drawable d, Shape s) {
		d.draw(s);
	}
	
	static class MyDrawable implements Drawable{

		@Override
		public void draw(Shape s) {
			if(s instanceof Rectangle) 
				System.out.println("Drawing Rectangle shape using MyDrawable");
			if(s instanceof Square)
				System.out.println("Drawing Square shape using MyDrawable");
			
		}
				
		}

}
