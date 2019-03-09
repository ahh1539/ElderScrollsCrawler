package Enemies;

import Dungeon.Room;
import Game.Inventory;
import Hero.Hero;

public class Boss extends Enemy {


    public Boss(Inventory inv, int attackDamage, int level, int hp, Room room, String name) {
        super(inv, attackDamage, level, hp, room, name);
    }

    /**
     * the bosses special attack, here it is called ground pound
     * this attack does much more damage than a regular attack
     * @param hero this is the hero that the boss is attacking
     */
    @Override
    public void specialAttack(Hero hero) {
        System.out.println(getName()+" uses Ground Pound (he pounds the ground)");
        setAttackDamage(getAttackDamage()+6);
        attack(hero);
        setAttackDamage(getAttackDamage()-6);
    }
}
