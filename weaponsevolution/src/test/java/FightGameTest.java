import fight.FightGame;
import model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Created by yangxb on 2/27/15.
 */
public class FightGameTest {
    private InOrder inOrder;
    private PrintStream out;
    private Random random;

    @Before
    public void setUp() {
        random = mock(Random.class);
        out = mock(PrintStream.class);
        inOrder = inOrder(out);
    }
/*
    @Test
    public void generalPerson_vs_solder() {
        FightGame fightGame = new FightGame(out, random);
        Player person = new GeneralPerson("张三", 30, 9);
        Player person1 = new Solder("李四", 20, 10, new Weapon("铁锤", 11), new Armor("maozi", 3));
        fightGame.fight(person, person1);
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了6点伤害,战士李四剩余生命:14");
        inOrder.verify(out).println("战士李四用铁锤攻击了普通人张三,普通人张三受到了10点伤害,普通人张三剩余生命:9");
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了6点伤害,战士李四剩余生命:8");
        inOrder.verify(out).println("战士李四用铁锤攻击了普通人张三,普通人张三受到了10点伤害,普通人张三剩余生命:-12");
        inOrder.verify(out).println("普通人张三被打败");
    }

    @Test
    public void solder_vs_solder() {
        FightGame fightGame = new FightGame(out, random);
        Player person = new GeneralPerson("张三", 30, 9);
        Player person1 = new Solder("李四", 20, 10, new Weapon("铁锤", 11), new Armor("maozi", 3));
        fightGame.fight(person, person1);
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了6点伤害,战士李四剩余生命:14");
        inOrder.verify(out).println("战士李四用铁锤攻击了普通人张三,普通人张三受到了10点伤害,普通人张三剩余生命:9");
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了6点伤害,战士李四剩余生命:8");
        inOrder.verify(out).println("战士李四用铁锤攻击了普通人张三,普通人张三受到了10点伤害,普通人张三剩余生命:-12");
        inOrder.verify(out).println("普通人张三被打败");
    }
*/

    @Test
    public void generalPerson_vs_solder_with_poison_effect() {
        FightGame fightGame = new FightGame(out, random);
        given(random.nextDouble()).
                willReturn(0.14, 0.53, 0.53, 0.53,0.53,0.53,0.53);
        Player person = new GeneralPerson("张三", 30, 8);
        Player person1 = new Solder("李四", 30, 6, new Weapon("优质毒剑",2,new DelayEffect("毒性",2,2,2,0.32 ,"中毒了",1)), new Armor("防具", 1),random);
        fightGame.fight(person,person1);
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了7点伤害,战士李四剩余生命:23");
        inOrder.verify(out).println("战士李四用优质毒剑攻击了普通人张三,普通人张三受到了8点伤害,普通人张三中毒了,剩余生命:22");
        inOrder.verify(out).println("普通人张三受到2点毒性伤害,普通人张三剩余生命:20");
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了7点伤害,战士李四剩余生命:16");
        inOrder.verify(out).println("战士李四用优质毒剑攻击了普通人张三,普通人张三受到了8点伤害,普通人张三中毒了,剩余生命:12");
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了7点伤害,战士李四剩余生命:9");
        inOrder.verify(out).println("战士李四用优质毒剑攻击了普通人张三,普通人张三受到了8点伤害,普通人张三中毒了,剩余生命:4");
        inOrder.verify(out).println("普通人张三受到2点毒性伤害,普通人张三剩余生命:2");
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了7点伤害,战士李四剩余生命:2");
        inOrder.verify(out).println("战士李四用优质毒剑攻击了普通人张三,普通人张三受到了8点伤害,普通人张三中毒了,剩余生命:-6");
        inOrder.verify(out).println("普通人张三被打败");
    }

    @Test
    public void generalPerson_vs_solder_with_ice_effect() {
        FightGame fightGame = new FightGame(out, random);
        given(random.nextDouble()).
                willReturn(0.14, 0.53, 0.53, 0.53,0.53,0.53,0.53);
        Player person = new GeneralPerson("张三", 30, 10);
        Player person1 = new Solder("李四", 30, 9, new Weapon("寒冰剑",2,new DelayEffect("",2,2,0,0.32 ,"冻僵了",2)), new Armor("防具", 1),random);
        fightGame.fight(person,person1);
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了9点伤害,战士李四剩余生命:21");
        inOrder.verify(out).println("战士李四用寒冰剑攻击了普通人张三,普通人张三受到了11点伤害,普通人张三冻僵了,剩余生命:19");
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了9点伤害,战士李四剩余生命:12");
        inOrder.verify(out).println("战士李四用寒冰剑攻击了普通人张三,普通人张三受到了11点伤害,普通人张三冻僵了,剩余生命:8");
        inOrder.verify(out).println("普通人张三冻的直哆嗦,没有命中李四");
        inOrder.verify(out).println("战士李四用寒冰剑攻击了普通人张三,普通人张三受到了11点伤害,普通人张三冻僵了,剩余生命:-3");
        inOrder.verify(out).println("普通人张三被打败");
    }

    @Test
    public void generalPerson_vs_solder_with_giddy_effect() {
        FightGame fightGame = new FightGame(out, random);
        given(random.nextDouble()).
                willReturn(0.14, 0.53, 0.53, 0.53,0.53,0.53,0.53);
        Player person = new GeneralPerson("张三", 30, 10);
        Player person1 = new Solder("李四", 30, 9, new Weapon("晕锤",2,new DelayEffect("",2,1,0,0.32 ,"晕倒了",3)), new Armor("防具", 1),random);
        fightGame.fight(person,person1);
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了9点伤害,战士李四剩余生命:21");
        inOrder.verify(out).println("战士李四用晕锤攻击了普通人张三,普通人张三受到了11点伤害,普通人张三晕倒了,剩余生命:19");
        inOrder.verify(out).println("普通人张三晕倒了无法攻击,眩晕还剩1轮");
        inOrder.verify(out).println("战士李四用晕锤攻击了普通人张三,普通人张三受到了11点伤害,普通人张三晕倒了,剩余生命:8");
        inOrder.verify(out).println("普通人张三晕倒了无法攻击,眩晕还剩0轮");
        inOrder.verify(out).println("战士李四用晕锤攻击了普通人张三,普通人张三受到了11点伤害,普通人张三晕倒了,剩余生命:-3");
        inOrder.verify(out).println("普通人张三被打败");
    }

    @Test
    public void generalPerson_vs_solder_with_full_effect() {
        FightGame fightGame = new FightGame(out, random);
        given(random.nextDouble()).
                willReturn(0.14, 0.53, 0.53, 0.53,0.53,0.53,0.53);
        Player person = new GeneralPerson("张三", 30, 10);
        Player person1 = new Solder("李四", 30, 9, new Weapon("利剑",2,new RealTimeEffect("",0.32 ,9,2,"张三发动了全力一击",4)), new Armor("防具", 1),random);
        fightGame.fight(person,person1);
        inOrder.verify(out).println("普通人张三攻击了战士李四,战士李四受到了9点伤害,战士李四剩余生命:21");
        inOrder.verify(out).println("战士李四用利剑攻击了普通人张三,战士李四发动了全力一击,普通人张三受到了33点伤害");
      //  inOrder.verify(out).println("普通人张三被打败");
    }
}
