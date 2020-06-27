package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Helpers.Position;
import Bussines.Players.Player;

public class Empty extends Tile {
    public Empty(Position pos) {
        super('.', pos);
    }

    @Override
    public void movmentOn(Enemy unit) {

    }

    @Override
    public void movmentOn(Player unit) {

    }
}
