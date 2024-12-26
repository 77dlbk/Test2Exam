package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;

public class Hacker extends Hero{
    private int stealAmount;
    public Hacker(String name, int health, int damage, int stealAmount) {
        super(name, health, damage, SuperAbility.HACKING);
        this.stealAmount = stealAmount;
    }

    public int getStealAmount() {
        return stealAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() % 2 == 0 && getHealth() > 0){
            boss.setHealth(boss.getHealth()-stealAmount);
            boss.setHealth(boss.getHealth());


            Hero targerHero = heroes[(int) (Math.random() * heroes.length)];
            targerHero.setHealth(targerHero.getHealth() + stealAmount);
            System.out.println(this.getName() + " stole " + getStealAmount() + " hp point from boss" );
        }
    }
}
