package Bussines.Enemies;
import Bussines.Helpers.Position;
import Bussines.Tiles.Unit;

public abstract class Enemy extends Unit {
    private int exp;

    public Enemy(char character, Position pos, String name, Bussines.Helpers.Health hp, int attackPoints, int defenePoints, int exp) {
        super(character, pos, name, hp, attackPoints, defenePoints);
        this.exp=exp;
    }

    public int getExp() {
        return exp;
    }
    public abstract void OnEnemyTurn(Position pos);
}
