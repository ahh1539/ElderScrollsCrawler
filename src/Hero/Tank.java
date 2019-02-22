package Hero;

import Dungeon.Room;
import Game.Inventory;

public class Tank extends Hero {

    private int SHIELD_MULTIPLIER;
    private boolean superArmorUsed;

    public Tank(Inventory inv, int attackDamage, int level, int hp, String name, int stamina, Room room) {
        super(inv, attackDamage, level, hp, room, name, stamina);
        superArmorUsed = false;
        SHIELD_MULTIPLIER = super.getMaxHp();
    }

    public void reset(){
        if (superArmorUsed) {
            setMaxHp(SHIELD_MULTIPLIER);
            increaseHp(0);
        }
        increaseStamina(100);
    }

    @Override
    public void ability() {
        if (superArmorUsed){
            System.out.println("Superarmor has already been used this round");
        }
        else {
            System.out.println("Super Armor Enabled, clap them solider!");
            super.setMaxHp(SHIELD_MULTIPLIER*2);
            super.increaseHp(SHIELD_MULTIPLIER);
            superArmorUsed = true;
        }

    }
}


//test