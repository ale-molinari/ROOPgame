package core.characters;

public interface IHealthCheck {

    void takeDamage(double damageAmount);

    boolean isDead();
}
