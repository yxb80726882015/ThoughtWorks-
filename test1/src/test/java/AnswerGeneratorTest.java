import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by yangxb on 2/5/15.
 */
public class AnswerGeneratorTest {

    @Test
    public void should_generate_4_digits_string(){
        String result = new AnswerGenerator(new Random()).generate();
        assertThat(result.length()).isEqualTo(4);
    }
    @Test
    public void  should_generate_number(){
        String result = new AnswerGenerator(new Random()).generate();
        try {
            Integer.parseInt(result);
        }catch (NumberFormatException e ){
            fail("result should be number ");
        }
    }
    @Test
    public void should_generate_no_duplication_digits_string(){
        String result = new AnswerGenerator(new Random()).generate();
        for (int i=0;i<result.length();i++){
            assertThat(result.indexOf(result.charAt(i))).isEqualTo(result.lastIndexOf(result.charAt(i)));
        }
    }
    @Test
    public void should_not_repeat_in_3_times(){
        Random random = mock(Random.class);
        given(random.nextInt(10)).
                willReturn(1,2,3,4).
                willReturn(1,2,3,4).
                willReturn(2,3,4,5).
                willReturn(3,4,5,6);

        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
        Set<String> results = new HashSet<String>();
        results.add(answerGenerator.generate());
        results.add(answerGenerator.generate());
        results.add(answerGenerator.generate());
        assertThat(results.size()).isEqualTo(3);
    }

}
