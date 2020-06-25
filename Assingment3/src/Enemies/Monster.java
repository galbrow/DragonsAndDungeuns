package Enemies;

import Enemies.Enemy;

public class Monster extends Enemy {
    private int visionRange;
    public Monster(int exp,int visionRange) {
        super(exp);
        this.visionRange=visionRange;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

}
