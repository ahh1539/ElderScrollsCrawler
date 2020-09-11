package Game;

public class Inventory {

    private int stamPotions;
    private int healthPotions;
    private Weapon weapon;

    public Inventory(int stamPotions, int healthPotions, Weapon weapon) {
        this.healthPotions = healthPotions;
        this.stamPotions = stamPotions;
        this.weapon = weapon;
    }

    public boolean consumeHPotion() {
        if (healthPotions != 0) {
            healthPotions--;
            return true;
        } else {
            return false;
        }
    }

    public int getStamPotionsAmt() {
        return stamPotions;
    }

    public int getHealthPotionsAmt() {
        return healthPotions;
    }

    public boolean consumeSPotion() {
        if (stamPotions != 0) {
            stamPotions--;
            return true;
        } else {
            return false;
        }
    }

    public void swapWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void addHealthP(int num) {
        healthPotions += num;
    }

    public void addStamP(int num) {
        stamPotions += num;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void addWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
