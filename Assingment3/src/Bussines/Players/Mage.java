package Bussines.Players;

import Bussines.*;
import Bussines.Tiles.Unit;

public class Mage extends Player {
    private int mp;
    private int currentMana;
    private int manaCost;
    private int hitsCount;
    public Mage(Position pos, String name, Health hp, int attackPoints, int defenePoints, int range, int spellPower, int mp, int hitsCounts, int manaCost) {
        super(pos, name, hp, attackPoints, defenePoints);
        this._abilityName="Blizzard";
        this._abilityRange=range;
        this._abilityDamage=spellPower;
        this.mp=mp;
        this.currentMana=mp/4;
        this.hitsCount=hitsCounts;
        this.manaCost=manaCost;
    }

    @Override
    public void UponLevelingUp() {
        super.UponLevelingUp();
        this.mp+=(25*level);
        this.currentMana=Math.min(currentMana+mp/4,mp);
        this._abilityDamage+=(10*level);
    }

    @Override
    public void OnGameTick() {
        this.currentMana=Math.min(mp,currentMana+level);
    }

    @Override
    public String OnAbilityCast() {
        String message="";
        if(currentMana<manaCost)
            message="cannot use "+_abilityName+" since the current mana is lower than the cost";
        else{
            this.currentMana-=manaCost;
            int hits=0;
            while (hits<hitsCount && AllEnemiesInRange.size()>0){
                int num=chooseRandomNumber.SelectRandomNumberInRange(AllEnemiesInRange.size()-1);
                Unit chosen= AllEnemiesInRange.get(num);
                if(chosen.getHealth().ReduceCurrHealth(_abilityDamage))
                    AllEnemiesInRange.remove(chosen);
                }
                hits++;
            }
        //todo
        //how each enemy may try to defense itself
        //add to message
        return message;
    }
    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Mana: "+ currentMana +"\\"+ mp+"\t Spell Power: "+_abilityDamage;
    }
}
