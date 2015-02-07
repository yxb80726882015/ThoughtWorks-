import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

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
        assertThat(result).isEqualTo("Cannot input duplicate numbers!\n");
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
    public void should_exception_when_given_number_is_not_number()  {
        String input = "1234";
        String answer = "adfa";
        String result = GuessNumberGame.guessNumber(input, answer);
        assertThat(result).isEqualTo("error input");
    }

    @Test
    public void should_return_game_over_when_input_6_times()  {
        Random random = mock(Random.class);
        given(random.nextInt(10)).
                willReturn(1,2,3,4);

        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        String rightNumber = answerGenerator.generateAnswerOnce();

        ArrayList<String> guessList=new ArrayList<String>();
        guessList.add("4321");
        guessList.add("5678");
        guessList.add("9527");
        guessList.add("5643");
        guessList.add("4532");
        guessList.add("4689");
        String result=null;
        for(int i=0;i<guessList.size();i++) {
            result = GuessNumberGame.guessNumber(rightNumber, guessList.get(i));
        }
        assertThat(result).isEqualTo("Game Over");
    }

    @Test
    public void should_return_congratulation_when_input_right_at_5_times()  {
        Random random = mock(Random.class);
        given(random.nextInt(10)).
                willReturn(1,2,3,4);

        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        String rightNumber = answerGenerator.generateAnswerOnce();

        ArrayList<String> guessList = new ArrayList<String>();
        guessList.add("4321");
        guessList.add("5673");
        guessList.add("5987");
        guessList.add("0987");
        guessList.add("1234");
        String result=null;
        for(int i=1;i<guessList.size();i++) {
            result = GuessNumberGame.guessNumber(rightNumber, guessList.get(i));
        }
        guessList = null;
        assertThat(result).isEqualTo("Congratulations!");
    }

}
