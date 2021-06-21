package sortwordsinsentence;

public class PermuteWords {
    private String text;
    private String result;

    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void permute(){
        String[] words = text.split(" "); //chia Sentence ra thanh Array
        result = "";

        for(String w : words){
            char [] charArray = w.toCharArray();
            int lastChar = 2; //ignore last character, không sắp xếp

            //Nếu là last word kèm dấu chấm thì tăng số lượng ignored character thêm 1
            if(charArray[charArray.length -1] == '.'){
                lastChar = 3; //ignore 2 Characters included '.'
            }
            int length = charArray.length;
            for(int i = 1; i < length - lastChar; i++){
                if(charArray[i] > charArray[i+1]){
                    char temp = charArray[i];
                    charArray[i] = charArray[i+1];
                    charArray[i+1] = temp;
                    i = 0; //khi phải sắp xếp lại, bắt đầu lại từ đầu i = 0
                }
            }

            //add cac ki tu da chia thanh 1 word
            for(Character ch : charArray){
                result += ch;
            }

            int len_ = words.length;
            //if tu dong them space " " vào những từ khác last word
            if(!w.equals(words[len_ - 1])){ //co the viet theo dang w.equals(word[len_ - 1]) == false
                result += " ";
            }
        }
    }
    @Override
    public String toString(){
        return this.result;
    }
}
