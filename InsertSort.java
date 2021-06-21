package abstractclass;
import java.util.*;

public abstract class InsertSort extends Employee{
    //because of Employee Class is abstract, thus creat a constructor with same parameter like Employee
    public InsertSort(String fName, String lName, String sSN) {
        super(fName, lName, sSN);
    }
    //using Insertion Sort
    public static <T extends Comparable<T>> void sort(List<Employee> list){
        for(int i = 0; i < list.size(); i++){
            Employee current = list.get(i);
            int k;
            for(k = i -1; k>= 0 && list.get(k).compareTo(current) >0; k--){
                list.set(k+1, list.get(k));
            }
            list.set(k+1, current);
        }
    }
}
