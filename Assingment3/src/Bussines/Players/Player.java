package Bussines.Players;
import Bussines.Enemies.Enemy;
import Bussines.*;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Unit;
import GameView.MessageHandler;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Unit implements Observer {
    private final int ExpStarts = 0;
    private final int  LevelStarts=1;
    protected int exp;
    protected int level;
    protected String _abilityName;
    protected int _abilityRange;
    protected int _abilityDamage;
    protected List<Enemy> AllEnemiesInRange;
    protected List<Enemy> AllEnemiesOnBoard;
    protected Board board;

    public Player(Position pos, String name, Health hp, int attackPoints, int defenePoints, MessageHandler m) {
        super('@',pos, name, hp, attackPoints, defenePoints,m);
        this.exp=ExpStarts;
        this.level=LevelStarts;
        this.pos=pos;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    //raise the current exp of player each time enemy die
    public void RaiseExp(int exp) {
        this.exp+=exp;
        if(this.exp>=(50*level)){
            cmd.sendMessage(this.Name+" reached level "+(level+1));
            UponLevelingUp();
        }
    }

    public abstract void OnGameTick();

    //invoke each time player level up
    public void UponLevelingUp(){
        this.exp-=(50*this.level);
        this.level++;
        this.Health.hpOnLevelUp(level);
        this.attackPoints+=(4*level);
        this.defenePoints+=level;
    }

    public abstract void OnAbilityCast();

    //function of visitor pattern. when a enemy try to combat with player
    @Override
    public boolean movmentOn(Enemy unit) {
        if(unit.Combat(this)){
            this.character='X';
            cmd.sendMessage(board.toString());
            throw new NullPointerException("GAME OVER");
        }
        return false;
    }

    public int get_abilityRange() {
        return _abilityRange;
    }
    //get all types of enemies in the board and return all the enemies in player range
    public void setAllEnemiesInRange() {
        List<Enemy> AllEnemiesInRange2=new ArrayList<>();
        for (int i=0;i<AllEnemiesOnBoard.size();i++) {
            Enemy enemy=AllEnemiesOnBoard.get(i);
            if(!enemy.isAlive()){
                AllEnemiesOnBoard.remove(i);
                i--;
            }
            if(enemy.Range(this.pos)<this._abilityRange)
                AllEnemiesInRange2.add(enemy);
        }
        AllEnemiesInRange = AllEnemiesInRange2;
    }

    public void setAllEnemiesOnBoard(List<Enemy> allEnemiesOnBoard) {
        AllEnemiesOnBoard = allEnemiesOnBoard;
    }

    @Override
    public boolean movmentOn(Tile tile) {
        return tile.movmentOn(this);
    }

    @Override
    public boolean update(char x) {
        setAllEnemiesInRange();
        board.movement(this, x);
        OnGameTick();
        setAllEnemiesInRange();
        return false;
    }
}
