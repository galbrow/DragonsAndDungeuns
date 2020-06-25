package Players;
import Tiles.Position;

public class Warrior extends Player {
    private int cooldown_total;
    private int cooldown_remaining;

    public Warrior(Position pos, String name, Tiles.Health hp, int attackPoints, int defenePoints, int cooldown_total) {
        super(pos, name, hp, attackPoints, defenePoints);
        this.cooldown_total = cooldown_total;
        this.cooldown_remaining = 0;
    }

    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Cooldown: "+cooldown_remaining+"\\"+cooldown_total;
    }
}
