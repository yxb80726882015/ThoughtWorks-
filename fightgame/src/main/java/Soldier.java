/**
 * Created by yangxb on 2/10/15.
 */
public class Soldier extends Player {
    public String weapon;
    public int weaponHeat;
    public String defense;
    public int defenseHeat;

    public Soldier( int blood, int attack, String name,String weapon,String defense,int weaponHeat,int defenseHeat ) {
        super(blood, attack, name);
        this.weapon = weapon;
        this.defense = defense;
        this.weaponHeat = weaponHeat;
        this.defenseHeat = defenseHeat;
    }
}
