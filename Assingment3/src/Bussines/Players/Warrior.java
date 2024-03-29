package Bussines.Players;
import Bussines.*;
import Bussines.Enemies.Enemy;
import Bussines.Tiles.Unit;
import GameView.MessageHandler;

public class Warrior extends Player {
    private int _totalCooldown;
    private int _remainingCooldown;
    private int _heal;

    public Warrior(Position pos, String name, Health hp, int attackPoints, int defenePoints, int _totalCooldown, MessageHandler m) {
        super(pos, name, hp, attackPoints, defenePoints,m);
        this._totalCooldown = _totalCooldown;
        this._remainingCooldown = 0;
        this._abilityName="Avenger's Shield";
        this._abilityDamage=(int)(0.1* Health.getHp());
        this._heal=10*defenePoints;
        this._abilityRange=3;
    }

    //prints the warrior details
    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Cooldown: "+ _remainingCooldown +"\\"+ _totalCooldown+"\t Level: "+this.level;
    }

    //invoke when player level up
    @Override
    public void UponLevelingUp() {
        super.UponLevelingUp();
        this._remainingCooldown =0;
        this.Health.RaiseHp(5*level);
        attackPoints+=(2*level);
        defenePoints+=level;
        _abilityDamage=((int)(0.1* Health.getHp()));
        _heal=(10*defenePoints);
        this.Health.hpOnLevelUp(level);
    }

    //case warrior special ability
    @Override
    public void OnAbilityCast() {
        cmd.sendMessage(this.Name+" Cast "+this._abilityName);
        if(_remainingCooldown >0){
            cmd.sendMessage("cannot use"+_abilityName+", "+ _remainingCooldown +" game tick remaining for cooldown");
        }
        else {
            _remainingCooldown=_totalCooldown;
            this.Health.RaiseCurrHealth(_heal);
            if (AllEnemiesInRange.size()>0) {
                int num = chooseRandomNumber.SelectRandomNumberInRange(AllEnemiesInRange.size());
                Enemy chosen = AllEnemiesInRange.get(num);
                int amount = (int) (this.Health.getHp() * 0.1);
                if (chosen.getHealth().ReduceCurrHealth(amount)) {
                    AllEnemiesInRange.remove(chosen);
                    cmd.sendMessage(chosen.getName() + " died. " + this.Name + " gained " + chosen.getExp() + " experience");
                    RaiseExp(chosen.getExp());
                }
            }
        }
    }

    //updates every round
    @Override
    public void OnGameTick() {
        if(_remainingCooldown>0)
            _remainingCooldown--;
    }

    public int get_remainingCooldown() {
        return _remainingCooldown;
    }

    public int get_totalCooldown() {
        return _totalCooldown;
    }
}