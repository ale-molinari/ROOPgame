package core.worldSetup;
import core.CharactersSetup.Enemy;
import java.util.List;
import java.util.Random;

public interface EnemyRandomizer {

    default void enemyRandomizer(List<Room> rooms) {
        Random rand = new Random();
        for(int i = 1; i < rooms.size(); i++) {
            Room currentRoom = rooms.get(i);
            if (rand.nextInt(101) < 65) {
                Enemy goblin = new Enemy(30, "Goblin", 15);
                currentRoom.addEnemy(goblin);
            };
        }
        System.out.println("Populating Done");
    }
}
