package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Dragon", 2500, 50);
        Warrior warrior1 = new Warrior("Alex", 280, 10);
        Warrior warrior2 = new Warrior("Arthur", 270, 15);
        Magic magic = new Magic("Harry", 290, 10, 10);
        Berserk berserk = new Berserk("Vatar", 260, 15);
        Medic doc = new Medic("Old", 250, 5, 15);
        Medic assistant = new Medic("Yan", 300, 5, 5);
        TrickyBastard bastard1= new TrickyBastard("Liar", 250 , 20);
        Antman antman = new Antman("Michael", 270, 15);
        Hacker hacker = new Hacker("Alpha" , 300, 10 , 15);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, bastard1, antman, hacker};
        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND: " + roundNumber + " -------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }

    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    public static int getRoundNumber() {
        return roundNumber;
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;

    }
}