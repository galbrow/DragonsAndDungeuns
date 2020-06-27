package Bussines.Players;
import Bussines.Enemies.Enemy;
import Bussines.Helpers.Position;
import Bussines.Tiles.Unit;
import com.sun.org.apache.xalan.internal.xsltc.runtime.MessageHandler;

import java.util.List;

public abstract class Player extends Unit {
    private final int ExpStarts = 0;
    private final int  LevelStarts=1;
    protected int exp;
    protected int level;
    protected String _abilityName;
    protected int _abilityRange;
    protected int _abilityDamage;
    protected List<Unit> AllUnitsInRange;
    protected MessageHandler m;
    public Player(Position pos, String name, Bussines.Helpers.Health hp, int attackPoints, int defenePoints) {
        super('@',pos, name, hp, attackPoints, defenePoints);
        this.exp=ExpStarts;
        this.level=LevelStarts;
        this.pos=pos;
        //todo message handler
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

    @Override
    public void movmentOn(Enemy unit) {
        super.movmentOn(unit);
        if(Combat(unit)){
            Position position=this.pos;
            this.pos=position;
            unit.setPos(position);
        }
    }
}
