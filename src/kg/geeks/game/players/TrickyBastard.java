
package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;


public class TrickyBastard extends Hero {
   private static int fakeRound; // Раунд, в который герой "притворяется мертвым"
   private boolean isHeroFaked;


   public TrickyBastard(String name, int health, int damage) {
       super(name, health, damage, SuperAbility.TRICK);
       fakeRound = RPG_Game.random.nextInt(5)+1;
       isHeroFaked = false;
   }


   @Override
   public void applySuperPower(Boss boss, Hero[] heroes) {
       int currentRound = RPG_Game.getRoundNumber();
       if (currentRound == fakeRound && !isHeroFaked) {
           isHeroFaked = true;
           System.out.println(this.getName() + " didn't take any damage because he pretended to be dead!");
       } else if (currentRound == fakeRound + 1) {
           System.out.println(this.getName() + " returned to the fight!");
           boss.setHealth(boss.getHealth() - this.getDamage());
           System.out.println(this.getName() + " атакует босса на " + this.getDamage() + " урона.");
       }else{
           boss.setHealth(boss.getHealth() - this.getDamage());
           System.out.println(this.getName() + " атакует босса на " + this.getDamage() + " урона.");
       }

   }

   @Override
   public void setHealth(int health) {
           super.setHealth(health);
   }

   public static int getFakeRound() {
       return fakeRound;
   }
}
