package model;

import java.io.PrintStream;

/**
 * Created by yangxb on 2/27/15.
 */
public class GeneralPerson extends Player{

    public GeneralPerson(String name, int blood, int attackValue){
        super(name, blood, attackValue);
    }

    @Override
    public void attack(Player person,PrintStream out){
        int attack = 0;
        if(person.getClass() == Solder.class){
            attack = this.getAttackValue() - person.getArmorDefend();
            person.setBlood(person.getBlood() - attack);
        }else {
            attack = this.getAttackValue();
            person.setBlood(person.getBlood() - attack);
        }
        out.println(this.getName() + "攻击了" + person.getName() + "," + person.getName() + "受到了" + attack + "点伤害," + person.getName() + "剩余生命:" + person.getBlood());
    }

    @Override
    public int getWeaponAttack() {
        return 0;
    }

    @Override
    public int getArmorDefend() {
        return 0;
    }

    @Override
    public String getName() {
        return "普通人"+super.getName();
    }

    public String getWeaponName() {
        return "";
    }
}
