package passwordfromtext;

/*
* 1. Idea: get first char of each word + number of UpperCase in Text
* 2. Idea: get UpperCase + last char of each word + number of UpperCase in Text
* 3. Idea: get i-th char in i-th word. If i > length of word then get last char of word + number of UpperCase in Text
* */
public class CreatPassWord {
    private String text;

    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }

    /*
     * @parameter text String
     * @return String like password
     * */

    public String makepassword(String text){

        //Split a Text to String Array
        String words[] = text.split(" ");
        String password = "";

        //count every Upper Case in every word in Array
        int countUpperCase = 0;
        for (String w : words){
            for(int i = 0; i < w.length(); i++){
                if(w.charAt(i) >= 'A' && w.charAt(i) <= 'Z'){ //count only Upper Case in every word
                    countUpperCase++;
                }
            }
        }
        // -> 1.Idea: add first character of every String to "password"
        //for(String w: words){
        //  password += w.charAt(0);
            /*
             * char[] wordToArr = w.toCharArray(); // co the lam theo 2 cach
             * password += wordToArr[0];
             */
        //}

        // -> 2. Idea: add UpperCase & Last Character of every String to "password"
        /*
        * for(int i = 0; i < words.length; i++){
            char[] tempWords = words[i].toCharArray();
            int arrLength = tempWords.length;
            for(int j = 0; j < tempWords.length; j++){
                if(tempWords[j] >= 'A' && tempWords[j] <= 'Z'){
                    password += tempWords[j];
                }
            }
            password += tempWords[arrLength-1];
        }
        * */

        //-> 3. Idea: tai word thu i, get i-th Char. When i > word length, get last char of word
        /*
        * for(int i = 0; i < words.length; i++){
            char[] arrChar = words[i].toCharArray();
            int arrCharlength = arrChar.length;
            if(i < arrCharlength) {
                password += arrChar[i]; //i-th word, get i-th char
            }else{
                password += arrChar[arrCharlength - 1]; // i > word Length, get last char of word
            }
        }
        * */

        //-> 4.Idea: in even words position, get max even char in word
        //in odd words position, get max odd char in word
        for(int i = 0; i < words.length; i++){
            char[] wordToChar = words[i].toCharArray();
            int wordToCharLength = wordToChar.length;
            if((i +1) % 2 == 0){
                if(wordToCharLength%2 == 0){
                    password += wordToChar[wordToCharLength-2];
                }else{
                    password += wordToChar[wordToCharLength - 1];
                }
            }else{
                if(wordToCharLength%2 == 0){
                    password += wordToChar[wordToCharLength-2];
                }else{
                    password += wordToChar[wordToCharLength - 1];
                }
            }
        }



        //convert int to char
        char number = (char)(countUpperCase + '0');
        password += number;
        return password;
    }

    @Override
    public String toString(){
        return this.text;
    }
}

