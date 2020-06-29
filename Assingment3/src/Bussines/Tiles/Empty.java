package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.*;
import Bussines.Players.Player;
import GameView.MessageHandler;

public class Empty extends Tile {
    public Empty(Position pos, MessageHandler m) {
        super('.', pos,m);
    }

    @Override
    public boolean movmentOn(Enemy unit) {
        Position Pos=unit.pos;
        unit.setPos(this.pos);
        this.pos=Pos;
        return true;
    }

    @Override
    public boolean movmentOn(Tile tile) {
        return false;
    }

    @Override
    public boolean movmentOn(Player unit) {
        Position Pos=unit.pos;
        unit.setPos(this.pos);
        this.pos=Pos;
        return true;
    }
}
