package core.worldSetup;

import core.CharactersSetup.Hero;

import java.util.*;

public class GameSetup implements MapRandomizer, EnemyRandomizer {

    private static enum Names {
        DIRTY, SWAMP, ACID, FIRE;
    }
    private List<Room> globalGameMap = new ArrayList<>();
    private Hero hero;

    public void mapSetup(int n) {

        Random rand = new Random();
        this.globalGameMap.clear();

        Names[] names = GameSetup.Names.values();
        for (int i = 1; i <= n; i++) {
            int randNum = rand.nextInt(names.length);
            globalGameMap.add(new Room(names[randNum].name()));
            //*System.out.println("Creating Room " + i + " " + names[randNum].name());
        }
        mapRandomizer(this.globalGameMap);
        System.out.println("Map Created");
        enemyRandomizer(this.globalGameMap);

        this.hero = new Hero(100,"Tarnished",20);
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
