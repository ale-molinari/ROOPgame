package core.world;

import core.characters.Hero;

import java.util.*;

public class GameSetup implements IMapRandomizer, IEnemyRandomizer {

    private enum Names {
        DIRTY, SWAMP, ACID, FIRE
    }
    private final List<Room> globalGameMap = new ArrayList<>();
    private Hero hero;

    public void mapSetup(int n) {

        Random rand = new Random();
        this.globalGameMap.clear();

        Names[] names = GameSetup.Names.values();
        for (int i = 1; i <= n; i++) {
            int randNum = rand.nextInt(names.length);
            globalGameMap.add(new Room(names[randNum].name()));
        }
        mapRandomizer(this.globalGameMap);
        System.out.println("Map Created");
        enemyRandomizer(this.globalGameMap);

        this.hero = new Hero(100,"Tarnished",40);
        Room startingRoom = globalGameMap.getFirst();
        hero.setStartingRoomId(startingRoom.getId());
        System.out.println("Hero woke up in " + startingRoom.getName() +" Room");
    }

    public List<Room> getGlobalGameMap() {
        return globalGameMap;
    }

    public Hero getHero() {
        return hero;
    }
}
