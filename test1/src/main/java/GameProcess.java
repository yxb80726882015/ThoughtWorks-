import java.io.PrintStream;

/**
 * Created by yangxb on 2/7/15.
 */
public class GameProcess {
    private PrintStream out;

    public GameProcess(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("Welcome!");
        out.println("Please input your number(6):");

    }
}
