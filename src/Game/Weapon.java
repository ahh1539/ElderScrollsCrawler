package Game;

public class Weapon {

    private String name;
    private int damage;

    public Weapon(String name, int dmg) {
        this.name = name;
        this.damage = dmg;
    }


    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
