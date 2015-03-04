package fight;

import model.Player;
import model.Solder;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by yangxb on 2/27/15.
 */
public class FightGame {
    private static PrintStream out;
    private Random random;

    public FightGame(PrintStream out, Random random) {
        this.out = out;
        this.random  = random;
    }

    public void fight(Player person, Player person1){
        while (true){
            if( !(person.getPlayerEffect() != null && person.getPlayerEffect().isGiddy()) ) {
                person.attack(person1, out);
            }
            if( !(person1.getPlayerEffect() != null && person.getPlayerEffect().isGiddy()) ) {
                person1.attack(person, out);
            }
            if(person.getBlood() < 0){
                out.println(person.getName() + "被打败");
                break;
            }
            if(person1.getBlood() < 0){
                out.println(person1.getName() + "被打败");
                break;
            }
        }
    }
}
