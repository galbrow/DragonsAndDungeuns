package Players;

import Helpers.*;
import Tiles.Unit;

import java.util.List;

public class Rogue extends Player {
    private final int MaximumEnergy=100;
    private int _cost;
    private int _currentEnergy;
    public Rogue(Position pos, String name, Helpers.Health hp, int attackPoints, int defenePoints, List<Unit> allUnits,int cost) {
        super(pos, name, hp, attackPoints, defenePoints, allUnits);
        this._abilityName="Fan of Knives";
        this._abilityRange=2;
        this._abilityDamage=attackPoints;
        this._cost=cost;
        this._currentEnergy=MaximumEnergy;
    }

    @Override
    public void UponLevelingUp() {
        _currentEnergy=MaximumEnergy;
        attackPoints+=(3*level);
        this._abilityDamage=attackPoints;
    }

    @Override
    public void OnGameTick() {
        _currentEnergy=Math.min(_currentEnergy+10,MaximumEnergy);
    }

    @Override
    public String OnAbilityCast() {
        String message="";
        if(_currentEnergy<_cost)
            message="cannot use "+_abilityName+" since the current energy is lower than the cost";
        else {
            _currentEnergy-=_cost;
            //todo combat in all units in range
            for (Unit a:AllUnitsInRange) {

            }
        }
        return message;
    }

    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Energy: "+ _currentEnergy +"\\"+ MaximumEnergy +"\t Spell Power: "+_abilityDamage;
    }
}
