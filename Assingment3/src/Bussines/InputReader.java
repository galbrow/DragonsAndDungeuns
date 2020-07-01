package Bussines;

import Bussines.Players.Player;
import GameView.MessageHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader implements Obeservable {
    //Array of Observers
    private final ArrayList<Observer> observers = new ArrayList<>();
    private Observer board;
    private Observer player;
    public InputReader(MessageHandler cmd, List<List<String>> levels){
        TilesDictionary playerCreate=new TilesDictionary(cmd);
        Player player=playerCreate.setPlayer();
        board=new Board(cmd, player,new Levels(levels),this,playerCreate);
        this.player=player;
    }

    public void setPlayer(Observer player) { this.player = player; }
    public void setBoard(Board board){this.board=board;}

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void notifyObservers(char choice) {
        player.update(choice);
        for (int i=0;i<observers.size();i++)
            if(observers.get(i).update(choice)){
                observers.remove(i);
                i--;
            }
        board.update('a');
    }
    //Each read trigger notifications to all registered observers
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
            notifyObservers(scanner.next().charAt(0));
    }
}
