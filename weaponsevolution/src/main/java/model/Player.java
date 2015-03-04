package model;

import java.io.PrintStream;

/**
 * Created by yangxb on 2/27/15.
 */
public abstract class Player {
    private String name;
    private int blood;
    private int attackValue;
    private PlayerEffect playerEffect;

    public Player(String name, int blood, int attackValue){
        this.name = name;
        this.blood = blood;
        this.attackValue = attackValue;
    }

    public int getBlood(){
        return this.blood;
    }

    public void setBlood(int blood){
        this.blood = blood;
    }

    public int getAttackValue(){
        return this.attackValue;
    }

    public String getName(){
        return this.name;
    }

    public void setPlayerEffect(PlayerEffect playerEffect){
        this.playerEffect = playerEffect;
    }

    public PlayerEffect getPlayerEffect(){
        return this.playerEffect;
    }

    public abstract void attack(Player person,PrintStream out);

    public abstract int getWeaponAttack();

    public abstract int getArmorDefend();

}
