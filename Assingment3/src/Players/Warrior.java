package Players;
import Tiles.Position;

public class Warrior extends Player {
    public Warrior(Position pos, String name, Tiles.Health hp, int attackPoints, int defenePoints) {
        super(pos, name, hp, attackPoints, defenePoints);
    }
    private int cooldown_total;
    private int cooldown_remaining;

}
