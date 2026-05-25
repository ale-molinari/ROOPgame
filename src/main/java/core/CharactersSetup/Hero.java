package core.CharactersSetup;
import java.util.UUID;

public class Hero extends Character implements Challenge{

    private UUID startingRoomId;

    public Hero(double life, String name, double attack) {
        super(life, name, attack);
    }
    public UUID getStartingRoomId() {
        return startingRoomId;
    }
    public void setStartingRoomId(UUID startingRoomId) {
        this.startingRoomId = startingRoomId;
    }
}
