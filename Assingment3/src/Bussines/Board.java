package Bussines;

import Bussines.Enemies.Monster;
import Bussines.Enemies.Trap;
import Bussines.Helpers.Health;
import Bussines.Helpers.Position;
import Bussines.Players.Mage;
import Bussines.Players.Player;
import Bussines.Players.Rogue;
import Bussines.Players.Warrior;
import Bussines.Tiles.Empty;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Wall;
import GameView.MessageHandler;

import java.util.*;

public class Board {
    private Tile[][] Board;
    private ArrayList allUnits;
    public Board(List<String> board, MessageHandler m,Player player){
        this.allUnits=new ArrayList();
        this.Board=new Tile[board.size()][board.get(0).length()];
        for(int i=0;i<Board.length;i++)
            for(int j=0;j<Board[0].length;j++){
                Board[i][j]=getTileByChar(board.get(i).charAt(j),new Position(i,j),player);
            }
    }

    public Tile getTileByChar(char a,Position pos,Player player){
        Tile t=null;
        switch (a){
            case 's':
                t=new Monster(a,pos,"Lannister Solider",new Health(80),8,3,3,25);
                break;
            case 'k':
                t=new Monster(a,pos,"Lannister Knight",new Health(200),14,8,4,50);
                break;
            case 'q':
                t=new Monster(a,pos,"Queen’s Guard",new Health(400),20,15,5,100);
                break;
            case 'z':
                t=new Monster(a,pos,"Wright",new Health(600) ,30 ,15 ,3 ,100);
                break;
            case 'b':
                t=new Monster(a,pos,"Bear-Wright", new Health(1000) ,75, 30, 4, 250);
                break;
            case 'g':
                t=new Monster(a,pos,"Giant-Wright",new Health(1500),100 ,40 ,5 ,500);
                break;
            case 'w':
                t=new Monster(a,pos,"White Walker",new Health(2000),150 ,50 ,6 ,1000);
                break;
            case 'M':
                t=new Monster(a,pos,"The Mountain",new Health(1000),60 ,25 ,6 ,500);
                break;
            case 'C':
                t=new Monster(a,pos,"Queen Cersei",new Health(100),10 ,10 ,1 ,1000);
                break;
            case 'K':
                t=new Monster(a,pos,"Night’s King",new Health(5000),300 ,150 ,8 ,5000);
                break;
            case 'B':
                t=new Trap(a,pos,"Bonus Trap", new Health(1),1,1,1,5,250);
                break;
            case 'Q':
                t=new Trap(a,pos,"Queen’s Trap",new Health(250),50,10,3,7,100);
                break;
            case 'D':
                t=new Trap(a,pos,"Death Trap",new Health(500),100,20,1,10,250);
                break;
            case '.':
                t=new Empty(pos);
                break;
            case '#':
                t=new Wall(pos);
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
}
