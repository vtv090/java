package passwordfromtext;

/*
 * @author Van Trung Vo
 * @version 06.05.2021
 * */
public class Main {
    public static void main(String[] args){
        CreatPassWord text = new CreatPassWord();
        boolean repeat = true;
        while(repeat){
            System.out.println("Enter your text");
            System.out.print("> ");
            String input = TextInput.readLine();
            text.setText(input);

            //Call function Makepassword in Class CreatPassWord
            String pass = text.makepassword(input);
            System.out.println("Your created password: " + pass.toString());

            //Try with new Text
            System.out.println("Do you want try again? (y/n)");
            System.out.print("> ");
            String answer = TextInput.readLine();
            //repeat = answer.equals("y"); //when "y" input, continue new text to input
            if(!answer.equals("y")){
                repeat = false;
            }else{
                repeat = true;
            }
        }
    }
}
