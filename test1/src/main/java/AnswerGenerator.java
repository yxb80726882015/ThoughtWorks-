import java.util.*;

/**
 * Created by yangxb on 2/5/15.
 */
public class AnswerGenerator {
    private Random random;
    private  final List<String> historyGeneratedStrings;

    public AnswerGenerator(Random random){
        this.random = random;
        this.historyGeneratedStrings = new ArrayList<String>();
    }

    public String generate(){

        String result = this.generateAnswerOnce();
        while (historyGeneratedStrings.contains(result)){
            this.generateAnswerOnce();
        }
        if (historyGeneratedStrings.size() == 2){
            historyGeneratedStrings.remove(0);
        }
        historyGeneratedStrings.add(result);
        return  result;
    }

    public String generateAnswerOnce() {
        StringBuffer result = new StringBuffer();
        while (result.length() < 4){
            String digit = String.valueOf(random.nextInt(10));
            if(result.indexOf(digit) == -1){
                result.append(digit);
            }
        }
        return result.toString();
    }
}
