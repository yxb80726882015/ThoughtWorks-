/**
 * Created by yangxb on 2/5/15.
 */
public class CompareNumber {

    public String gitTips(String input, String answer) {
        int aCount = 0;
        int containCount= 0;

        for (int i=0;i<input.length();i++){
            if(input.charAt(i) == answer.charAt(i)) {
                aCount++;
            }else if(answer.contains(String.valueOf(input.charAt(i)))){
                containCount++;
            }
        }

        return aCount+"A"+containCount+"B";
    }
}
