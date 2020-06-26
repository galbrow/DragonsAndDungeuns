package Enemies;
import Helpers.Position;
import Tiles.Unit;

import java.util.List;

public abstract class Enemy extends Unit {
    private int exp;

    public Enemy(char character, Position pos, String name, Helpers.Health hp, int attackPoints, int defenePoints, List<Unit> allUnits) {
        super(character, pos, name, hp, attackPoints, defenePoints,allUnits);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
