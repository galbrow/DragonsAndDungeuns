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
        return Name;
        //todo check if need to describe only name
    }

    @Override
    public void OnEnemyTurn(Position player) {
        if(Range(player,this.pos)<visionRange){
            int dx=pos.getX()-player.getX();
            int dy=pos.getY()-player.getY();
            if(Math.abs(dx)>Math.abs(dy)){
                if(dx>0)
                    pos.setX(pos.getX()-1);
                else
                    pos.setY(pos.getX()-1);
            }
            else{
                if(dy>0)
                    pos.setY(pos.getY()-1);
                else
                    pos.setY(pos.getY()+1);
            }
        }
        else {
            //todo random movement action
        }
    }
}
