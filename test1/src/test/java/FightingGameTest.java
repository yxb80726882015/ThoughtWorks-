import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import java.io.PrintStream;
import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;


/**
 * Created by yangxb on 2/10/15.
 */
public class FightingGameTest {
    private InOrder inOrder;
    private PrintStream out;
    private Random random;

    @Before
    public void setUp(){
        random = mock(Random.class);
        out = mock(PrintStream.class);
        inOrder = inOrder(out);
    }

    @Test
    public void test_should_input_solder_and_player() {
        Fighting fighting = new Fighting(out,random);
        given(random.nextInt(2)).
                willReturn(1,2,1,2,1,2);
        Player player1 = new Soldier(10,8,"张三","铁锤","32",8,2);
        Player player2 = new Player(20,9,"李四");
        fighting.start(player1, player2);
        inOrder.verify(out).println("战士张三用铁锤攻击了普通人李四,普通人李四受到了16点伤害,李四剩余生命:4");
        inOrder.verify(out).println("普通人李四攻击了战士张三,战士张三受到了7点伤害,张三剩余生命:3");
        inOrder.verify(out).println("战士张三用铁锤攻击了普通人李四,普通人李四受到了16点伤害,李四剩余生命:-12");
        inOrder.verify(out).println("李四被打败了.");
    }

    @Test
    public void test_should_input_solder_and_solder()  {
        Fighting fighting = new Fighting(out,random);
        given(random.nextInt(2)).
                willReturn(1,2,1,2,1,2);
        Player player1 = new Soldier(10,8,"张三","铁锤","32",8,2);
        Player player2 = new Soldier(20,9,"李四","铁锤","32",9,3);
        fighting.start(player1, player2);
        inOrder.verify(out).println("战士张三用铁锤攻击了战士李四,战士李四受到了13点伤害,李四剩余生命:7");
        inOrder.verify(out).println("战士李四用铁锤攻击了战士张三,战士张三受到了16点伤害,张三剩余生命:-6");
        inOrder.verify(out).println("张三被打败了.");
    }


    @Test
    public void test_should_input_player_and_player() {
        Fighting fighting = new Fighting(out,random);
        given(random.nextInt(2)).
                willReturn(1,2,1,2,1,2);
        Player player1 = new Player(10,8,"张三");
        Player player2 = new Player(20,9,"李四");
        fighting.start(player1, player2);
        inOrder.verify(out).println("普通人张三攻击了普通人李四,普通人李四受到了8点伤害,李四剩余生命:12");
        inOrder.verify(out).println("普通人李四攻击了普通人张三,普通人张三受到了9点伤害,张三剩余生命:1");
        inOrder.verify(out).println("普通人张三攻击了普通人李四,普通人李四受到了8点伤害,李四剩余生命:4");
        inOrder.verify(out).println("普通人李四攻击了普通人张三,普通人张三受到了9点伤害,张三剩余生命:-8");
        inOrder.verify(out).println("张三被打败了.");
    }



}
