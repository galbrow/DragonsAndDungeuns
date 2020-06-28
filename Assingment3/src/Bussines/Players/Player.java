package Bussines.Players;
import Bussines.Enemies.Enemy;
import Bussines.*;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Unit;
import com.sun.org.apache.xalan.internal.xsltc.runtime.MessageHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Unit {
    private final int ExpStarts = 0;
    private final int  LevelStarts=1;
    protected int exp;
    protected int level;
    protected String _abilityName;
    protected int _abilityRange;
    protected int _abilityDamage;
    protected List<Enemy> AllEnemiesInRange;
    protected MessageHandler m;
    public Player(Position pos, String name, Health hp, int attackPoints, int defenePoints) {
        super('@',pos, name, hp, attackPoints, defenePoints);
        this.exp=ExpStarts;
        this.level=LevelStarts;
        this.pos=pos;
    }

    public void RaiseExp(int exp) {
        this.exp+=exp;
        if(this.exp>=(50*level)){
            cmd.sendMessage(this.Name+" reached level "+(level+1));
            UponLevelingUp();
        }
    }

    public abstract void OnGameTick();

    public void UponLevelingUp(){
        this.exp-=(50*this.level);
        this.level++;
        this.Health.hpOnLevelUp(level);
        this.attackPoints+=(4*level);
        this.defenePoints+=level;
    }

    public abstract void OnAbilityCast();

    @Override
    public boolean movmentOn(Enemy unit) {
        if(unit.Combat(this)){
            this.character='X';
        }
        return false;
    }

    public int get_abilityRange() {
        return _abilityRange;
    }

    public void setAllEnemiesInRange(List<Enemy> allEnemies) {
        List<Enemy> AllEnemiesInRange2=new ArrayList<>();
        for (Enemy enemy:allEnemies) {
            if(enemy.Range(this.pos)<this._abilityRange)
                AllEnemiesInRange2.add(enemy);
        }
        AllEnemiesInRange = AllEnemiesInRange2;
    }

    @Override
    public boolean movmentOn(Tile tile) {
        return tile.movmentOn(this);
    }
}
