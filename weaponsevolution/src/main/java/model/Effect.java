package model;

import java.util.Random;

/**
 * Created by yangxb on 3/2/15.
 */
public abstract class Effect {
    private String name;

    private double probability;

    private int allHitTimes;

    private int perHitTime;

    private int heartBlood;

    private String status;

    private int printStatusCode;

    public Effect(String name,int allHitTimes,int perHitTime,int heartBlood,double probability,String status,int printStatusCode){
        this.name = name;
        this.allHitTimes = allHitTimes;
        this.perHitTime = perHitTime;
        this.probability = probability;
        this.heartBlood = heartBlood;
        this.status = status;
        this.printStatusCode = printStatusCode;
    }

    public int getAllHitTimes(){
        return this.allHitTimes;
    }

    public String getName(){
        return this.name;
    }

    public double getProbability(){
        return this.probability;
    }

    public int getHeartBlood(){
        return this.heartBlood;
    }

    public int getPerHitTime(){
        return this.perHitTime;
    }

    public String getStatus(){
        return status;
    }

    public int getPrintStatusCode() { return this.printStatusCode ;};

    public abstract int getHeart();
}
