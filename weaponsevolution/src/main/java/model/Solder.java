package model;

import java.io.PrintStream;
import java.util.Random;
import java.util.logging.StreamHandler;

/**
 * Created by yangxb on 2/27/15.
 */
public class Solder extends Player{

    private Weapon weapon;
    private Armor armor;
    private Random random;

    public Solder(String name, int blood, int attackValue, Weapon weapon,Armor armor,Random random){
        super(name, blood, attackValue);
        this.weapon = weapon;
        this.armor = armor;
        this.random = random;
    }

    @Override
    public void attack(Player person,PrintStream out){
        int attack = 0;
        int effectAttack = 0;
        StringBuffer buf = new StringBuffer();
        if (weapon != null && weapon.effect != null){
            if (person.getPlayerEffect() == null) {
                person.setPlayerEffect(new PlayerEffect(weapon.getEffect(), random));
            }
            person.getPlayerEffect().hitEffect();
            effectAttack =  person.getPlayerEffect().getReduceBlood();
            person.getPlayerEffect().reduceHitTime();
        }
        attack += this.getAttackValue() + getWeaponAttack() ;
        if(person.getClass() == Solder.class){
            attack -=  person.getArmorDefend();
        }
        person.setBlood(person.getBlood() - attack);
        buf.append(this.getName() + getWeaponName() + "攻击了" + person.getName() + "," + person.getName() + "受到了" + attack + "点伤害,");
        if( person.getPlayerEffect() != null ){
            buf.append(person.getName()+person.getPlayerEffect().getStatus()+",");
        }
        buf.append("剩余生命:" + person.getBlood());
        int printStatusCode = weapon.getEffect().getPrintStatusCode();
        if(printStatusCode == 1 || printStatusCode == 2 || printStatusCode == 3) {
            out.println(buf.toString());
        }
        if(effectAttack > 0){
            person.setBlood(person.getBlood() - effectAttack);
            printStatus(person,printStatusCode,effectAttack,weapon.getEffect().getName(), out,attack);
        }
        if(person.getPlayerEffect().isGiddy()){
            printStatus(person,printStatusCode,0,weapon.getEffect().getName(), out, attack);
        }
    }

    public void printStatus(Player person,int printStatusCode,int effectAttack,String weaponEffect,PrintStream out,int attack){
        if(printStatusCode == 1 ){
            out.println(person.getName() + "受到" + effectAttack + "点" + weaponEffect + "伤害," + person.getName() + "剩余生命:" + person.getBlood());
        }else if(printStatusCode == 2){
            out.println(person.getName()+"冻的直哆嗦,"+"没有命中"+super.getName());
        }else if(printStatusCode == 3){
            out.println(person.getName()+"晕倒了无法攻击,眩晕还剩"+person.getPlayerEffect().getLeftTimes()+"轮");
        }else  if(printStatusCode == 4 ){
            out.println(this.getName() + getWeaponName() + "攻击了" + person.getName() + "," + this.getName() + "发动了全力一击," + person.getName() + "受到了" + (effectAttack + attack) + "点伤害");
        }
    }

    public String getWeaponName() {
        return "用"+weapon.getName();
    }

    public int getWeaponAttack(){
        if(weapon != null) {
            return weapon.getAttack();
        }else{
            return 0;
        }
    }

    public int getArmorDefend(){
        if(armor != null) {
            return armor.getDefend();
        }else {
            return 0;
        }
    }

    @Override
    public String getName() {
        return "战士"+super.getName();
    }

}
