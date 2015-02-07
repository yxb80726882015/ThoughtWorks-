import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by yangxb on 2/5/15.
 */
public class CompareNumberTest {
    @Test
    public void should_return_4A0B_when_get_tips_given_input_is_1234_and_answer_is_1234(){
        String input = "1234";
        String answer = "1234";

        //when
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.gitTips(input,answer);
        assertThat(result).isEqualTo("4A0B");

    }

    @Test
    public void should_return_0A0B_when_get_tips_given_input_is_1234_and_answer_is_5678(){
        String input = "1234";
        String answer = "5678";

        //when
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.gitTips(input,answer);
        assertThat(result).isEqualTo("0A0B");

    }

    @Test
    public void should_return_0A4B_when_get_tips_given_input_is_1234_and_answer_is_4321(){
        String input = "1234";
        String answer = "4321";

        //when
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.gitTips(input,answer);
        assertThat(result).isEqualTo("0A4B");
    }

}
