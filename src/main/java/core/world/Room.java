package core.world;
import core.characters.Enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Room {
    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }
    private final HashMap<Direction, UUID> map;
    private final String name;
    private final UUID id;
    private final List<Enemy> enemies = new ArrayList<>();

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

    public HashMap<Direction, UUID> getMap(){
        return map;
    }

    public void addDirection(Direction direction , UUID toRoomId) {
        this.map.put(direction, toRoomId);
    }

    public boolean hasDirection(Direction direction){
        return !this.map.containsKey(direction);
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }

    public boolean hasEnemies(){
        return !this.enemies.isEmpty();
    }

    public Enemy getEnemy() {
        return this.enemies.getFirst();
    }
}
