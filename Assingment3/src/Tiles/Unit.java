package Tiles;

import Helpers.Health;
import Helpers.Position;

import java.util.List;

public abstract class Unit extends Tile {
    protected String Name;
    protected Helpers.Health Health;
    protected int attackPoints;
    protected int defenePoints;
    protected List<Unit> AllUnitsInRange;

    public Unit(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints,List<Unit> allUnits) {
        super(character, pos);
        Name = name;
        this.Health = hp;
        this.attackPoints = attackPoints;
        this.defenePoints = defenePoints;
        this.AllUnitsInRange=allUnits;
    }

    public String getName() {
        return Name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefenePoints() {
        return defenePoints;
    }

    public Health getHealth() {
        return Health;
    }

    public void setHealth(Health health) {
        Health = health;
    }
    public abstract String describe();
}
