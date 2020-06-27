package Bussines.Players;
import Bussines.Helpers.*;
import Bussines.Helpers.Position;

public class Warrior extends Player {
    private int _totalCooldown;
    private int _remainingCooldown;
    private int _heal;

    public Warrior(Position pos, String name, Bussines.Helpers.Health hp, int attackPoints, int defenePoints, int _totalCooldown) {
        super(pos, name, hp, attackPoints, defenePoints);
        this._totalCooldown = _totalCooldown;
        this._remainingCooldown = 0;
        this._abilityName="Avenger's Shield";
        this._abilityDamage=(int)(0.1* Health.getHp());
        this._heal=10*defenePoints;
        this._abilityRange=3;
    }

    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Cooldown: "+ _remainingCooldown +"\\"+ _totalCooldown;
    }
    @Override
    public  void UponLevelingUp(){
        PlayerlevelUp();
        this._remainingCooldown =0;
        this.Health.RaiseHp(5*level);
        attackPoints+=(2*level);
        defenePoints+=level;
        _abilityDamage=((int)(0.1* Health.getHp()));
        _heal=(10*defenePoints);
    }

    @Override
    public String OnAbilityCast() {
        String message="";
        if(_remainingCooldown >0){
            message="cannot use"+_abilityName+", "+ _remainingCooldown +" game tick remaining for cooldown";
        }
        else {
            _remainingCooldown=_totalCooldown;
            this.Health.RaiseCurrHealth(_heal);
            //todo
            //how the hit works
        }
        return message;
    }

    @Override
    public void OnGameTick() {
        _remainingCooldown--;
    }

}