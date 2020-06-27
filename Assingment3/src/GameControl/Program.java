package GameControl;

import Bussines.*;
import GameView.CmdPrinter;
import GameView.MessageHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
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

        if(levelList!=null){
            Levels levels=new Levels(levelList);
            MessageHandler m=new CmdPrinter();
            List<String> current =levelList.get(0);
            GameRun game=new GameRun(m,levels);
            game.run();
        }
    }
}
