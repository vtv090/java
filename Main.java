package abstractclass;
import java.util.*;

/**
 * @author VT Vo
 * @version 15.05.2021
 * */
public class Main {
    public static void main(String[] args) {
        //Using Array List
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalaryEmployee("John", "Carter", "1132-12-1121", 800));
        employees.add(new HourlyEmployee("Henry", "Bummer", "12792-12-43483", 17.5, 40));
        employees.add(new CommissionEmployee("Susan", "Trump", "1213-12-6489", 15000, 0.06, 600));
        employees.add(new CommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 0));
        employees.add(new CommissionEmployee("Bhutan", "Putin", "1213-12-6489", 10000, 0.06, 450));

        //call sort function to sort total earned
        InsertSort.sort(employees);
        System.out.print("**********Print Array List***********\n");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
