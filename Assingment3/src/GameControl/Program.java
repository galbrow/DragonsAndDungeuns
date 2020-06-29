package GameControl;

import Bussines.*;
import GameView.CmdPrinter;
import GameView.MessageHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {//read all levels
        Scanner scan=new Scanner(System.in);
        List<List<String>> levelList=new LinkedList<>();
        List<String> levelData=null;
        try{
            List<String> levelFiles=Files.list(Paths.get(args[0])).sorted().map(Path::toString).collect(Collectors.toList());
            for(String levelPath: levelFiles) {
                levelData = Files.readAllLines(Paths.get(levelPath));
                levelList.add(levelData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(levelList!=null){//in case there is levels to read
            Levels levels=new Levels(levelList);
            MessageHandler m=new CmdPrinter();
            GameRun game=new GameRun(m,levels);
            game.run();//invoke game
        }
    }
}
