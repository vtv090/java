package VietLai;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Shape> ls = new ArrayList<Shape>();
		
		ls.add(new Rectangle(1, 3));
		ls.add(new Rectangle(2, 2));
		ls.add(new Rectangle(1, 1));
		ls.add(new Rectangle(3, 4));
		ls.add(new Rectangle(2, 5));
		ls.add(new Rectangle(6, 3));
		
		ArrayList<Shape> circle = new  ArrayList<Shape>();
		circle.add(new Circle(2));
		circle.add(new Circle(5));
		circle.add(new Circle(1));
		circle.add(new Circle(7));
		circle.add(new Circle(3));
		circle.add(new Circle(8));
		
		
		for(int i = 0; i < ls.size();i++) {
			System.out.print(ls.get(i) + ",");
		}
		
		System.out.println("\t");
		SelectionSort.slectionSort(ls);
		System.out.println(ls);
		
		
		SelectionSort.slectionSort(circle);
		System.out.println(circle);
		
		
		System.out.println("++++++++++++++++++");
		System.out.println("What surface do you want to search for:");
		Scanner input = new Scanner(System.in);
		int find = input.nextInt();
		for(int i = 0; i < ls.size(); i++) {
			if(ls.get(i).getArea() == find) {
				System.out.println("Found: " + Search.binarySearch(ls, 0, ls.size(), find));
			}
		}
		System.out.println("Do you want to search again (y/n)");
		String s = input.next();
		switch(s) {
		case "y":
			System.out.println("What surface do you want to search for:");
			int new_find = input.nextInt();
			for(Shape s1: ls) {
				if(s1.getArea() == find) {
					System.out.println("Found: " + Search.binarySearch(ls, 0, ls.size(), new_find));
				}
			}
		case "n":
			break;
		}
	}
}
