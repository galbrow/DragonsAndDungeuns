package Tiles;

public class Health {
    private int hp;
    private int currentHealth;

    public Health(int hp, int currentHealth) {
        this.hp = hp;
        this.currentHealth = currentHealth;
    }

    public void hpOnLevelUp(int level){
        this.hp+=(10*level);
        this.currentHealth=this.hp;
    }

    @Override
    public String toString() {
        return ""+currentHealth+"\\"+hp;
    }
}
