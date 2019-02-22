package Hero;

import Dungeon.Room;
import Game.Inventory;

public class Warrior extends Hero {

    private boolean berserkUsed;
    private static final double ABILITY_LIMITER = .6; //used to make attack not overpowered

    public Warrior(Inventory inv, int attackDamage, int level, int hp, int stamina, String name, Room room) {
        super(inv, attackDamage, level, hp, room, name, stamina);
        berserkUsed = false;
    }

    //resets boolean to false for next rounds
    public void reset() {
        berserkUsed = false;
        increaseStamina(100);
    }


    //Warrior berserk ability raises attack damage more if health is lower, can be used once per round
    @Override
    public void ability() {
        if (berserkUsed) {
            System.out.println("Berserk mode has already been used this round");
        }
        else {
            System.out.println("Berserk mode activated!");
            setAttackDamage(getAttackDamage() + (int)((getMaxHp()-getCurrentHp()/getMaxHp())*ABILITY_LIMITER));
            berserkUsed = true;
        }
    }
}
