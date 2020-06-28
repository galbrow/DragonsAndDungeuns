package Bussines.Tiles;

import Bussines.Enemies.Enemy;
import Bussines.Position;
import Bussines.Players.Player;
import GameView.CmdPrinter;
import GameView.MessageHandler;

public abstract class Tile {
    protected char character;
    protected Position pos;
    protected static MessageHandler cmd=new CmdPrinter();

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

    public int Range(Position b) {
        int range=(int)Math.sqrt(Math.pow((double)this.pos.getX() - (double)b.getX(), 2) + Math.pow((double) this.pos.getY() - (double)b.getY(), 2));
        return range;
    }

    public abstract boolean movmentOn(Player unit);
    public abstract boolean movmentOn(Enemy unit);
    public abstract boolean movmentOn(Tile tile);

    @Override
    public String toString() {
        return ""+this.character;
    }

}
