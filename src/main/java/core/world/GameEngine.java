package core.world;

import core.characters.CombatManager;
import core.characters.Enemy;
import core.characters.Hero;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class GameEngine {

    public GameEngine(){}

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        GameSetup gameSetup = new GameSetup();
        gameSetup.mapSetup(10);

        Hero hero = gameSetup.getHero();
        List<Room> map = gameSetup.getGlobalGameMap();

        Room currentRoom = map.getFirst();

        boolean isAlive = true;

        while (isAlive) {

            System.out.println("Room: " + currentRoom.getName());

            if (currentRoom.hasEnemies()) {
                Enemy enemy = currentRoom.getEnemy();
                System.out.println(enemy.getName() + " in your path");
                System.out.println("Battle started");

                while (currentRoom.hasEnemies() && !hero.isDead()) {
                    System.out.println("(1) Battle Him");
                    String choice = scanner.nextLine();

                    if (choice.equals("1")) {
                        CombatManager.executeBattle(hero, enemy, currentRoom);
                    } else {
                        System.out.println("The goblin looks at you confused");
                    }

                    if (hero.isDead()) {
                        System.out.println("GAME OVER");
                        isAlive = false;
                    }
                }
            }else {
                System.out.println("\nThe Room is empty");
                HashMap<Room.Direction, UUID> exits = currentRoom.getMap();

                for (Room.Direction dir : exits.keySet()) {
                    System.out.println("-" + dir);
                }
                System.out.println("Insert direction");
                System.out.println("Insert EXIT to quit the game");
                String input = scanner.nextLine().toUpperCase();

                if (input.equals("EXIT")) {
                    isAlive = false;
                } else {
                    try {
                        Room.Direction chosenDir = Room.Direction.valueOf(input);
                        if (exits.containsKey(chosenDir)) {
                            UUID nextRoomId = exits.get(chosenDir);
                            for (Room r : map) {
                                if (r.getId().equals(nextRoomId)) {
                                    currentRoom = r;
                                    break;
                                }
                            }
                        }

                    }

                    catch (IllegalArgumentException e) {
                        System.out.println("Invalid direction");
                    }
                }
            }
        }
        System.out.println("Closing Game");
        scanner.close();
    }
}
