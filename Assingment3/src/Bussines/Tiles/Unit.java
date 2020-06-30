package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.*;
import Bussines.Players.Player;
import GameView.MessageHandler;

import java.util.Random;

public class Unit extends Tile {
    protected String Name;
    protected Health Health;
    protected int attackPoints;
    protected int defenePoints;
    protected SelectRandomNumber chooseRandomNumber=(int limit)->{
        Random rand=new Random();
        return rand.nextInt(limit);
    };

    public Unit(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints, MessageHandler m) {
        super(character, pos,m);
        Name = name;
        this.Health = hp;
        this.attackPoints = attackPoints;
        this.defenePoints = defenePoints;
    }
    //returns true if this unit b defeated
    public boolean Combat(Unit b){
        cmd.sendMessage(this.getName()+" engaged in combat with "+b.getName()+".");
        cmd.sendMessage(describe());
        cmd.sendMessage(b.describe());
        cmd.sendMessage(this.getName()+"attack"+b.getName());
        int attDamage=this.chooseRandomNumber.SelectRandomNumberInRange(attackPoints);
        int defense=b.chooseRandomNumber.SelectRandomNumberInRange(b.defenePoints);
        int result=attDamage-defense;
        cmd.sendMessage(this.Name+" rolled "+attDamage+" attack points.");
        cmd.sendMessage(b.getName()+" rolled "+defense+" defense points.");
        if(result>=0){
            cmd.sendMessage(this.Name+" dealt "+result+" to "+b.getName()+".");
            return b.getHealth().ReduceCurrHealth(result);
        }
        return false;
    }

    @Override
    public boolean movmentOn(Tile tile) { return false; }

    public String getName() {
        return Name;
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
    public boolean movmentOn(Player unit) { return true; }

    @Override
    public boolean movmentOn(Enemy unit) { return false; }

    @Override
    public String toString() {
        return ""+character;
    }

    public boolean isAlive(){
        return Health.isAlive();
    }

    public int getDefenePoints() {
        return defenePoints;
    }

    @Override
    public boolean update(char x) {
        return false;
    }
}

