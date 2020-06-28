package Bussines;

import Bussines.Enemies.Enemy;
import Bussines.*;
import Bussines.Players.*;
import Bussines.Tiles.Unit;
import GameView.MessageHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRun {
    Scanner scan=new Scanner(System.in);
    private MessageHandler m;
    private Levels levels;
    private List<Player> AllPlayers;
    private Board board;
    private Player player;
    private List<Enemy> AllEnemies;
    private List<String> currentLevel;

    public GameRun(MessageHandler m,Levels level) {
        this.m = m;
        this.levels=level;
        currentLevel=level.NextLevel();
        setAllPlayerType();
        board=new Board(currentLevel,m,player);
        this.AllEnemies=board.getAllUnits();
    }
    public void run(){
        while(player.isAlive()&&AllEnemies.size()!=0){
            m.sendMessage(board.toString());
            //List<Enemy> AllEnemiesInRange=AllEnemies.stream().filter((x)->(x.Range(player.getPos())<player.get_abilityRange())).collect(Collectors.toList());
            player.setAllEnemiesInRange(AllEnemies);
            m.sendMessage(player.describe());
            char a= scan.next().charAt(0);
            movement(player,a);
            player.OnGameTick();
            for (int i=0;i<AllEnemies.size();i++) {
                Enemy enemy=AllEnemies.get(i);
                if(!enemy.isAlive()) {
                    board.makeEmpty(enemy.getPos().getX(), enemy.getPos().getY());
                    AllEnemies.remove(i);
                    i--;
                }
            }
            for (Enemy enemy:AllEnemies) {
                char enemyMove=enemy.OnEnemyTurn(player.getPos());
                movement(enemy,enemyMove);
            }
        }
        if(!player.isAlive()){
            player.setCharacter('X');
            m.sendMessage(board.toString());
            m.sendMessage("GAME OVER");
        }
        else{
            currentLevel=levels.NextLevel();
            if (currentLevel != null) {
                board = new Board(currentLevel, m, player);
                this.AllEnemies = board.getAllUnits();
                m.sendMessage("");
                run();
            }else {
                m.sendMessage(board.toString());
                m.sendMessage("You Won!");
            }
        }
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
        AllPlayers.add(6,new Hunter(pos,"Ygritte",new Health(220), 30, 2, 6));
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
    public boolean movement(Unit a, char move){
        int x=a.getPos().getX();
        int y=a.getPos().getY();
        if(move=='w')
            if(a.movmentOn(board.getTile(x,y-1)))
                board.Replace(x,x,y,y-1);
        if(move=='s')
            if(a.movmentOn(board.getTile(x,y+1)))
                board.Replace(x,x,y,y+1);
        if(move=='a')
            if(a.movmentOn(board.getTile(x-1,y)))
                board.Replace(x,x-1,y,y);
        if(move=='d')
            if(a.movmentOn(board.getTile(x+1,y)))
                board.Replace(x,x+1,y,y);
        if(move=='e')
            player.OnAbilityCast();
        return false;
    }
}
