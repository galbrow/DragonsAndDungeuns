package Enemies;

import Helpers.Position;
import Tiles.Unit;

import java.util.List;

public class Monster extends Enemy {
    private int visionRange;

    public Monster(char character, Position pos, String name, Helpers.Health hp, int attackPoints, int defenePoints, int visionRange, List<Unit> allUnits) {
        super(character, pos, name, hp, attackPoints, defenePoints,allUnits);
        this.visionRange = visionRange;
    }

    @Override
    public String describe() {
        return null;
    }
}
