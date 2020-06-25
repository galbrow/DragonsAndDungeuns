package Players;
import Abilities.WarriorAbility;
import Tiles.Position;

public class Warrior extends Player {
    private int _totalCooldown;
    private int _remainingCooldown;
    private WarriorAbility _ability;

    public Warrior(Position pos, String name, Tiles.Health hp, int attackPoints, int defenePoints, int _totalCooldown) {
        super(pos, name, hp, attackPoints, defenePoints);
        this._totalCooldown = _totalCooldown;
        this._remainingCooldown = 0;
        this._ability=new WarriorAbility((int)(0.1*Health.getHp()),10*defenePoints);
    }

    @Override
    public String describe() {
        return Name+"\t Health: "+Health+"\t Attack: "+attackPoints+ "\t Defense: "+defenePoints+"\t Experience: "+exp+"\\"+(50*level)+"\t Cooldown: "+ _remainingCooldown +"\\"+ _totalCooldown;
    }

    public  void UponLevelingUp(){
        PlayerlevelUp();
        this._remainingCooldown =0;
        this.Health.RaiseHp(5*level);
        attackPoints+=(2*level);
        defenePoints+=level;
        _ability.set_damage((int)(0.1*Health.getHp()));
        _ability.set_heal(10*defenePoints);
    }

    @Override
    public void OnAbilityCast() {
        if(_remainingCooldown >0){
            String message="cannot use Avenger's Shield, "+ _remainingCooldown +" game tick remaining for cooldown";
            System.out.println(message);
        }
        else {
            _remainingCooldown=_ability.get_resource();
            this.Health.RaiseCurrHealth(_ability.get_heal());
            //todo
        }
    }

    @Override
    public void OnGameTick() {
//todo
    }
}
