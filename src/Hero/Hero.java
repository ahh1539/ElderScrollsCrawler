package Hero;

import Dungeon.Room;
import Enemies.Enemy;
import Game.Creature;
import Game.Inventory;

public abstract class Hero extends Creature {

    private int maxStamina;
    private boolean bitten = false;
    private int currentStamina;
    private int roomscleared = 0;

    public Hero(Inventory inv, int attackDamage, int level, int hp, Room room, String name, int stamina) {
        super(inv, attackDamage, level, hp, room, name);
        maxStamina = stamina;
        currentStamina = stamina;
    }

    public abstract void ability();

    public void slash(Enemy enemy) {
        enemy.decreaseHp(super.getAttackDamage()+getInv().getWeapon().getDamage());
        decreaseStamina(2);
    }


    public int getMaxStamina() {
        return maxStamina;
    }

    public void decreaseStamina(int amt) {
        if (currentStamina - amt < 0) {
            currentStamina = 0;
        }
        else {
            currentStamina -= amt;
        }
    }

    public int getCurrentStamina() {
        return currentStamina;
    }

    public void setMaxStamina(int amt) {
        maxStamina = amt;
    }

    public void increaseStamina(int amt) {
        if (currentStamina + amt > maxStamina) {
            currentStamina = maxStamina;
        }
        else {
            currentStamina += amt;
        }
    }

    public void addCleared(){
        roomscleared++;
    }
    public int getRoomscleared() {
        return roomscleared;
    }

    public abstract void reset();

    public void levelUp() {
        setLevel(super.getLevel()+1);
        setMaxStamina(getMaxStamina()+2);
        setMaxHp(getMaxHp()+2);
        increaseStamina(100);
        increaseHp(100);
    }



}
