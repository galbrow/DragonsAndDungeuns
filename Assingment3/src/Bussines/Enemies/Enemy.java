package Bussines.Enemies;
import Bussines.*;
import Bussines.Players.Player;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Unit;

public abstract class Enemy extends Unit {
    private int exp;

    public Enemy(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints, int exp) {
        super(character, pos, name, hp, attackPoints, defenePoints);
        this.exp=exp;
    }

    public int getExp() {
        return exp;
    }
    public abstract char OnEnemyTurn(Position pos);

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
}
