package Hero;

import Dungeon.Room;
import Game.Inventory;

public class Mage extends Hero {

    private boolean usedAbility;

    public Mage(Inventory inv, int attackDamage, int level, int hp, String name, int stamina, Room room) {
        super(inv, attackDamage, level, hp, room, name, stamina);
        usedAbility = false;
    }

    public void reset() {
        usedAbility = false;
        increaseStamina(100);
    }

    //Full heal/stamina
    @Override
    public void ability() {
        if (usedAbility) {
            System.out.println("Grand Heal has already been used this round!");
        }
        else {
            System.out.println("You used Grand Heal!");
            increaseStamina(100);
            increaseHp(100);
        }
    }
}
