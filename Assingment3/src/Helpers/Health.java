package Helpers;

public class Health {
    private int hp;
    private int currentHealth;

    public Health(int hp, int currentHealth) {
        this.hp = hp;
        this.currentHealth = currentHealth;
    }

    public void hpOnLevelUp(int level) {
        this.hp += (10 * level);
        this.currentHealth = this.hp;
    }

    public void RaiseHp(int hp) {
        this.hp +=hp;
    }

    public void RaiseCurrHealth(int amount) {
        this.currentHealth+=amount;
        if(currentHealth>hp)
            currentHealth=hp;
    }

    public int getHp() {
        return hp;
    }

    public boolean ReduceCurrHealth(int amount){
        this.currentHealth-=amount;
        if(currentHealth<=0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return ""+currentHealth+"\\"+hp;
    }
}
