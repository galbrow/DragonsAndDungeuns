package Players;

import Helpers.Health;
import Helpers.Position;
import Tiles.Unit;

import java.util.List;

public class Mage extends Player {
    private int mp;
    private int currentMana;
    private int manaCost;
    private int hitsCount;
    public Mage(Position pos, Helpers.Health hp, int attackPoints, int defenePoints, List<Unit> allUnits,int range,int spellPower,int mp,int hitsCounts,int manaCost) {
        super(pos, "Mage", hp, attackPoints, defenePoints, allUnits);
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
        PlayerlevelUp();
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
            while (hits<hitsCount && AllUnitsInRange.size()>0){
            }
        }
        return message;
    }

    @Override
    public String describe() {
        return null;
    }
}
