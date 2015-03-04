import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by yangxb on 2/7/15.
 */
public class GameProcessTest {

    private GameProcess game;
    private PrintStream out;
    private BufferedReader reader;
    private AnswerGenerator answerGenerator;
    private InOrder inOrder;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        CompareNumber compareNumber = new CompareNumber();
        answerGenerator = mock(AnswerGenerator.class);
        inOrder = inOrder(out);
        game = new GameProcess(out, reader,compareNumber, answerGenerator);
    }

    @Test
    public void should_print_welcome_when_game_start() throws IOException {
        verify(out,never()).println("Welcome!");
        game.start();
        verify(out).println("Welcome!");
    }

    @Test
    public  void should_print_please_input_after_game_start() throws IOException {
        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
    }

    @Test
    public void should_reduce_one_chance_when_guess_wrong() throws IOException {
        given(reader.readLine()).willReturn("1234");
        given(answerGenerator.generate()).willReturn("4321");

        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
        inOrder.verify(out).println("OA4B");
        inOrder.verify(out).println("Please input your number(6):");
    }

    @Test
    public void should_reduce_chances_one_by_one_until_game_over() throws IOException {
        game.start();
        inOrder.verify(out).println("Please input your number(6):");
        inOrder.verify(out).println("OA4B");
        inOrder.verify(out).println("Please input your number(5):");
        inOrder.verify(out).println("OA4B");
        inOrder.verify(out).println("Please input your number(4):");
        inOrder.verify(out).println("OA4B");
        inOrder.verify(out).println("Please input your number(3):");
        inOrder.verify(out).println("OA4B");
        inOrder.verify(out).println("Please input your number(2):");
        inOrder.verify(out).println("OA4B");
        inOrder.verify(out).println("Please input your number(1):");
        inOrder.verify(out).println("Game Over");
    }

    @Test
    public void should_congratulate_when_input_is_right() throws IOException{
        given(answerGenerator.generate()).willReturn("1234");

        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
        inOrder.verify(out).println("Congratulation!");
    }

}
