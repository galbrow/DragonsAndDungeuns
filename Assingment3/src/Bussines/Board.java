package Bussines;

import Bussines.Players.Player;
import Bussines.Tiles.Empty;
import Bussines.Tiles.Tile;
import Bussines.Tiles.Unit;
import GameView.MessageHandler;

import java.util.ArrayList;
import java.util.List;

public class Board implements Observer {
    private Tile[][] Board;
    private ArrayList AllEnemies;
    private MessageHandler cmd;
    private Player player;
    private Levels levels;
    private InputReader inputReader;
    private TilesDictionary TileInfo;

    public Board(MessageHandler cmd, Player player, Levels levels, InputReader inputReader, TilesDictionary creator) {
        this.cmd=cmd;
        this.player=player;
        player.setBoard(this);
        this.levels=levels;
        this.TileInfo=creator;
        this.AllEnemies = new ArrayList();
        this.inputReader=inputReader;
        update('M');
    }

    //convert each char from the level string to tile
    public Tile getTileByChar(char a, Position pos, Player player) {
        Tile t=TileInfo.getTileByChar(a,pos,player,this);
        if (a != '@' && a != '.' && a != '#') {
            AllEnemies.add(t);
            inputReader.addObserver(t);
        }
        return t;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[0].length; j++) {
                toReturn += Board[i][j].toString();
            }
            toReturn += "\n";
        }
        return toReturn;
    }

    public ArrayList getAllEnemies() { return AllEnemies; }


    public Tile getTile(int x, int y) {
        return Board[y][x];
    }

    //replace between 2 tiles in the board
    public void Replace(int x1, int x2, int y1, int y2) {
        Tile a = Board[y1][x1];
        Board[y1][x1] = Board[y2][x2];
        Board[y2][x2] = a;
    }

    //replace the current position with empty tile
    public void makeEmpty(int x, int y) {
        Empty a = new Empty(new Position(x, y), cmd);
        Board[y][x] = a;
    }

    //replace between 2 tiles in the board
    public void movement(Unit a, char move) {
        int x = a.getPos().getX();
        int y = a.getPos().getY();
        if (move == 'w')
            if (a.movmentOn(getTile(x, y - 1)))
                Replace(x, x, y, y - 1);
        if (move == 's')
            if (a.movmentOn(getTile(x, y + 1)))
                Replace(x, x, y, y + 1);
        if (move == 'a')
            if (a.movmentOn(getTile(x - 1, y)))
                Replace(x, x - 1, y, y);
        if (move == 'd')
            if (a.movmentOn(getTile(x + 1, y)))
                Replace(x, x + 1, y, y);
        if (move == 'e')
            player.OnAbilityCast();
    }

    @Override
    public boolean update(char x) {//observer function
        if (AllEnemies.size() == 0) {//checks if player finished current map
            if(x!='M')cmd.sendMessage("All Enemies Are Dead, Level finished");
            List<String> board = levels.NextLevel(AllEnemies.size());
            this.Board = new Tile[board.size()][board.get(0).length()];
            for (int i = 0; i < Board.length; i++)
                for (int j = 0; j < Board[0].length; j++) {
                    Board[i][j] = getTileByChar(board.get(i).charAt(j), new Position(j, i), player); }
            player.setAllEnemiesOnBoard(AllEnemies);
        }
        cmd.sendMessage(toString());
        cmd.sendMessage(player.describe());
        return false;
    }
}
