package Enemies;

import Dungeon.Room;
import Game.Inventory;
import Hero.Hero;
import Hero.Mage;

public class Ogre extends Enemy {

    public Ogre(Inventory inv, int attackDamage, int level, int hp, Room room) {
        super(inv, attackDamage, level, hp, room, "Level " + level + " Ogre");
    }

    /**
     * attack that does extra damage to non magic users
     *
     * @param hero
     */
    @Override
    public void specialAttack(Hero hero) {
        System.out.println(getName() + " has used its special attack, it will do more damage to non-magic users");
        if (!(hero instanceof Mage)) {
            setAttackDamage(getAttackDamage() + 1);
            attack(hero);
            setAttackDamage(getAttackDamage() - 1);
        } else {
            attack(hero);
        }
    }
}
