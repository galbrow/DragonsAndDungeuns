package Enemies;

import Helpers.Health;
import Helpers.Position;
import Tiles.Unit;

import java.util.List;

public class Trap extends Enemy {
    private int _visibilitiTime;
    private int _invisibilityTime;
    private int _ticksCount;
    private boolean _visible;
    public Trap(char character, Position pos, String name, Helpers.Health hp, int attackPoints, int defenePoints, List<Unit> allUnits, int visibletime,int invisibletime) {
        super(character, pos, name, hp, attackPoints, defenePoints, allUnits);
        this._visibilitiTime=visibletime;
        this._invisibilityTime=invisibletime;
        this._visible=true;
        this._ticksCount=0;
    }

    @Override
    public String describe() {
        return Name;
        //todo check if need to describe only name
    }

    @Override
    public void OnEnemyTurn(Position pos) {
        _visible=(_ticksCount<_visibilitiTime);
        if(_ticksCount==(_visibilitiTime+_invisibilityTime))
            _ticksCount=0;
        else
            _ticksCount++;
        if(Range(this.pos,pos)<2) {
            //todo attack player
        }
    }
}
