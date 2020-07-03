package Bussines.Players;

import Bussines.Health;
import Bussines.Position;
import Bussines.TilesDictionary;
import GameView.CmdPrinter;
import GameView.MessageHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Mage mage;
    private Mage expected;
    @BeforeEach
    void setUp() {
        Position pos=new Position(0,0);
        MessageHandler m=new CmdPrinter();
        TilesDictionary dictionary=new TilesDictionary(m);
        this.mage=new Mage(pos,"Mage",new Health(100),5,10,15,20,25,30,10,m);
        this.expected=new Mage(pos,"Mage",new Health(100),5,10,15,20,25,30,10,m);
        mage.OnAbilityCast();
    }

    @Test
    void uponLevelingUp() {
        mage.exp=200;
        expected.OnAbilityCast();
        mage.getHealth().ReduceCurrHealth(mage.getHealth().getHp()-2);
        mage.UponLevelingUp();
        assertEquals(expected.level+1, mage.level,"After leveling up warrior level should increase by 1");
        assertEquals(200-50, mage.exp,"After leveling up the exp should reduce by 50*level");
        assertEquals(expected.getHealth().getHp()+10* mage.level, mage.getHealth().getHp(),"After leveling up warrior Health Pool should be raised by 15*level");
        assertEquals(mage.getHealth().getHp(), mage.getHealth().getCurrentHealth(),"After leveling up warrior current health should be full");
        assertEquals(expected.getAttackPoints()+4* mage.level, mage.getAttackPoints(),"After leveling up warrior attack points should be raised by 6*level");
        assertEquals(expected.getDefenePoints()+1* mage.level, mage.getDefenePoints(),"After leveling up warrior defense should be raised by 2*level");
        assertEquals(expected.getMp()+25*mage.level, mage.getMp(),"After leveling up mana pool should be raised by 25*level");
        assertEquals(expected._abilityDamage+10*mage.level,mage._abilityDamage,"After leveling up Spell power should be raised by 10*level");
    }
}