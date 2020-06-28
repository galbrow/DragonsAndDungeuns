package Bussines;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean AreSame(int x,int y) {
        return(this.x==x&&this.y==y);
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}