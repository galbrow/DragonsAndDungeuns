package Enemies;
import Tiles.Health;
import Tiles.Position;
import Tiles.Unit;

public abstract class Enemy extends Unit {
    private int exp;

    public Enemy(char character, Position pos, String name, Tiles.Health hp, int attackPoints, int defenePoints) {
        super(character, pos, name, hp, attackPoints, defenePoints);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
