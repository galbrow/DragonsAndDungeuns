package Bussines.Players;

import Bussines.*;
import Bussines.Enemies.Enemy;
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
    public void OnAbilityCast() {
        cmd.sendMessage(this.Name+" Cast "+this._abilityName);
        String message="";
        if(currentMana<manaCost)
            cmd.sendMessage("cannot use "+_abilityName+" since the current mana is lower than the cost");
        else{
            this.currentMana-=manaCost;
            int hits=0;
            while (hits<hitsCount && AllEnemiesInRange.size()>0){
                int num=0;
                if(AllEnemiesInRange.size()>1)
                    num=chooseRandomNumber.SelectRandomNumberInRange(AllEnemiesInRange.size());
                Enemy chosen= AllEnemiesInRange.get(num);
                int defense=this.chooseRandomNumber.SelectRandomNumberInRange(chosen.getDefenePoints());
                if(chosen.getHealth().ReduceCurrHealth(_abilityDamage-defense)) {
                    AllEnemiesInRange.remove(chosen);
                    cmd.sendMessage(chosen.getName()+" died. "+ this.Name+" gained "+chosen.getExp()+" experience");
                    RaiseExp(chosen.getExp());
                }
                hits++;
            }
        }
    }
    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Mana: "+ currentMana +"\\"+ mp+"\t Spell Power: "+_abilityDamage;
    }
}
