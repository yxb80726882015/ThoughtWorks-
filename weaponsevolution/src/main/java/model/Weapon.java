package model;

import java.util.Random;

/**
 * Created by yangxb on 2/27/15.
 */
public class Weapon {
    public String name;
    public int attack;
    public Effect effect;

    public Weapon(String name,int attack, Effect effect){
        this.name = name;
        this.attack = attack;
        this.effect = effect;
    }

    public String getName(){
        return this.name;
    }

    public Effect getEffect(){
        return  this.effect;
    }

    public int getAttack(){
        return this.attack;
    }

}
