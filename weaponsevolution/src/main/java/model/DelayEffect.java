package model;

import java.util.Random;

/**
 * Created by yangxb on 3/2/15.
 */
public class DelayEffect extends Effect {

    public DelayEffect(String name,int allHitTimes,int perHitTime,int heartBlood,double probability,String status,int printStatusCode){
        super(name,allHitTimes, perHitTime, heartBlood,probability,status, printStatusCode);
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public int getHeart() {
        return super.getHeartBlood();
    }

}
