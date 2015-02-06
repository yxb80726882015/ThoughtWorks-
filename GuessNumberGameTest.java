import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.Mockito.*;


/**
 * Created by yangxb on 2/6/15.
 */
public class GuessNumberGameTest {


    @Test
    public void should_return_congratulations_when_get_tips_given_input_is_1234_and_answer_is_1234(){
        String input = "1234";
        String answer = "1234";

        //when
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("Congratulations!");

    }

    @Test
    public void should_return_0A0B_when_get_tips_given_input_is_1234_and_answer_is_5678(){
        String input = "1234";
        String answer = "5678";

        //when
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("0A0B");
    }

    @Test
    public void should_return_0A4B_when_get_tips_given_input_is_1234_and_answer_is_4321(){
        String input = "1234";
        String answer = "4321";

        //when
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("0A4B");
    }

    @Test
    public void should_return_2A2B_when_get_tips_given_input_is_1234_and_answer_is_1243(){
        String input = "1234";
        String answer = "1243";

        //when
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("2A2B");
    }

    @Test
    public  void should_print_error_message_when_given_number_has_duplicate_number(){
        String input = "1234";
        String answer = "1242";

        //when
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("Cannot input duplicate numbers!");
    }

    @Test
    public void should_print_error_when_given_number_is_not_four_number(){
        String input = "1234";
        String answer = "12425";

        //when
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("error input");
    }

    @Test
    public void should_exception_when_given_number_is_not_number() throws Exception {
        String input = "1234";
        String answer = "adfa";
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("error input");
    }

}
