package Bussines.Players;

import Bussines.Enemies.Enemy;
import Bussines.Tiles.Unit;
import Bussines.Position;

public class Rogue extends Player {
    private final int MaximumEnergy=100;
    private int _cost;
    private int _currentEnergy;
    public Rogue(Position pos, String name, Bussines.Health hp, int attackPoints, int defenePoints, int cost) {
        super(pos, name, hp, attackPoints, defenePoints);
        this._abilityName="Fan of Knives";
        this._abilityRange=2;
        this._abilityDamage=attackPoints;
        this._cost=cost;
        this._currentEnergy=MaximumEnergy;
    }

    @Override
    public void UponLevelingUp() {
        super.UponLevelingUp();
        _currentEnergy=MaximumEnergy;
        attackPoints+=(3*level);
        this._abilityDamage=attackPoints;
    }

    @Override
    public void OnGameTick() {
        _currentEnergy=Math.min(_currentEnergy+10,MaximumEnergy);
    }

    @Override
    public void OnAbilityCast() {
        cmd.sendMessage(this.Name+" Cast "+this._abilityName);
        if(_currentEnergy<_cost)
            cmd.sendMessage("cannot use "+_abilityName+" since the current energy is lower than the cost");
        else {
            _currentEnergy-=_cost;
            for (Enemy a: AllEnemiesInRange) {
                int defense=this.chooseRandomNumber.SelectRandomNumberInRange(a.getDefenePoints());
                int result=attackPoints-defense;
                if(result>=0){
                    if(a.getHealth().ReduceCurrHealth(result)){
                        cmd.sendMessage(a.getName()+" died. "+ this.Name+" gained "+a.getExp()+" experience");
                        RaiseExp(a.getExp());
                    }
                }
            }
        }
    }

    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Energy: "+ _currentEnergy +"\\"+ MaximumEnergy +"\t Spell Power: "+_abilityDamage;
    }
}