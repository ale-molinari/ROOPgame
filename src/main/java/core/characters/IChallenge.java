package core.characters;

import java.util.Random;

import static core.characters.Character.MULTIPLIERS;

public interface IChallenge {

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
            double damageAmount = getAttack() * multiplier;
            p.takeDamage(damageAmount);
            System.out.println("Dice: " + randNum + ". " + damageAmount + " damages inflicted. " + p.getName() + " has now " + p.getLife() + " HP rimanenti.");
            if (p.isDead())
                System.out.println(p.getName() + " is dead");
        }
    }
}

