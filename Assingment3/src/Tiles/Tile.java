package Tiles;

public class Tile {
    private char character;
    private Position pos;

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
}
