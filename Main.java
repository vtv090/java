package findsamelengthwords;
import java.util.*;
/**
 * @author VT Vo
 * @version 15.05.2021
 * Using ArrayList
 * */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = "";
        TheSameLength find = new TheSameLength(input);

        while(true){
            System.out.println("Enter your String:");
            if(scan.hasNext()){
                input = scan.nextLine();
            }
            find.setText(input);
            find.find();
            System.out.println("The Result: \n");
            System.out.println(find);
            System.out.println("Do you want to try with other Text? (y/n)");

            if(scan.hasNext()){
                input = scan.nextLine();

                if(input.equals("n")){
                    break;
                }else if(!input.equals("y")){
                    System.err.println("Please enter only 'y' or 'n'");
                    System.exit(-1);
                }
            }
        }
    }
}
