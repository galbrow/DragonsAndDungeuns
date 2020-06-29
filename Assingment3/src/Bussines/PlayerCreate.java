package Bussines;
import Bussines.Players.*;
import GameView.MessageHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerCreate {
    private MessageHandler cmd;
    private List<Player> AllPlayers;
    private Player player;
    private Scanner scan=new Scanner(System.in);
    public PlayerCreate(MessageHandler m){
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
        player=AllPlayers.get(choice-1);
        cmd.sendMessage("You have selected:");
        cmd.sendMessage(player.getName());
        return player;
    }
}
