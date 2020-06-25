package Tiles;

public class Health {
    private int hp;
    private int currentHealth;

    public Health(int hp, int currentHealth) {
        this.hp = hp;
        this.currentHealth = currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void hpOnLevelUp(int level){
        this.hp+=(10*level);
        this.currentHealth=this.hp;
    }
}
