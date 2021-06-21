package VietLai;

import java.util.*;

public class SelectionSort{
	public static <T extends Comparable<T>> void slectionSort(List<Shape> ls){
		for(int i = 0; i < ls.size(); i++) {
			Shape min = ls.get(i);
			int minId = i;
			for(int j = i+1; j< ls.size(); j++) {
				if(ls.get(j).compareTo(min) < 0) {
					min = ls.get(j);
					minId = j;
				}
			}
			
			if(minId != i) {
				Shape temp = ls.get(i);
				ls.set(i, min);
				ls.set(minId, temp);
			}
		}
	}

}
