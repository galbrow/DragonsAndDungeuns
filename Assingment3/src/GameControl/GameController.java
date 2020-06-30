package GameControl;

import Bussines.Board;
import Bussines.InputReader;
import Bussines.Levels;
import Bussines.Players.Player;
import Bussines.TilesDictionary;
import GameView.MessageHandler;

import java.util.List;

public class GameController {
    private InputReader inputReader;
    private MessageHandler cmd;

    public GameController(InputReader inputReader, MessageHandler cmd, List<List<String>> levels) {
        this.inputReader = inputReader;
        this.cmd = cmd;
        TilesDictionary playerCreate=new TilesDictionary(cmd);
        Player player=playerCreate.setPlayer();
        Board board=new Board(cmd, player,new Levels(levels),inputReader,playerCreate);
        inputReader.setPlayer(player);
        inputReader.setBoard(board);
        run();
    }
    public void run(){
        try {
            inputReader.getUserInput();//observable
        }
        catch (Exception e) {//exeption throws when player dead or player finished all stages
            cmd.sendMessage(e.getMessage());
        }

    }
}
