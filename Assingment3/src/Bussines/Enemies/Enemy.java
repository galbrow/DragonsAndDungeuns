package Bussines.Enemies;
import Bussines.*;
import Bussines.Players.Player;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Unit;
import GameView.MessageHandler;

public abstract class Enemy extends Unit implements Observer {
    private int exp;
    protected Board board;
    protected Player player;

    public Enemy(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints, int exp, MessageHandler m,Player player) {
        super(character, pos, name, hp, attackPoints, defenePoints,m);
        this.exp=exp;
        this.player=player;
    }

    public void setPlayer(Player player) { this.player = player; }

    public int getExp() {
        return exp;
    }

    public abstract char OnEnemyTurn(Player player);

    @Override
    public String describe() {
        return Name+" health: "+this.Health.toString();
    }

    @Override
    public boolean movmentOn(Player unit) {
        if(unit.Combat(this)) {
            Position position = this.pos;
            this.pos = unit.getPos();
            unit.setPos(position);
            cmd.sendMessage(this.Name+" died. "+ unit.getName()+" gained "+this.exp+" experience");
            unit.RaiseExp(this.exp);
            return true;
        }
        return false;
    }

    @Override
    public boolean movmentOn(Tile tile) {
        return tile.movmentOn(this);
    }

    @Override
    public boolean update(char x) {
        if (!isAlive()) {
            board.makeEmpty(pos.getX(), pos.getY());
            return true;
        } else {
            char enemyMove = OnEnemyTurn(player);
            board.movement(this, enemyMove);
            return false;
        }
    }
}
