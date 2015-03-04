import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by yangxb on 2/7/15.
 */
public class GameProcess {
    private PrintStream out;
    private final BufferedReader reader;
    private final CompareNumber compareNumber;
    private final AnswerGenerator answerGenerator;

    public GameProcess(PrintStream out, BufferedReader reader, CompareNumber compareNumber, AnswerGenerator answerGenerator) {
        this.out = out;
        this.reader = reader;
        this.compareNumber = compareNumber;
        this.answerGenerator = answerGenerator;
    }

    public void start() throws IOException {
        out.println("Welcome!");
        int roundCount = 6;
        out.println("Please input your number("+roundCount+"):");
        String answer = answerGenerator.generate();
        while (roundCount>0){
            String input = reader.readLine();
            String tips = compareNumber.gitTips(input,answer);
            out.println(tips);
            roundCount--;
        }
        out.println("Game Over");
    }
}
