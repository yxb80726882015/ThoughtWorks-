import java.io.PrintStream;
import java.util.Random;

/**
 * Created by yangxb on 2/10/15.
 */
public class Fighting {
    private PrintStream out;
    private Random random;

    Fighting(PrintStream out,Random random) {
        this.out = out;
        this.random  = random;
    }

    public void start(Player player1, Player player2){
        int i= 0;
        while (i != -1){
            int time = random.nextInt(2);
            if(time == 1) {
                i = calculate (player1,player2);
            }else {
                i = calculate (player2,player1);
            }
        }
    }

    public int calculate (Player player1,Player player2){
        String player1Name = player1.name;
        String player2Name = player2.name;
        int player1Attack = player1.attack;
        String weapon = "";
        if( player1.getClass() == Soldier.class ){
            player1Name = "战士"+player1Name;
            Soldier soldier1 = (Soldier )player1;
            player1Attack += soldier1.weaponHeat;
            player2.blood = player2.blood - player1Attack;
            weapon = "用"+soldier1.weapon;
        } else {
            player1Name = "普通人"+player1Name;
            player2.blood = player2.blood - player1.attack;
        }
        if( player2.getClass() == Soldier.class ){
            player2Name = "战士"+player2Name;
            Soldier soldier2 = (Soldier )player2;
            player1Attack -= soldier2.defenseHeat;
            player2.blood = player2.blood + soldier2.defenseHeat;
        } else {
            player2Name = "普通人"+player2Name;
        }
        out.println(player1Name+ weapon + "攻击了" + player2Name + "," + player2Name + "受到了" + player1Attack+ "点伤害," + player2.name + "剩余生命:" + player2.blood);
        if (player2.blood < 0) {
            out.println(player2.name + "被打败了.");
            return -1;
        }else {
            return 0;
        }
    }

}
