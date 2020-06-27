package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Helpers.*;
import Bussines.Helpers.Position;
import Bussines.Players.Player;
import GameView.CmdPrinter;
import GameView.MessageHandler;

public abstract class Tile {
    protected char character;
    protected Position pos;
    protected static MessageHandler m=new CmdPrinter();

    public Tile(char character, Position pos) {
        this.character = character;
        this.pos = pos;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public double Range(Position a, Position b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }


    public void movmentOn(Wall wall){}
    public abstract void movmentOn(Player unit);
    public void movmentOn(Empty empty){}
    public abstract void movmentOn(Enemy unit);



    @Override
    public String toString() {
        return ""+this.character;
    }

}
