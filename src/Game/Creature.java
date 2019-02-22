package Game;

import Dungeon.Room;

public class Creature {
    private int level;
    private int currentHp;
    private int maxHp;
    private int attackDamage;
    private Inventory inv;
    private String name;
    private Room room;

    public Creature(Inventory inv, int attackDamage, int level, int maxHp, Room room, String name) {
        this.inv = inv;
        this.attackDamage = attackDamage;
        this.level = level;
        this.maxHp = maxHp;
        currentHp = maxHp;
        this.name = name;
        this.room = room;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Inventory getInv() {
        return inv;
    }

    public String getName() {
        return name;
    }

    public void increaseHp(int amt) {
        if (currentHp + amt> maxHp) {
            currentHp = maxHp;
        }
        else {
            this.currentHp += amt;
        }
    }

    public void decreaseHp(int amt) {
        if (currentHp - amt < 0) {
            currentHp = 0;
        }
        else {
            currentHp -= amt;
        }
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public Room getRoom(){ return room; }

    public void setRoom(Room room) {
        this.room = room;
    }

}


