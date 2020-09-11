package Enemies;

import Dungeon.Room;
import Game.Inventory;
import Hero.Hero;
import Hero.Mage;

public class Skeleton extends Enemy {


    public Skeleton(Inventory inv, int attackDamage, int level, int hp, Room room) {
        super(inv, attackDamage, level, hp, room, "Level " + level + " Skeleton");
    }

    //Does more damage to magic users
    @Override
    public void specialAttack(Hero hero) {
        System.out.println(getName() + " has used its special attack, it will do more damage to magic users");
        if (hero instanceof Mage) {
            setAttackDamage(getAttackDamage() + 1);
            attack(hero);
            setAttackDamage(getAttackDamage() - 1);
        } else {
            attack(hero);
        }
    }
}
