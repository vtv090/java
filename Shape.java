package de.uni_hannover.hci.shape;

public class Shape{
	private int width;
	private int height;
	private String color;
	
	public Shape(int w, int h, String c){
		this.width = w;
		this.height = h;
		this.color = c;
	}
	
	public int getArea(){
		return width * height;
	}
	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setHeight(int h){
		this.height = h;
	}
	
	public void setWidth(int w){
		this.width = w;
	}
	
	public void setColor(String c){
		this.color = c;
	}
	
	public int compareTo(Shape s){
		return this.getArea() - s.getArea();
	}
	
	public int compareToHeight(Shape s1) {
		return this.getHeight() - s1.getHeight();
	}
}
