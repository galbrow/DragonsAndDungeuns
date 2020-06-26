package Players;
import Helpers.Position;
import Helpers.SelectRandomUnit;
import Tiles.Unit;
import java.util.List;
import java.util.Random;

public abstract class Player extends Unit{
    private final int ExpStarts = 0;
    private final int  LevelStarts=1;
    protected int exp;
    protected int level;
    protected String _abilityName;
    protected int _abilityRange;
    protected int _abilityDamage;
    protected SelectRandomUnit chooseRandom=(AllUnitsInRange)->{
        Random rand=new Random();
        int a=rand.nextInt(AllUnitsInRange.size());
        return AllUnitsInRange.get(a);
    };

    public Player(Position pos, String name, Helpers.Health hp, int attackPoints, int defenePoints, List<Unit> allUnits) {
        super('@', pos, name, hp, attackPoints, defenePoints,allUnits);
        this.exp=ExpStarts;
        this.level=LevelStarts;
    }

    public void setExp(int exp) {
        if(exp==(50*level)){
            PlayerlevelUp();
        }
        else
            this.exp = exp;
    }

    protected void PlayerlevelUp(){
        this.exp-=(50*this.level);
        this.level++;
        this.Health.hpOnLevelUp(level);
        this.attackPoints+=(4*level);
        this.defenePoints+=level;
    }
    public abstract void OnGameTick();
    public abstract void UponLevelingUp();
    public abstract String OnAbilityCast();
}
