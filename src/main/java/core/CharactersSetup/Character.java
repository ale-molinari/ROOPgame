package core.CharactersSetup;

public abstract class Character {
    private double life;
    private String name;
    private double attack;
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
}
