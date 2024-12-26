package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
    private int damageIncreased;
    public Magic(String name, int health, int damage, int damageIncreased) {
        super(name, health, damage, SuperAbility.BOOST);
        this.damageIncreased = damageIncreased;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber()<=4){
        for(Hero hero : heroes) {
            if (hero.getHealth() > 0 && hero!= this);
            hero.setDamage(hero.getDamage() + damageIncreased);

        }
        }
        System.out.println(this.getName() + " увеличил урон героев на " + damageIncreased);


    }
}
