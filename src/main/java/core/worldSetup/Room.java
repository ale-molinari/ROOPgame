package core.worldSetup;
import core.CharactersSetup.Enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Room {
    public static enum Direction {
        NORTH, EAST, SOUTH, WEST;
    }
    private HashMap<Direction, UUID> map;
    private String name;
    private UUID id;
    private List<Enemy> enemies = new ArrayList<>();

    public Room(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.map = new HashMap<>();
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public HashMap<Direction, UUID> getMap(){
        return map;
    }

    public void addDirection(Direction direction , UUID toRoomId) {
        this.map.put(direction, toRoomId);
    }

    public boolean hasDirection(Direction direction){
        return this.map.containsKey(direction);
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }
}
