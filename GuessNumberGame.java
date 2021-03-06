import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

/**
 * Created by yangxb on 2/6/15.
 */
public class GuessNumberGame {

    public static Set<String> historyResultSet = new HashSet<String>();
    public static String number = "1234";

    public static void main(String[]args){
        System.out.print("Welcome!\n");
        while (historyResultSet.size()<6){
            int times = 6-historyResultSet.size();
            System.out.print("Please input your number("+times+"):");
            Scanner in=new Scanner(System.in);
            String input = in.nextLine();
            String result = guessNumber(number,input);
            System.out.print(result);
        }
    }



    public static String guessNumber(String input, String answer) {
        try {
            Integer.parseInt(answer);
        }catch (Exception e){
            e.printStackTrace();
            return "error input";
        }

        if (answer.length()!=4){
            return "error input";
        }

        int aCount = 0;
        int containCount= 0;
        Set answerSet = new HashSet();
        for (int i=0;i<input.length();i++){
            if(input.charAt(i) == answer.charAt(i)) {
                aCount++;
            }else if(answer.contains(String.valueOf(input.charAt(i)))){
                containCount++;
            }
            answerSet.add(answer.charAt(i));
        }
        if(aCount == 4 ){
            historyResultSet.add(answer);
            return "Congratulations!";
        }
        if(answerSet.size() == 4){
            historyResultSet.add(answer);
            return aCount+"A"+containCount+"B";
        }else{
            return "Cannot input duplicate numbers!\n";
        }

    }
}
