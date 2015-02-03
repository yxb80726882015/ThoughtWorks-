import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;
/**
 * Created by yangxb on 2/2/15.
 */

public class test {

    @Test
    public void testFourthNumberThirdNumberNotEqual(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.getNoDuplicateFourRandNumber();
        assertThat(result / 1000).isNotEqualTo((result%1000)/100);
    }

    @Test
    public void testFourthNumberSecondNumberNotEqual(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.getNoDuplicateFourRandNumber();
        assertThat(result / 1000).isNotEqualTo((result%100)/10);
    }

    @Test
    public void testFourthNumberFirstNumberNotEqual(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.getNoDuplicateFourRandNumber();
        assertThat(result / 1000).isNotEqualTo(result%10);
    }

    @Test
    public void testThirdNumberSecondNumberNotEqual(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.getNoDuplicateFourRandNumber();
        assertThat((result%1000)/100).isNotEqualTo((result%100)/10);
    }

    @Test
    public void testThirdNumberFirstNumberNotEqual(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.getNoDuplicateFourRandNumber();
        assertThat((result%1000)/100).isNotEqualTo(result%10);
    }

    @Test
    public void testSecondNumberFirstNumberNotEqual(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.getNoDuplicateFourRandNumber();
        assertThat((result%100)/10).isNotEqualTo(result%10);
    }
}
