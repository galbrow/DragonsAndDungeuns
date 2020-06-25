package Abilities;

import Tiles.Position;

public class WarriorAbility extends Abilities {
    private int _heal;
    public WarriorAbility(int damage,int heal) {
        super("Avenger's Shield",3,damage,0);
        this._heal=heal;
    }

    public void set_heal(int _heal) {
        this._heal = _heal;
    }

    public int get_heal() {
        return _heal;
    }
}
