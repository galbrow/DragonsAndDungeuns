package Tiles;

import Helpers.*;

import java.util.Random;

public abstract class Tile {
    protected char character;
    protected Position pos;

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

    /*
    public abstract void movmentOn(Wall wall);
    public abstract void movmentOn(Unit unit);
    public abstract void movmentOn(Empty empty);
     */

    @Override
    public String toString() {
        return ""+this.character;
    }

}
