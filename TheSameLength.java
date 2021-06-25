package findsamelengthwords;
import java.util.*;

/*
* 1.Idea: Find words with same Length, then print all with their Length -> DONE!
* 2.Idea: filter words ascend in Text by their Length then sort these words in Alphabet
* */
public class TheSameLength {
    private String text;
    private String result = "";

    public TheSameLength(String text){
        this.text = text;
    }
    //get text
    public String getText(){
        return this.text;
    }
    //setter
    public void setText(String text){
        this.text = text;
    }

    public void find(){
        ArrayList<Integer> lengthList = new ArrayList<>();
        //split text to word
        String[] words = text.split(" ");
        //add all length of words in LengthList
        for(String w : words){
            lengthList.add(w.length());
        }
        
        //remove duplicate and sort the List
        HashSet<Integer> new_list = new HashSet<Integer>(lengthList);
        
        String print_result = "";
        // find all words with same length and then add to print_result
        for(Integer l : lengthList){
            for(String w: words){
                if(l.equals(w.length())){
                    print_result += w + " ";
                }
            }
            //then remove last space for every sorted line
            String[] word = print_result.split(" ");
            String temp_result = "";
            for(int i = 0; i < word.length; i++){
                if(i == word.length-1){
                    temp_result += word[i];
                }else{
                    temp_result += word[i] + " ";
                }
            }
            result += l + ": " + temp_result + "\n";
            print_result = ""; //set print_list as empty list
        }
    }
    @Override
    public String toString(){
        return this.result;
    }
}
