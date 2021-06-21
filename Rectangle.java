package VietLai;

public class Rectangle implements Shape{
	private int width;
	private int height;
	
	//constructor of Rectangle
	public Rectangle(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	//get Area of Rectangle from width & height
	public int getArea() {
		return width * height;
	}
	
	//get Height
	public int getHeight() {
		return height;
	}
	
	//set Height
	public void setHeight(int h) {
		this.height = h;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int w) {
		this.width =w;
	}
	
	@Override
	public String toString() {
		return "Rect (" + this.getWidth() + "," + this.getHeight() + ")" ;
	}
	
	public int compareTo(Shape s) {
		return this.getArea() - s.getArea();
	}

	@Override
	public int getRadius() {
		return 0;
	}
}
