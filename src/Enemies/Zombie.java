package Enemies;

import Dungeon.Room;
import Game.Inventory;
import Hero.Hero;

public class Zombie extends Enemy {

    private boolean hasBitten;

    public Zombie(Inventory inv, int attackDamage, int level, int hp, Room room) {
        super(inv, attackDamage, level, hp, room, "Level " + level + " Zombie");
        hasBitten = false;
    }

    //bite lowers attack damage
    @Override
    public void specialAttack(Hero hero) {
        if (hasBitten) {
            System.out.println(getName() + " has tried to bite you again, but you are resistant to his infection!");
        } else {
            hasBitten = true;
            attack(hero);
            System.out.println(getName() + " has bitten you!\n You are now infected and do less damage");
            hero.setAttackDamage(getAttackDamage() - 1);
        }
    }

    public boolean isHasBitten() {
        return hasBitten;
    }

    public void setHasBitten() {
        hasBitten = false;
    }
}
