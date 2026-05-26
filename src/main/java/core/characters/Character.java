package core.characters;

public abstract class Character implements IHealthCheck, IChallenge {
    private double life;
    private String name;
    private final double attack;
    public static final double[] MULTIPLIERS = new double[]{0.0, 0.15, 0.20, 0.25, 0.30, 0.40};

    public Character(double life, String name, double attack) {
        this.life = life;
        this.name = name;
        this.attack = attack;
    }
    public double getLife() {
        return life;
    }
    public String getName() {
        return name;
    }
    public double getAttack(){
        return attack;
    }
    public void setLife(double life) {
        this.life = life;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void takeDamage(double damageAmount){
        double newLife = this.life - damageAmount;
        if(newLife <= 0){
            this.life = 0;
        } else {
            this.life = newLife;
        }

    }
    @Override
    public boolean isDead(){
        return this.life <= 0;
    }
}
