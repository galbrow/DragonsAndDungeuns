package Bussines;

import Bussines.Enemies.Enemy;
import Bussines.Helpers.Health;
import Bussines.Helpers.Position;
import Bussines.Players.Mage;
import Bussines.Players.Player;
import Bussines.Players.Rogue;
import Bussines.Players.Warrior;
import GameView.MessageHandler;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class GameRun {
    Scanner scan=new Scanner(System.in);
    private MessageHandler m;
    private Levels levels;
    private List<Player> AllPlayers;
    private Board board;
    private Player player;
    private ArrayList<Enemy> AllEnemies;

    public GameRun(MessageHandler m,Levels level) {
        this.m = m;
        this.levels=level;
        List<String> currentLevel=level.NextLevel();
        setAllPlayerType();
        board=new Board(currentLevel,m,player);
        this.AllEnemies=board.getAllUnits();
    }
    public void run(){
        m.sendMessage(board.toString());
        char a= scan.next().charAt(0);
    }

    public void setAllPlayerType(){
        Position pos=new Position(0,0);
        this.AllPlayers=new ArrayList<>();
        AllPlayers.add(0,new Warrior(pos,"Jon Snow",new Health(300),30,4,3));
        AllPlayers.add(1,new Warrior(pos,"The Hound",new Health(400),20,6,5));
        AllPlayers.add(2,new Mage(pos,"Melisandre",new Health(100),5,1,6,15,300,5,30));
        AllPlayers.add(3,new Mage(pos,"Thoros of Myr",new Health(250),25,4,4,20,150,4,20));
        AllPlayers.add(4,new Rogue(pos,"Arya Stark",new Health(150),40,2,20));
        AllPlayers.add(5,new Rogue(pos,"Bronn",new Health(250),40,3,50));
        m.sendMessage("Select player:");
        int i=1;
        for (Player player:AllPlayers) {
            m.sendMessage(i+ " " + player.describe());
            i++;
        }
        int choice=-1;
        while (choice<1||choice>AllPlayers.size())
            choice=scan.nextInt();
        player=AllPlayers.get(choice-1);
        m.sendMessage("You have selected:");
        m.sendMessage(player.getName());
    }
}
