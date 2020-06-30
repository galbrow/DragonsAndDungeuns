package Bussines.Enemies;

import Bussines.Board;
import Bussines.Health;
import Bussines.HeroeicUnit;
import Bussines.Players.Player;
import Bussines.Position;
import GameView.MessageHandler;

public class Boss extends Monster implements HeroeicUnit {
    private int abilityFrequency;
    private int combatTicks;

    public Boss(char character, Position pos, String name, Bussines.Health hp, int attackPoints, int defenePoints, int visionRange, int exp, MessageHandler cmd, Player player, Board board, int abilityFrequency) {
        super(character, pos, name, hp, attackPoints, defenePoints, visionRange, exp, cmd, player, board);
        this.abilityFrequency=abilityFrequency;
        this.combatTicks=0;
    }

    @Override
    public char OnEnemyTurn(Player player) {
        if(Range(player.getPos())<visionRange){
            if(combatTicks==abilityFrequency) {
                combatTicks = 0;
                cmd.sendMessage(this.Name+" Cast ability");
                OnAbilityCast();
                return 'q';
            }
            else {
                combatTicks += 1;
                int dx = pos.getX() - player.getPos().getX();
                int dy = pos.getY() - player.getPos().getY();
                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0)
                        return 'a';
                    else
                        return 'd';
                } else {
                    if (dy > 0)
                        return 'w';
                    else
                        return 's';
                }
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

    @Override
    public void OnAbilityCast() {
        Combat(player);
    }
}
