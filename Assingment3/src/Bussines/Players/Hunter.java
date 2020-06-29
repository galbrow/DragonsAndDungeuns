package Bussines.Players;

import Bussines.Enemies.Enemy;
import Bussines.Health;
import Bussines.Position;
import GameView.MessageHandler;

import java.util.List;

public class Hunter extends Player {
    private Enemy closestEnemy;
    private int arrows;
    private int tickCounts;
    public Hunter(Position pos, String name, Bussines.Health hp, int attackPoints, int defenePoints, int range, MessageHandler m) {
        super(pos, name, hp, attackPoints, defenePoints,m);
        this._abilityName="Shoot";
        this._abilityDamage=attackPoints;
        this.arrows=10;
        this._abilityRange=range;
        this.tickCounts=0;
    }

    //updates each round
    @Override
    public void OnGameTick() {
        if(tickCounts==10){
            arrows+=level;
            tickCounts=0;
        }else{
            tickCounts++;
        }
    }

    //cast hunter special ability
    @Override
    public void OnAbilityCast() {
        cmd.sendMessage(this.Name+" Cast "+this._abilityName);
        if (arrows == 0)
            cmd.sendMessage("cannot use " + _abilityName + " since there is no arrows");
        else if (closestEnemy == null)
            cmd.sendMessage("cannot use " + _abilityName + " since there is no enemy in range");
        else {
            arrows--;
            int defense=this.chooseRandomNumber.SelectRandomNumberInRange(closestEnemy.getDefenePoints());
            int result=attackPoints-defense;
            if(result>=0){
                if(closestEnemy.getHealth().ReduceCurrHealth(result)){
                    cmd.sendMessage(closestEnemy.getName()+" died. "+ this.Name+" gained "+closestEnemy.getExp()+" experience");
                    RaiseExp(closestEnemy.getExp());
                }
            }
        }
    }

    //set the hunter closest enemy
    @Override
    public void setAllEnemiesInRange(List<Enemy> allEnemiesInRange) {
        super.setAllEnemiesInRange(allEnemiesInRange);
        if(this.AllEnemiesInRange.size()!=0){
            Enemy closest=AllEnemiesInRange.get(0);
            for (int i=0;i<AllEnemiesInRange.size();i++) {
                if (Range(AllEnemiesInRange.get(i).getPos()) < Range(closest.getPos()))
                    closest = AllEnemiesInRange.get(i);
                this.closestEnemy = closest;
            }
        }
        else this.closestEnemy=null;
    }

    @Override
    public void UponLevelingUp() {
        super.UponLevelingUp();
        this.arrows+=(10*level);
        this.attackPoints+=(2*level);
        this.defenePoints+=level;
    }

    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Arrows: "+ arrows +"\t Range: "+_abilityRange+"\t Level: "+this.level;
    }
}
