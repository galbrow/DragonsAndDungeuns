package Enemies;

import Tiles.Position;

public class Monster extends Enemy {
    private int visionRange;

    public Monster(char character, Position pos, String name, Tiles.Health hp, int attackPoints, int defenePoints, int visionRange) {
        super(character, pos, name, hp, attackPoints, defenePoints);
        this.visionRange = visionRange;
    }

    @Override
    public String describe() {
        return null;
    }
}
