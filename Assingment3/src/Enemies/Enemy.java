package Enemies;

public abstract class Enemy {
    private int exp;

    public Enemy(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
