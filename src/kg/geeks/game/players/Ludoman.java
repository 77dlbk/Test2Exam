package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Ludoman extends Hero{


    public Ludoman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GAMBLING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth()>0){
            int dice1 = RPG_Game.random.nextInt(6)+1;
            int dice2 = RPG_Game.random.nextInt(6)+1;
            System.out.println(this.getName() + " rolled dice 1 and dice 2" );
            if(dice1==dice2){
                int damageToBoss = dice1 * dice2;
                boss.setHealth(boss.getHealth() - damageToBoss);
                System.out.println(boss.getName() + " lost " + damageToBoss + " hp points");
            }
            else {
                int damageToHero = dice1 + dice2;
                Hero targetHero = heroes[RPG_Game.random.nextInt(heroes.length)];
                if (targetHero.getHealth() <=0){
                    targetHero = heroes[RPG_Game.random.nextInt(heroes. length)];
                    targetHero.setHealth(targetHero.getHealth() - damageToHero);
                }
                else{
                    targetHero.setHealth(targetHero.getHealth() - damageToHero);
                }
                System.out.println(this.getName() + " rolled failed rolling dices and " + targetHero.getName() + " lost "
                + damageToHero + " HP points");
            }
        }

    }
}
