package Tiles;

public abstract class Unit extends Tile {
    protected String Name;
    protected Health Health;
    protected int attackPoints;
    protected int defenePoints;

    public Unit(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints) {
        super(character, pos);
        Name = name;
        this.Health = hp;
        this.attackPoints = attackPoints;
        this.defenePoints = defenePoints;
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
