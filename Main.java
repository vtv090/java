/*
 * @author Van Trung Vo _ 10014921
  */
package de.uni_hannover.hci.shape;

import java.util.*;

public class Main{
	public static void main(String[] args){
		List<Shape> ls = new ArrayList<Shape>();
		List<Shape> sortedls = new ArrayList<Shape>();
		
		ls.add(new Circle(4, 5, "rot"));
		ls.add(new Circle(2, 4, "blue"));
		ls.add(new Circle(3, 4, "white"));
		ls.add(new Circle(1, 6, "green"));
		ls.add(new Circle(3, 2, "black"));
		System.out.println(ls);
		
		sortedls = MergeSort.mergeSort(ls);
		System.out.print("Sorted List: ");
		for(int i = 0; i < sortedls.size(); i++) {
			System.out.print("(" + sortedls.get(i).getWidth() + "," + sortedls.get(i).getHeight() + " with color " + sortedls.get(i).getColor() + ")");
		}
	}
}