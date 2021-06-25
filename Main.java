public class Main {
    public static  void main(String[] args){
        PermuteWords line = new PermuteWords();
        boolean input = true;
        while(input){
            System.out.println("Enter your Text: ");
            System.out.print("> ");
            String text = TextInput.readLine();
            line.setText(text);
            line.permute();
            System.out.println("New String: " + line);

            System.out.println("Do you want to try with other text? (y/n)");
            System.out.print("> ");
            String answer = TextInput.readLine();
            input = answer.equals("y");
        }
    }
}
