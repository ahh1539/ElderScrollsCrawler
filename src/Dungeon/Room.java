package Dungeon;

import Enemies.*;
import Game.Inventory;
import Game.Weapon;

import java.util.Random;

import java.util.ArrayList;

public class Room {

    private int id;
    private ArrayList<Door> doors;
    private int levelRequired;
    private Inventory rinv;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Random rand = new Random();
    private int n = rand.nextInt(13);

    public Room(int id) {

        //this.doors = doors;
        this.id = id;
        makeRoomInventory();
        makeEnemy();
    }

    public Inventory getInv() {
        return rinv;
    }

    /**
     * makes a random weapon using a random number generator
     * there are currently 12 different weapons
     *
     * @return weapon object
     */
    private Weapon makeWeapon() {
        Weapon w;
        switch (n) {
            case 0:
                w = new Weapon("Chillrend", 2);
                break;
            case 1:
                w = new Weapon("Excalibur", 3);
                break;
            case 2:
                w = new Weapon("Mournblade", 2);
                break;
            case 3:
                w = new Weapon("Widowmaker", 2);
                break;
            case 4:
                w = new Weapon("Soul Clapper", 4);
                break;
            case 5:
                w = new Weapon("Diamond Piercer", 2);
                break;
            case 6:
                w = new Weapon("Brick", 1);
                break;
            case 7:
                w = new Weapon("Electic storm Staff", 3);
                break;
            case 8:
                w = new Weapon("Soul Staff", 2);
                break;
            case 9:
                w = new Weapon("Ice Staff", 3);
                break;
            case 10:
                w = new Weapon("Lava staff", 3);
                break;
            case 11:
                w = new Weapon("Putrid Driftwood Staff", 2);
                break;
            case 12:
                w = new Weapon("Blind mans cane", 3);
                break;
            default:
                w = new Weapon("chillrend", 2);
        }
        return w;
    }

    /**
     * makes a randomized inventory for this room
     */
    private void makeRoomInventory() {
        Weapon w;
        int healthPotion = 0;
        int stamPotion = 0;
        if (n % 2 == 0) {
            healthPotion++;
        } else {
            stamPotion++;
        }

        w = makeWeapon();
        rinv = new Inventory(stamPotion, healthPotion, w);
    }

    /**
     * this method makes a randomized inventory for each enemy made
     *
     * @return a randomized inventory obj
     */
    private Inventory makeEnemyInventory() {

        Weapon w;
        int h = 0;
        int s = 0;

        if (n % 3 == 0) {
            h++;
        } else {
            s++;
        }
        w = makeWeapon();
        return new Inventory(s, h, w);
    }

    /**
     * Makes a random enemy and creates their inventory and then places
     * them in the current room
     */
    private void makeEnemy() {
        Random rand = new Random();
        int n = rand.nextInt(4);
        Enemy enemy;
        switch (n) {
            case 0:
                enemy = new Ghoul(makeEnemyInventory(), 3, 1, 10, this);
                break;
            case 1:
                enemy = new Ogre(makeEnemyInventory(), 4, 1, 12, this);
                break;
            case 2:
                enemy = new Skeleton(makeEnemyInventory(), 2, 1, 6, this);
                break;
            case 3:
                enemy = new Zombie(makeEnemyInventory(), 2, 1, 9, this);
                break;
            default:
                enemy = new Zombie(makeEnemyInventory(), 2, 1, 9, this);
        }

        enemies.add(enemy);

    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public int getId() {
        return id;
    }

    /**
     * checks whether the player has defeated all enemies in the room
     * @returns a boolean
     */
    public boolean isRoomCleared() {
        boolean cleared = false;
        for (Enemy e : enemies) {
            cleared = !e.isAlive();
        }
        return cleared;
    }


    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    /**
     * creates an instance of a boss
     */
    public void makeBoss() {
        Enemy boss = new Boss(makeEnemyInventory(), 4, 2, 21, this, "The ClappMaster");
        enemies.add(boss);
    }
}
