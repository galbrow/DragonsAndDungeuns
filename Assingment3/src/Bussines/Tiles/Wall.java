package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Position;
import Bussines.Players.Player;
import GameView.MessageHandler;

public class Wall extends Tile {
    public Wall(Position pos,MessageHandler m) {
        super('#', pos,m);
    }

    @Override
    public boolean movmentOn(Enemy unit) {
        return false;
    }

    @Override
    public boolean movmentOn(Player unit) {
        return false;
    }

    @Override
    public boolean movmentOn(Tile tile) {
        return false;
    }

    @Override
    public boolean update(char x) {
        return false;
    }
}
