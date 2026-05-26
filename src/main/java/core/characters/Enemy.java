package core.characters;

public class Enemy extends Character implements IChallenge {

    private final int expValue;

    public Enemy(double life, String name, double attack) {
        super(life, name, attack);
        this.expValue = 40;
    }
    public int getExpReward() {
        return this.expValue;
    }
}

