
package Players;

import Tiles.Position;
import Tiles.Unit;

public abstract class Player extends Unit {
    private final int ExpStarts = 0;
    private final int  LevelStarts=1;
    private int exp;
    private int level;

    public Player(Position pos, String name, Tiles.Health hp, int attackPoints, int defenePoints) {
        super('@', pos, name, hp, attackPoints, defenePoints);
        this.exp=ExpStarts;
        this.level=LevelStarts;
    }

    public void setExp(int exp) {
        if(exp==(50*level)){
            PlayerlevelUp();
        }
        else
            this.exp = exp;
    }

    private void PlayerlevelUp(){
        this.exp-=(50*this.level);
        this.level++;
        this.Health.hpOnLevelUp(level);
        this.attackPoints+=(4*level);
        this.defenePoints+=level;
    }
}
