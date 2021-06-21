package VietLai;

import java.util.*;

public class Search{

	public static Shape binarySearch(List<Shape> ls, int low, int high, int searchCriteria) {
		
		int mid = (low + high)/2;
		
		if(ls.get(mid).getArea() == searchCriteria)
			return ls.get(mid);
		
		if(ls.get(mid).getArea() > searchCriteria) {
			return binarySearch(ls, low, mid-1, searchCriteria);
		}else {
			return binarySearch(ls, mid+1, high, searchCriteria);
		}
		
		
	}
}
