/**
 * Created by yangxb on 2/10/15.
 */
public abstract class Player {
    private int blood;
    private int attack;
    private String name;

    public Player(int blood,int attack,String name){
        this.blood = blood;
        this.attack = attack;
        this.name = name;
    }

    public int getBlood(){
        return this.blood;
    }

    public int getAttack(){
        return this.attack;
    }

    public String name(){
        return this.name;
    }

    public abstract void attract();

    public abstract void reduce();

}