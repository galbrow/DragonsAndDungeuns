package GameControl;
import Bussines.Board;
import Bussines.Enemies.Enemy;
import Bussines.Levels;
import Bussines.PlayerCreate;
import Bussines.Players.*;
import Bussines.Tiles.Unit;
import GameView.MessageHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRun {
    Scanner scan = new Scanner(System.in);
    private MessageHandler cmd;
    private Levels levels;
    private Board board;
    private Player player;
    private List<Enemy> AllEnemies;
    private List<String> currentLevel;

    public GameRun(MessageHandler cmd, Levels level) {
        this.cmd = cmd;
        this.levels = level;
        currentLevel = level.NextLevel(0);
        PlayerCreate playerCreate=new PlayerCreate(cmd);
        this.player=playerCreate.setPlayer();
        board = new Board(currentLevel, cmd, player);
        this.AllEnemies = board.getAllUnits();
    }

    //function that run all over untill game ends
    public void run() {
        try {
            if (AllEnemies.size() == 0) {//checks if player finished current map
                cmd.sendMessage("All Enemies Are Dead, Level finished");
                currentLevel = levels.NextLevel(AllEnemies.size());
                board = new Board(currentLevel, cmd, player);
                this.AllEnemies = board.getAllUnits();
            }

            //player turn
            cmd.sendMessage(board.toString());
            player.setAllEnemiesInRange(AllEnemies);
            cmd.sendMessage(player.describe());
            char a = scan.next().charAt(0);
            board.movement(player, a);
            player.OnGameTick();

            //all enemies turn
            for (int i = 0; i < AllEnemies.size(); i++) {
                Enemy enemy = AllEnemies.get(i);
                if (!enemy.isAlive()) {
                    board.makeEmpty(enemy.getPos().getX(), enemy.getPos().getY());
                    AllEnemies.remove(i);
                    i--;
                } else {
                    char enemyMove = enemy.OnEnemyTurn(player);
                    board.movement(enemy, enemyMove);
                }
            }
            run();
        } catch (Exception e) {//exeption throws when player dead or player finished all stages
            cmd.sendMessage(board.toString());
            cmd.sendMessage(e.getMessage());
        }
    }
}