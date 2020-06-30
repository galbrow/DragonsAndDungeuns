package Bussines.Enemies;
import Bussines.Players.Player;
import Bussines.Position;
import GameView.MessageHandler;
import Bussines.Board;

public class Trap extends Enemy {
    private int _visibilitiTime;
    private int _invisibilityTime;
    private int _ticksCount;
    private boolean _visible;
    public Trap(char character, Position pos, String name, Bussines.Health hp, int attackPoints, int defenePoints, int visibletime, int invisibletime, int exp, MessageHandler cmd, Player player, Board board) {
        super(character, pos, name, hp, attackPoints, defenePoints, exp,cmd,player);
        this._visibilitiTime=visibletime;
        this._invisibilityTime=invisibletime;
        this._visible=true;
        this._ticksCount=0;
        this.board=board;
    }

    @Override
    public char OnEnemyTurn(Player player) {
        _visible=(_ticksCount<_visibilitiTime);
        if(_ticksCount==(_visibilitiTime+_invisibilityTime))
            _ticksCount=0;
        else
            _ticksCount++;
        if(Range(player.getPos())<2) {
            Combat(player);
        }
        return 'q';
    }

    @Override
    public String toString() {
        if(_visible)
            return ""+character;
        return ""+'.';
    }
}
