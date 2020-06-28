package Bussines.Enemies;
import Bussines.Enemies.Enemy;
import Bussines.*;

public class Monster extends Enemy {
    private int visionRange;

    public Monster(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints, int visionRange, int exp) {
        super(character, pos, name, hp, attackPoints, defenePoints,exp);
        this.visionRange = visionRange;
    }

    @Override
    public String describe() {
        return Name+" health: "+this.Health.toString();
        //todo check if need to describe only name
    }

    @Override
    public char OnEnemyTurn(Position player) {
        if(Range(player)<visionRange){
            int dx=pos.getX()-player.getX();
            int dy=pos.getY()-player.getY();
            if(Math.abs(dx)>Math.abs(dy)){
                if(dx>0)
                    return 'a';
                else
                    return 'd';
            }
            else{
                if(dy>0)
                    return 'w';
                else
                    return 's';
            }
        }
        else {
            int a=chooseRandomNumber.SelectRandomNumberInRange(3);
            switch (a){
                case 0:
                    return 'a';
                case 1:
                    return 'd';
                case 2:
                    return 's';
                case 3:
                    return 'w';
            }
            return 'q';
        }
    }
}
