package core.characters;
import java.util.UUID;

public class Hero extends Character {

    private UUID startingRoomId;
    private int exp;

    public Hero(double life, String name, double attack) {
        super(life, name, attack);
        this.exp = 0;
    }
    public UUID getStartingRoomId() {
        return startingRoomId;
    }
    public void setStartingRoomId(UUID startingRoomId) {
        this.startingRoomId = startingRoomId;
    }
    public void gainExp(int amount) {
        this.exp += amount;
        System.out.println("You gain " + this.exp + "Exp");
    }
}
