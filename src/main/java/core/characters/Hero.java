package core.characters;
import java.util.Random;
import java.util.UUID;

public class Hero extends Character {

    private UUID startingRoomId;
    private int exp;

    public Hero(double life, String name, double attack) {
        super(life, name, attack);
        this.exp = 0;
    }

    

    public void setStartingRoomId(UUID startingRoomId) {
        this.startingRoomId = startingRoomId;
    }

    public void gainExp(int amount) {
        this.exp += amount;
        System.out.println("You gain " + this.exp + "Exp");
    }

    @Override
    public void challenge(Character p) {
        Random rand = new Random();
        int min = 1;
        int max = 6;
        int randNum = rand.nextInt(min, max + 1);

        if (randNum == 1) {
            System.out.println("Target Missed");
        } else if (randNum == 6) {
            double multiplier = MULTIPLIERS[randNum - 1];
            double damageAmount = (getAttack() * multiplier) *1.5;
            p.takeDamage(damageAmount);
            System.out.println("Dice: " + randNum + ". " + damageAmount + " Critical Damage inflicted. " + p.getName() + " has now " + p.getLife() + " HP");
        } else {
            double multiplier = MULTIPLIERS[randNum - 1];
            double damageAmount = (getAttack() * multiplier);
            p.takeDamage(damageAmount);
            System.out.println("Dice: " + randNum + ". " + damageAmount + " damages inflicted. " + p.getName() + " has now " + p.getLife() + " HP");
        }
    }

    @Override
    public void specialMove(Character p) {
        System.out.println(this.getName() + " Tries a special move");
        Random rand = new Random();
        int min = 1;
        int max = 6;
        int randNum = rand.nextInt(min, max + 1);
        if (randNum == 4) {
            double damage = 30;
            p.takeDamage(damage);
        } else {
            System.out.println("Missed");
        }
    }
}
