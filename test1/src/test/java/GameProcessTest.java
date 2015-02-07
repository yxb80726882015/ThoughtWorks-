import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by yangxb on 2/7/15.
 */
public class GameProcessTest {

    @Test
    public void should_print_welcome_when_game_start(){
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        verify(out,never()).println("Welcome!");
        game.start();
        verify(out).println("Welcome!");
    }

    @Test
    public  void should_print_please_input_after_game_start(){
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
    }

}
