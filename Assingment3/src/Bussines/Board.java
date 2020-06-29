package Bussines;

import Bussines.Enemies.Monster;
import Bussines.Enemies.Trap;
import Bussines.Players.Player;
import Bussines.Tiles.Empty;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Unit;
import Bussines.Tiles.Wall;
import GameView.MessageHandler;

import java.util.*;

public class Board {
    private Tile[][] Board;
    private ArrayList allUnits;
    private MessageHandler cmd;
    private Player player;
    public Board(List<String> board, MessageHandler cmd, Player player){
        this.allUnits=new ArrayList();
        this.Board=new Tile[board.size()][board.get(0).length()];
        this.cmd = cmd;
        for(int i=0;i<Board.length;i++)
            for(int j=0;j<Board[0].length;j++){
                Board[i][j]=getTileByChar(board.get(i).charAt(j),new Position(j,i),player);
                this.player=player;
            }
    }

    //convert each char from the level string to tile
    public Tile getTileByChar(char a,Position pos,Player player){
        Tile t=null;
        switch (a){
            case 's':
                t=new Monster(a,pos,"Lannister Solider",new Health(80),8,3,3,25, cmd);
                break;
            case 'k':
                t=new Monster(a,pos,"Lannister Knight",new Health(200),14,8,4,50, cmd);
                break;
            case 'q':
                t=new Monster(a,pos,"Queen’s Guard",new Health(400),20,15,5,100, cmd);
                break;
            case 'z':
                t=new Monster(a,pos,"Wright",new Health(600) ,30 ,15 ,3 ,100, cmd);
                break;
            case 'b':
                t=new Monster(a,pos,"Bear-Wright", new Health(1000) ,75, 30, 4, 250, cmd);
                break;
            case 'g':
                t=new Monster(a,pos,"Giant-Wright",new Health(1500),100 ,40 ,5 ,500, cmd);
                break;
            case 'w':
                t=new Monster(a,pos,"White Walker",new Health(2000),150 ,50 ,6 ,1000, cmd);
                break;
            case 'M':
                t=new Monster(a,pos,"The Mountain",new Health(1000),60 ,25 ,6 ,500, cmd);
                break;
            case 'C':
                t=new Monster(a,pos,"Queen Cersei",new Health(100),10 ,10 ,1 ,1000, cmd);
                break;
            case 'K':
                t=new Monster(a,pos,"Night’s King",new Health(5000),300 ,150 ,8 ,5000, cmd);
                break;
            case 'B':
                t=new Trap(a,pos,"Bonus Trap", new Health(1),1,1,1,5,250, cmd);
                break;
            case 'Q':
                t=new Trap(a,pos,"Queen’s Trap",new Health(250),50,10,3,7,100, cmd);
                break;
            case 'D':
                t=new Trap(a,pos,"Death Trap",new Health(500),100,20,1,10,250, cmd);
                break;
            case '.':
                t=new Empty(pos,cmd);
                break;
            case '#':
                t=new Wall(pos,cmd);
                break;
            case '@':
                t=player;
                t.setPos(pos);
                break;
        }
        if(a!='@'&&a!='.'&&a!='#')
            allUnits.add(t);
        return t;
    }

    @Override
    public String toString() {
        String toReturn="";
        for (int i=0;i<Board.length;i++) {
            for (int j = 0; j < Board[0].length; j++) {
                toReturn+=Board[i][j].toString();
            }
            toReturn+="\n";
        }
        return toReturn;
    }

    public ArrayList getAllUnits() {
        return allUnits;
    }


    public Tile getTile(int x,int y){
        return Board[y][x];
    }

    //replace between 2 tiles in the board
    public void Replace(int x1,int x2,int y1,int y2){
        Tile a=Board[y1][x1];
        Board[y1][x1]=Board[y2][x2];
        Board[y2][x2]=a;
    }

    //replace the current position with empty tile
    public void makeEmpty(int x,int y){
        Empty a=new Empty(new Position(x,y),cmd);
        Board[y][x]=a;
    }

    //makes a player move
    public void movement(Unit a, char move){
        int x=a.getPos().getX();
        int y=a.getPos().getY();
        if(move=='w')
            if(a.movmentOn(getTile(x,y-1)))
                Replace(x,x,y,y-1);
        if(move=='s')
            if(a.movmentOn(getTile(x,y+1)))
                Replace(x,x,y,y+1);
        if(move=='a')
            if(a.movmentOn(getTile(x-1,y)))
                Replace(x,x-1,y,y);
        if(move=='d')
            if(a.movmentOn(getTile(x+1,y)))
                Replace(x,x+1,y,y);
        if(move=='e')
                player.OnAbilityCast();
    }
}
