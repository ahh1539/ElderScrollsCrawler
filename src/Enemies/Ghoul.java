package Enemies;

import Dungeon.Room;
import Game.Inventory;
import Hero.Hero;

import java.util.Random;

public class Ghoul extends Enemy {

    private Random rand = new Random();
    private int n = rand.nextInt(2);

    public Ghoul(Inventory inv, int attackDamage, int level, int hp, Room room) {
        super(inv, attackDamage, level, hp, room, "Level "+level+" Ghoul");

    }

    //Fear debuff (stamina debuff)
    @Override
    public void specialAttack(Hero hero) {
        System.out.println(getName()+" has used its special attack, it will decrease your stamina!");
        attack(hero);
        hero.decreaseStamina(n);
    }
}
//test
