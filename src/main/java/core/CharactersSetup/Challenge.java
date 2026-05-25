package core.CharactersSetup;

import java.util.Random;

import static core.CharactersSetup.Character.MULTIPLIERS;

public interface Challenge {

    double getAttack();

    default void challenge(Character p) {
        Random rand = new Random();
        int min = 1;
        int max = 6;
        int randNum = rand.nextInt(min, max + 1);

        if (randNum == 1) {
            System.out.println("Target Missed");
        } else {
            double multiplier = MULTIPLIERS[randNum - 1];
            double damage = getAttack() * multiplier;
            double newLife = p.getLife() - damage;
            if(newLife <= 0) {
                p.setLife(0);
            }
            else{
                p.setLife(newLife);
            }
            System.out.println("Number " + randNum + ", " + p.getName() + " has now " + p.getLife() + " life point");
        }
    }
}
