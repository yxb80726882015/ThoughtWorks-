import org.junit.Test;

import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by yangxb on 2/2/15.
 */

public class test {

    /*
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
    */

    @Test
    public void testAnswerGenerator(){
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,6)
                .willReturn(2,3,6,7);
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
    }
}
