package model;

/**
 * Created by yangxb on 2/28/15.
 */
public class Armor {

    private String name;
    private int defend;

    public Armor(String name,int defend){
        this.name = name;
        this.defend = defend;
    }

    public String getName(){
        return this.name;
    }

    public int getDefend(){
        return this.defend;
    }

}
