package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Helpers.Position;
import Bussines.Players.Player;

public class Wall extends Tile {
    public Wall(Position pos) {
        super('#', pos);
    }

    @Override
    public void movmentOn(Enemy unit) {

    }

    @Override
    public void movmentOn(Player unit) {

    }
}
