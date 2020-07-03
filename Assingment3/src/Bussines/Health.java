package Bussines;

public class Health {
    private int hp;
    private int currentHealth;

    public Health(int hp) {
        this.hp = hp;
        this.currentHealth = hp;
    }

    public boolean isAlive(){
        return currentHealth>0;
    }

    //when player reach level hp increase
    public void hpOnLevelUp(int level) {
        this.hp += (10 * level);
        this.currentHealth = this.hp;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void RaiseHp(int hp) {
        this.hp +=hp;
    }

    //raise the current health of player
    public void RaiseCurrHealth(int amount) {
        this.currentHealth+=amount;
        if(currentHealth>hp)
            currentHealth=hp;
    }

    public int getHp() {
        return hp;
    }

    //reduce the current health of user
    public boolean ReduceCurrHealth(int amount){
        this.currentHealth-=amount;
        if(currentHealth<=0) {
            currentHealth=0;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ""+currentHealth+"\\"+hp;
    }
}
