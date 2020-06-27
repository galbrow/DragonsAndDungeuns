package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Helpers.Health;
import Bussines.Helpers.Position;
import Bussines.Helpers.SelectRandomNumber;
import Bussines.Players.Player;

import java.util.Random;

public class Unit extends Tile {
    protected String Name;
    protected Bussines.Helpers.Health Health;
    protected int attackPoints;
    protected int defenePoints;
    protected SelectRandomNumber chooseRandomNumber=(int limit)->{
        Random rand=new Random();
        return rand.nextInt(limit);
    };

    public Unit(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints) {
        super(character, pos);
        Name = name;
        this.Health = hp;
        this.attackPoints = attackPoints;
        this.defenePoints = defenePoints;
    }
    //returns true if this unit b defeated
    public boolean Combat(Unit b){
        int attDamage=this.chooseRandomNumber.SelectRandomNumberInRange(attackPoints);
        int defense=b.chooseRandomNumber.SelectRandomNumberInRange(b.defenePoints);
        int result=attDamage-defense;
        if(result>0)
            return b.getHealth().ReduceCurrHealth(result);
        return false;
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
    public String describe(){
        return "";
    }

    @Override
    public void movmentOn(Player unit) {

    }

    @Override
    public void movmentOn(Enemy unit) {

    }

    @Override
    public String toString() {
        return ""+character;
    }
}
