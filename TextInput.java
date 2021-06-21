package sortwordsinsentence;

import java.util.*;

public class TextInput {
    private static Scanner scan;
    public static String readLine(){
        String input;
        if(TextInput.scan == null){
            TextInput.scan = new Scanner(System.in);//creat new scanner
        }
        //when you input the text
        if(scan.hasNextLine()){
            input = scan.nextLine();
            return input; //return the input text
        }else{
            return null;
        }
    }
}
