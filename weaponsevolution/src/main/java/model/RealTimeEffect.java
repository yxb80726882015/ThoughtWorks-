package model;

/**
 * Created by yangxb on 3/2/15.
 */
public class RealTimeEffect extends Effect {

    public RealTimeEffect(String name, Double probability, int personAttack, int weaponAttack,String status,int printStatusCode) {
        super(name,1,2*(personAttack + weaponAttack),2*(personAttack + weaponAttack), probability,status, printStatusCode);
    }

    @Override
    public int getHeart() {
        return super.getHeartBlood();
    }
}
