package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Position;
import Bussines.Players.Player;

public class Wall extends Tile {
    public Wall(Position pos) {
        super('#', pos);
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
}
