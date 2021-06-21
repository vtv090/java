package VietLai;

public class Circle implements Shape{
	private int radius;
	
	//constructor
	public Circle(int r) {
		this.radius = r;
	}
	
	//getter
	public int getRadius() {
		return radius;
	}
	
	//setter
	public void setRadius(int r) {
		this.radius = r;
	}
	
	@Override
	public String toString() {
		return "Circle has radius " + this.getRadius();
	}
	
	//Compare to circle
	public int compareTo(Shape s) {
		return this.getRadius() - s.getRadius();
	}

	//Override all of GETTER Methode in Shape but not in Circle
	//if Circle implements Shape
	
	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
