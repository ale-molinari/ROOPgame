package core.characters;

public class Enemy extends Character {

    private final int expValue;

    public Enemy(double life, String name, double attack) {
        super(life, name, attack);
        this.expValue = 40;
    }
    public int getExpReward() {
        return this.expValue;
    }

    @Override
    public void specialMove(Character p) {
        System.out.println(this.getName() + " enters in fury mode!!");
        this.setAttack(this.getAttack() + 10);
        this.challenge(p);
    }
}

