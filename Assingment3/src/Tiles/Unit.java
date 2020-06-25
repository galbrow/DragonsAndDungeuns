package Tiles;

public class Unit extends Tile {
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

    public void setName(String name) {
        Name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefenePoints() {
        return defenePoints;
    }

    public void setDefenePoints(int defenePoints) {
        this.defenePoints = defenePoints;
    }

    public Health getHealth() {
        return Health;
    }

    public void setHealth(Health health) {
        Health = health;
    }
}
