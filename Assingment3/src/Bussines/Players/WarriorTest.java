package Bussines.Players;

import Bussines.Health;
import Bussines.Position;
import GameView.CmdPrinter;
import GameView.MessageHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior warrior;
    private Warrior expected;

    @BeforeEach
    void setUp() {
        Position pos=new Position(0,0);
        MessageHandler m=new CmdPrinter();
        this.warrior=new Warrior(pos,"Warrior",new Health(100),5,10,15,m);
        this.expected=new Warrior(pos,"Warrior",new Health(100),5,10,15,m);
        warrior.OnAbilityCast();
    }

    @Test
    void uponLevelingUp() {
        warrior.exp=200;
        warrior.getHealth().ReduceCurrHealth(warrior.getHealth().getHp()-2);
        warrior.UponLevelingUp();
        assertEquals(expected.level+1,warrior.level,"After leveling up warrior level should increase by 1");
        assertEquals(200-50,warrior.exp,"After leveling up the exp should reduce by 50*level");
        assertEquals(expected.getHealth().getHp()+15*warrior.level,warrior.getHealth().getHp(),"After leveling up warrior Health Pool should be raised by 15*level");
        assertEquals(warrior.getHealth().getHp(),warrior.getHealth().getCurrentHealth(),"After leveling up warrior current health should be full");
        assertEquals(expected.getAttackPoints()+6*warrior.level,warrior.getAttackPoints(),"After leveling up warrior attack points should be raised by 6*level");
        assertEquals(expected.getDefenePoints()+2*warrior.level,warrior.getDefenePoints(),"After leveling up warrior defense should be raised by 2*level");
        assertEquals(0,warrior.get_remainingCooldown(),"After leveling up remaining cooldown of ability cast should be 0");
    }

    @Test
    void onGameTick() {
        warrior.OnGameTick();
        expected.OnGameTick();
        assertEquals(0,expected.get_remainingCooldown(),"remaining cooldown cannot be set under 0");
        assertEquals(warrior.get_totalCooldown()-1,warrior.get_remainingCooldown(),"After game tick remaining cooldown should be reduced by 1");
    }
}