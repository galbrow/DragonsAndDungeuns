package Bussines.Enemies;
import Bussines.*;
import Bussines.Players.Player;
import GameView.MessageHandler;

public class Monster extends Enemy {
    protected int visionRange;

    public Monster(char character, Position pos, String name, Health hp, int attackPoints, int defenePoints, int visionRange, int exp, MessageHandler cmd, Player player, Board board) {
        super(character, pos, name, hp, attackPoints, defenePoints,exp,cmd,player);
        this.visionRange = visionRange;
        this.board=board;
    }

    //do enemy activity of each round
    public char OnEnemyTurn(Player player) {
        if(Range(player.getPos())<visionRange){
            int dx=pos.getX()-player.getPos().getX();
            int dy=pos.getY()-player.getPos().getY();
            if(Math.abs(dx)>Math.abs(dy)){
                if(dx>0)
                    return 'a';
                else
                    return 'd';
            }
            else{
                if(dy>0)
                    return 'w';
                else
                    return 's';
            }
        }
        else {
            int a=chooseRandomNumber.SelectRandomNumberInRange(4);
            switch (a){
                case 0:
                    return 'a';
                case 1:
                    return 'd';
                case 2:
                    return 's';
                case 3:
                    return 'w';
            }
            return 'q';
        }
    }
}
