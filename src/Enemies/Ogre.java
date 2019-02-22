package Enemies;

import Dungeon.Room;
import Game.Inventory;
import Hero.*;

public class Ogre extends Enemy {

    public Ogre(Inventory inv, int attackDamage, int level, int hp, Room room) {
        super(inv, attackDamage, level, hp, room, "Level "+level+" Ogre");
    }

    //does more damage to non-magic users
    @Override
    public void specialAttack(Hero hero) {
        System.out.println(getName()+" has used its special attack, it will do more damage to non-magic users");
        if (hero instanceof Warrior || hero instanceof Tank) {
            setAttackDamage(getAttackDamage()+1);
            attack(hero);
            setAttackDamage(getAttackDamage()-1);
        }
        else {
            attack(hero);
        }
    }
}
