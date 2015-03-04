package model;

import java.util.Random;

/**
 * Created by yangxb on 3/3/15.
 */
public class PlayerEffect {
    private int leftTimes = 0;

    private int heartPreTime = 0;

    private Effect effect;

    private Random random;

    private int currentTime = 0;

    public PlayerEffect (Effect effect,Random random){
        this.effect = effect;
        this.random = random;
    }

    public void hitEffect(){
        Double number = random.nextDouble();
        if (effect.getProbability() >= number) {
            if (leftTimes == 0) {
                leftTimes = effect.getAllHitTimes();
                heartPreTime = effect.getHeart();
            } else {
                leftTimes += effect.getAllHitTimes();
                heartPreTime += effect.getHeart();
            }
        }
    }

    public int getReduceBlood(){
        if(currentTime % effect.getPerHitTime() == 0){
            if (leftTimes == 0){
                return 0;
            }
            return heartPreTime;
        } else {
            return 0;
        }
    }

    public boolean isGiddy(){
        if(currentTime == 0 && leftTimes >= 0 &&  heartPreTime == 0 ){
            return true;
        }
        if(currentTime % effect.getPerHitTime() == 0 && heartPreTime == 0 && leftTimes >= 0 ){
            return true;
        }else {
            return false;
        }
    }


    public void reduceHitTime(){
        if( currentTime % effect.getPerHitTime() == 0 && (leftTimes > -1) ){
            leftTimes = leftTimes - 1;
        }
        currentTime++;
        if( leftTimes == 0 ){
            currentTime = 0;
            return;
        }
    }

    public String getStatus(){
        if (effect != null){
            return effect.getStatus();
        }else {
            return "";
        }
    }

    public int getLeftTimes(){
        return this.leftTimes;
    }

}
