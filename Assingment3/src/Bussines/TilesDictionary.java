package Bussines;
import Bussines.Enemies.Monster;
import Bussines.Enemies.Trap;
import Bussines.Players.*;
import Bussines.Tiles.Empty;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Wall;
import GameView.MessageHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TilesDictionary {
    private MessageHandler cmd;
    private List<Player> AllPlayers;
    private Scanner scan=new Scanner(System.in);

    public TilesDictionary(MessageHandler m){
        this.cmd=m;
    }

    //calls the user to choose any character from current
    public Player setPlayer(){
        Position pos=new Position(0,0);
        this.AllPlayers=new ArrayList<>();
        AllPlayers.add(0,new Warrior(pos,"Jon Snow",new Health(300),30,4,3, cmd));
        AllPlayers.add(1,new Warrior(pos,"The Hound",new Health(400),20,6,5, cmd));
        AllPlayers.add(2,new Mage(pos,"Melisandre",new Health(100),5,1,6,15,300,5,30, cmd));
        AllPlayers.add(3,new Mage(pos,"Thoros of Myr",new Health(250),25,4,4,20,150,4,20, cmd));
        AllPlayers.add(4,new Rogue(pos,"Arya Stark",new Health(150),40,2,20, cmd));
        AllPlayers.add(5,new Rogue(pos,"Bronn",new Health(250),40,3,50, cmd));
        AllPlayers.add(6,new Hunter(pos,"Ygritte",new Health(220), 30, 2, 6, cmd));
        cmd.sendMessage("Select player:");
        int i=1;
        for (Player player:AllPlayers) {
            cmd.sendMessage(i+ " " + player.describe());
            i++;
        }
        int choice=-1;
        while (choice<1||choice>AllPlayers.size())
            choice=scan.nextInt();
        Player player=AllPlayers.get(choice-1);
        cmd.sendMessage("You have selected:");
        cmd.sendMessage(player.getName());
        return player;
    }

    public Tile getTileByChar(char a, Position pos, Player player,Board board) {
        Tile t = null;
        switch (a) {
            case 's':
                t = new Monster(a, pos, "Lannister Solider", new Health(80), 8, 3, 3, 25, cmd,player,board);
                break;
            case 'k':
                t = new Monster(a, pos, "Lannister Knight", new Health(200), 14, 8, 4, 50, cmd,player,board);
                break;
            case 'q':
                t = new Monster(a, pos, "Queen’s Guard", new Health(400), 20, 15, 5, 100, cmd,player,board);
                break;
            case 'z':
                t = new Monster(a, pos, "Wright", new Health(600), 30, 15, 3, 100, cmd,player,board);
                break;
            case 'b':
                t = new Monster(a, pos, "Bear-Wright", new Health(1000), 75, 30, 4, 250, cmd,player,board);
                break;
            case 'g':
                t = new Monster(a, pos, "Giant-Wright", new Health(1500), 100, 40, 5, 500, cmd,player,board);
                break;
            case 'w':
                t = new Monster(a, pos, "White Walker", new Health(2000), 150, 50, 6, 1000, cmd,player,board);
                break;
            case 'M':
                t = new Monster(a, pos, "The Mountain", new Health(1000), 60, 25, 6, 500, cmd,player,board);
                break;
            case 'C':
                t = new Monster(a, pos, "Queen Cersei", new Health(100), 10, 10, 1, 1000, cmd,player,board);
                break;
            case 'K':
                t = new Monster(a, pos, "Night’s King", new Health(5000), 300, 150, 8, 5000, cmd,player,board);
                break;
            case 'B':
                t = new Trap(a, pos, "Bonus Trap", new Health(1), 1, 1, 1, 5, 250, cmd,player,board);
                break;
            case 'Q':
                t = new Trap(a, pos, "Queen’s Trap", new Health(250), 50, 10, 3, 7, 100, cmd,player,board);
                break;
            case 'D':
                t = new Trap(a, pos, "Death Trap", new Health(500), 100, 20, 1, 10, 250, cmd,player,board);
                break;
            case '.':
                t = new Empty(pos, cmd);
                break;
            case '#':
                t = new Wall(pos, cmd);
                break;
            case '@':
                t = player;
                t.setPos(pos);
                break;
        }
        return t;
    }
}
