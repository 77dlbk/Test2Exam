package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Antman extends Hero {
    private int originalHealth;
    private int originalDamage;
    private boolean isSizeChanged;
    public Antman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SIZE_CHANGE);
        this.originalHealth = health;
        this.originalDamage = damage;
        isSizeChanged = false;
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0){
        if (!isSizeChanged) {
            boolean increaseSize = RPG_Game.random.nextBoolean();

            if (increaseSize) {
                this.setHealth(this.getHealth() * 2);
                this.setDamage(this.getDamage() * 2);
                System.out.println(this.getName() + " increased his size! Health and damage doubled.");
            } else if (!isSizeChanged){
                this.setHealth(this.getHealth() / 2);
                this.setDamage(this.getDamage() / 2);
                System.out.println(this.getName() + " decreased his size! Health and damage halved.");
                increaseSize = false;
            }
            isSizeChanged = true;
        } else {
            this.setHealth(originalHealth - boss.getDamage());
            this.setDamage(originalDamage);
            System.out.println(this.getName() + " returned to his original size.");
            isSizeChanged = false;
        }
    }}




}
