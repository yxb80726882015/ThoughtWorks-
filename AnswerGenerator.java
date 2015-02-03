import java.util.Random;

/**
 * Created by yangxb on 2/2/15.
 */
public class AnswerGenerator {

    public int getNoDuplicateFourRandNumber(){
        int a = (int )(Math.random()*10);
        int b = (int )(Math.random()*10);
        int c = (int )(Math.random()*10);
        int d = (int )(Math.random()*10);
        while ( a == b ){
            b = (int)(Math.random() * 10);
        }
        while ( a == c || b == c){
            c = (int)(Math.random() * 10);
        }
        while ( a == d || b == d || c==d ){
            d = (int )(Math.random()*10);
        }
        int number = a*1000 + b*100 + c*10 + d;
        System.out.print(number+"\n");
        return  number;
    }

}
