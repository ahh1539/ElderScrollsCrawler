package Enemies;

import Dungeon.Room;
import Game.Creature;
import Game.Inventory;
import Hero.*;

public abstract class Enemy extends Creature {


    public Enemy(Inventory inv, int attackDamage, int level, int hp, Room room, String name) {
        super(inv, attackDamage, level, hp, room, name);
    }

    //Special attack/debuff specific to each enemy type
    public abstract void specialAttack(Hero hero);

    public void attack(Hero hero) {
        System.out.println();
        System.out.println(getName()+" has attacked you, you took "+getAttackDamage()+" damage!");
        hero.decreaseHp(getAttackDamage());

    }

}
