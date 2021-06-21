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

        //remove the same elements in LengthList
        for(int i = 0; i < lengthList.size(); i++){
            for(int j = i; j < lengthList.size(); j++){
                if(lengthList.get(i).equals(lengthList.get(j))){
                    lengthList.remove(j);
                }
            }
        }

        //Sort lengthList ascend
        for(int i = 0; i < lengthList.size(); i++){
            for(int j = i + 1; j < lengthList.size(); j++){
                if(lengthList.get(i) > lengthList.get(j)){
                    //exchange element position i for element position j
                    int temp = lengthList.get(i);
                    lengthList.set(i, lengthList.get(j));
                    lengthList.set(j, temp);
                }
            }
        }
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
        /*
        co the rut gon lai nhu sau, chi dung vs 1 dong co chua tu cuoi cung
        for(Integer l : lengthList){
             for(int i = 0; i< words.length; i++){
                 if((l.equals(words[i].length())) && i != words.length -1){
                     print_result += words[i] + " ";
                 }else if((l.equals(words[i].length())) && i == words.length -1){
                     print_result += words[i];
                 }
             }
             result += l + ": " + print_result + "\n";
             print_result = "";
         }
        */
    }
    @Override
    public String toString(){
        return this.result;
    }
}
