package Game;

import Dungeon.Dungeon;
import Dungeon.Room;
import Enemies.Boss;
import Enemies.Enemy;
import Enemies.Zombie;
import Hero.Hero;
import Hero.Mage;
import Hero.Tank;
import Hero.Warrior;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;


/**
 * TODO
 * - add in enemy levels other than level 1 (make dependent on player level)
 * - add armor
 * - add options to maybe explore the room
 */
public class Game {

    private static Dungeon dungeon;
    private static Hero player;
    private static int levelUpCount = 0;
    private static Random rand = new Random();
    private static Room[] rooms;


    public static void play() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("___________.__       .___               _________                   .__  .__           _________                      .__                \n" +
                "\\_   _____/|  |    __| _/___________   /   _____/ ___________  ____ |  | |  |   ______ \\_   ___ \\____________ __  _  _|  |   ___________ \n" +
                " |    __)_ |  |   / __ |/ __ \\_  __ \\  \\_____  \\_/ ___\\_  __ \\/  _ \\|  | |  |  /  ___/ /    \\  \\/\\_  __ \\__  \\\\ \\/ \\/ /  | _/ __ \\_  __ \\\n" +
                " |        \\|  |__/ /_/ \\  ___/|  | \\/  /        \\  \\___|  | \\(  <_> )  |_|  |__\\___ \\  \\     \\____|  | \\// __ \\\\     /|  |_\\  ___/|  | \\/\n" +
                "/_______  /|____/\\____ |\\___  >__|    /_______  /\\___  >__|   \\____/|____/____/____  >  \\______  /|__|  (____  /\\/\\_/ |____/\\___  >__|   \n" +
                "        \\/            \\/    \\/                \\/     \\/                            \\/          \\/            \\/                 \\/       ");


        System.out.println("||======================================||\n" +
                "||   Welcome to Elder Scrolls Crawler   ||\n" +
                "|| Made by: Aidan Bohan and Alex Hurley ||\n" +
                "||          To play type 'p'            ||\n" +
                "||======================================||");
        String input = scanner.next();
        if (input.equals("p")) {
            System.out.println("What is your characters name? :");
            String name = scanner.next();
            System.out.println("Type h for help with Character classes, or c to continue");
            String help = scanner.next();
            if (help.equals("h")) {
                System.out.println(help());
                System.out.println("Choose your character class: w for warrior, t for tank, m for mage");
                String herrooo = scanner.next();
                player = makeHero(name, herrooo);
            } else {

                System.out.println("Choose your character class: w for warrior, t for tank, m for mage");
                String heroClass = scanner.next();
                player = makeHero(name, heroClass);
            }
            System.out.println("Are you ready to begin your adventure! : y/n");
            String answer = scanner.next();
            if (answer.equals("y")) {
                System.out.println("\nYou wake up dizzy with a note next to you signed 'good luck', you are in a dark \n" +
                        "stone room lit only by a single torch, you hear a voice growing louder, Welcome \n" +
                        "to my dungeon " + player.getName() + " I look forward to seeing you getting clapped." +
                        " You see a " + player.getInv().getWeapon().getName() + "\n" + "you pick it up and begin your journey through " +
                        "this evil lair \n" +
                        "================================================================================================\n");
                while (player.isAlive()) {
                    if (!player.getRoom().getEnemies().isEmpty()) {
                        int i = player.getRoomscleared();
                        if (rooms[i] == rooms[dungeon.getSize() - 1]) {
                            player.getRoom().makeBoss();
                            //playSound();
                            System.out.println("Welcome to my lair " + player.getName());
                        }
                        System.out.println("You see a " + getEnemy().getName() + " enter 'f' to fight, 'w' to wait, 'i' for inventory , or 'p' to " +
                                "take potion!");
                        String ans = scanner.next();

                        if (ans.equals("f")) {
                            System.out.println("BATTLE BEGINS WITH " + getEnemy().getName() + "!!!");
                            battle(player, getEnemy());
                        } else if (ans.equals("p")) {
                            if (player.getInv().consumeHPotion()) {
                                player.increaseHp(5);
                                System.out.println("You have taken a potion!");
                            } else {
                                System.out.println("You have no potions, rip guy...");

                            }
                        } else if (ans.equals("i")) {
                            System.out.println("Weapon: " + "[" + player.getInv().getWeapon().getName() + ": " + player.getInv().getWeapon().getDamage()
                                    + "]" + "\n" + "Health Potions: " + player.getInv().getHealthPotionsAmt()
                                    + "\n" + "Stamina Potions: " + player.getInv().getStamPotionsAmt() + "\n");
                        } else {
                            if (player.getRoom().isRoomCleared()) {
                                System.out.println("Would you like to continue (c) or go back (b)?");
                                String dir = scanner.next();
                                if (dir.equals("c")) {
                                    player.setRoom(dungeon.getRooms()[player.getRoom().getId() + 1]);
                                } else {
                                    if (player.getRoom() == dungeon.getRooms()[0]) {
                                        System.out.println("You cannot go back any further!");
                                    } else {
                                        player.setRoom(dungeon.getRooms()[player.getRoom().getId() - 1]);
                                        System.out.println("You went back to room " + player.getRoom().getId());
                                    }
                                }
                            }
                            if (player.getRoom().isRoomCleared() == false) {
                                System.out.println("You can't progress to the next room without clearing this room!");
                            }

                        }

                    } else {
                        player.addCleared();
                        int i = player.getRoomscleared();
                        System.out.println("\nYou successfully survived another grueling battle, you see a door at the back of the room.");
                        System.out.println("\nSuccessfully cleared room! Ready to move to next room? : y/n");
                        String moveRoom = scanner.next();
                        Room[] rooms = dungeon.getRooms();
                        if (moveRoom.equals("y")) {
                            player.setRoom(rooms[i]);
                        }
                    }
                }
            } else {
                System.out.println("Wrong answer!, goodbye!");
                scanner.close();
            }
        }
    }

    private static Hero makeHero(String name, String heroType) {
        dungeon = new Dungeon(9);
        Hero player;
        Weapon weapon = new Weapon("Brick", 1);
        Inventory startInv = new Inventory(1, 1, weapon);
        dungeon.makeDungeon(9);
        rooms = dungeon.getRooms();
        Room start = rooms[0];
        switch (heroType) {
            case "m":
                player = new Mage(startInv, 4, 1, 11, name, 14, start);
                break;
            case "t":
                player = new Tank(startInv, 2, 1, 16, name, 9, start);
                break;
            case "w":
                player = new Warrior(startInv, 3, 1, 13, 11, name, start);
                break;
            default:
                player = new Warrior(startInv, 3, 1, 13, 11, name, start);
        }
        return player;
    }

    private static Enemy getEnemy() {
        return player.getRoom().getEnemies().get(0);
    }

    private static void battle(Hero player, Enemy enemy) {
        label:
        while (true) {
            System.out.println();
            System.out.println();
            if (!player.isAlive()) {
                System.out.println("YOU HAVE DIED.......BETTER LUCK NEXT TIME!!!" + "\n" + "play again? (y/n)");
                Scanner scan = new Scanner(System.in);
                String playAgain = scan.nextLine();
                if (playAgain.equals("y")) {
                    play();
                } else {
                    break;
                }
            }
            System.out.printf("%1s %40s", "You:", "Enemy:" + "\n");
            System.out.printf("%1s", "Health: " + player.getCurrentHp());
            System.out.printf("%38s", "Health: " + getEnemy().getCurrentHp() + "\n");

            System.out.println(
                    "Stamina: " + player.getCurrentStamina() + "/" + player.getMaxStamina() + "\n" +
                            "Attack Damage: " + player.getAttackDamage() + "\n" +
                            "Weapon: " + player.getInv().getWeapon().getName() + " : " + player.getInv().getWeapon().getDamage() + "\n" +
                            "Stamina Potions: " + player.getInv().getStamPotionsAmt() + "\n" +
                            "Health Potions: " + player.getInv().getHealthPotionsAmt() + "\n" +
                            "Level: " + player.getLevel() + "\n");
            Scanner scan = new Scanner(System.in);

            String answ = null;
            String[] validAnswers = {"1", "2", "3", "4"};

            while (!Arrays.asList(validAnswers).contains(answ)) {
                System.out.println("Would you like to '1' ATTACK, '2' Use your SPECIAL ABILITY, '3' use a potion, or '4' FLEE?");
                answ = scan.next();

                //player interaction
                switch (answ) {
                    case "1":
                        player.slash(enemy);
                        break;
                    case "2":
                        player.ability();
                        break;
                    case "3":
                        System.out.println("Use Stamina (s) or Health (h) potions?");
                        String answer = scan.next();
                        if (answer.equals("s")) {
                            if (player.getInv().getStamPotionsAmt() > 0) {
                                player.increaseStamina(5);
                                player.getInv().consumeSPotion();
                            }
                        } else if (answer.equals("h")) {
                            if (player.getInv().getHealthPotionsAmt() > 0) {
                                player.increaseHp(5);
                                player.getInv().consumeHPotion();
                                System.out.println("You used a potion. Your current health is " + player.getCurrentHp());
                            }
                        }
                        System.out.println();
                        break;
                    case "4":
                        System.out.println("Ending Battle!....for now");
                        break label;
                    default:
                        System.out.println("That's not a valid option!!");
                }
            }
            if (getEnemy() instanceof Zombie) {
                if (((Zombie) getEnemy()).isHasBitten() == true) {
                    player.setAttackDamage(player.getAttackDamage() + 1);
                    ((Zombie) getEnemy()).setHasBitten();
                }
            }
            if (!enemy.isAlive()) {
                levelUpCount++;
                System.out.println(enemy.getName() + " has been defeated!\n");

                if (enemy instanceof Boss) {
                    System.out.println("After hours of battling monsters you see a dark tunnel with a red lantern next \n" +
                            "to a door, you walk over and hear screaming behind the door you come to the sad \n" +
                            "realization that your journey is far from over, however, strangley part of you is almost happy \n" +
                            "you open the door ready to face the horrors ahead.... \n");
                    System.out.println("_________                                     __        .__          __  .__                       \n" +
                            "\\_   ___ \\  ____   ____    ________________ _/  |_ __ __|  | _____ _/  |_|__| ____   ____   ______ \n" +
                            "/    \\  \\/ /  _ \\ /    \\  / ___\\_  __ \\__  \\\\   __\\  |  \\  | \\__  \\\\   __\\  |/  _ \\ /    \\ /  ___/ \n" +
                            "\\     \\___(  <_> )   |  \\/ /_/  >  | \\// __ \\|  | |  |  /  |__/ __ \\|  | |  (  <_> )   |  \\\\___ \\  \n" +
                            " \\______  /\\____/|___|  /\\___  /|__|  (____  /__| |____/|____(____  /__| |__|\\____/|___|  /____  > \n" +
                            "        \\/            \\//_____/            \\/                     \\/                    \\/     \\/  \n" +
                            "                           _____.___.               __      __.__                                  \n" +
                            "                           \\__  |   | ____  __ __  /  \\    /  \\__| ____                            \n" +
                            "                            /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\                           \n" +
                            "                            \\____   (  <_> )  |  /  \\        /|  |   |  \\                          \n" +
                            "                            / ______|\\____/|____/    \\__/\\  / |__|___|  /                          \n" +
                            "                            \\/                            \\/          \\/                           ");
                    scan.close();
                    exit(0);
                }
                collectPotions(player, enemy);
                player.getRoom().removeEnemy(enemy);
                System.out.println(enemy.getName() + " dropped " + enemy.getInv().getWeapon().getName() + " with damage of " + enemy.getInv().getWeapon().getDamage() + "\n" +
                        "do you want to swap for current weapon: " + player.getInv().getWeapon().getName() + " with damage of " + player.getInv().getWeapon().getDamage() + ": y/n ?");
                String answ2 = scan.next();
                if (answ2.equals("y")) {
                    player.getInv().swapWeapon(enemy.getInv().getWeapon());
                    System.out.println("You swapped for " + player.getInv().getWeapon().getName() + "\n");
                }

                if (levelUpCount >= 2) {
                    levelUpCount = 0;
                    player.levelUp();
                    System.out.println("You have leveled up! You are now level " + player.getLevel() + "\nyour health and stamina have been replenished");
                }
                break;
            } else {
                int num = rand.nextInt(10);
                if (num < 4) {
                    enemy.specialAttack(player);
                } else {
                    enemy.attack(player);
                }
            }

        }
        player.reset();
    }

//    public static void playSound() {
//        String song = "lit.mp3";
//        Media hit = new Media(new File(song).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(hit);
//        mediaPlayer.play();
//
//    }

    private static void collectPotions(Hero player, Enemy enemy) {
        int hp = enemy.getInv().getHealthPotionsAmt();
        int stam = enemy.getInv().getStamPotionsAmt();

        player.getInv().addHealthP(hp);
        player.getInv().addStamP(stam);

    }

    private static String help() {
        String h = "\n======================================================================================================= \n" +
                "Warrior class: this class starts with all around \n" +
                "great stats to begin, good damage, good health, and good stamina, its ultimate \n" +
                "ability is 'Berserker Rage' which makes the player deal more dmg the lower their health \n" +
                "is. \n \n" +
                "Mage class: this class is a high damage, high stamina, low health class, mages dish \n" +
                "out a lot of damage but it comes at the cost of little health. Mages ultimate ability is \n" +
                "'Grand Heal' which fully replenishes their hp and stamina. \n \n" +
                "Tank class: this class is a high health class, low damage, low stamina, the tank can \n" +
                "take a ton of hits before it goes down. The starting hp of the tank class is much higher \n" +
                "than the other two. Tanks ultimate ability is 'Super Armor' which temporarily grants the \n" +
                "player twice the normal health \n" +
                "=======================================================================================================\n";
        return h;
    }


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//        final JFXPanel fxPanel = new JFXPanel();
        play();
    }


}
