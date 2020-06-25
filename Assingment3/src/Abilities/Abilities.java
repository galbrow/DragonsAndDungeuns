package Abilities;

public abstract class Abilities {
    protected String _name;
    protected int _range;
    protected int _damage;
    protected int _resource;

    public Abilities(String name,int range,int damage,int resource){
        this._name=name;
        this._range=range;
        this._damage=damage;
        this._resource =resource;
    }

    public void set_damage(int _damage) {
        this._damage = _damage;
    }

    public int get_resource() {
        return _resource;
    }
}
