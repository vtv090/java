package passwordfromtext;

import java.util.*;

public class TextInput {

    private static Scanner sc;
    public static String readLine(){
        if(TextInput.sc == null){
            //new scanner creat
            TextInput.sc = new Scanner(System.in);
        }
        //when there is a text
        if(TextInput.sc.hasNextLine()){
            return TextInput.sc.nextLine(); //return the text
        }else{
            return null;
        }
    }
}
