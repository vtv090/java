package de.uni_hannover.hci.shape;

public class Circle extends Shape{
	public Circle(int w, int h, String c){
		super(w, h, c);
	}
	
	public String toString(){
		return "Rectangle has width " + this.getWidth() + " and height " + this.getHeight() + " with color " + this.getColor();
	}

}