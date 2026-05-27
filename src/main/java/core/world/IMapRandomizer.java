package core.world;
import java.util.Random;
import java.util.List;


public interface IMapRandomizer {

    default void mapRandomizer(List<Room> rooms) {
        Random rand = new Random();
        Room.Direction[] directions = Room.Direction.values();

        System.out.println("Randomizing room connections");
        for (int i = 1; i < rooms.size(); i++) {
            Room currentRoom = rooms.get(i);

            boolean connected = false;

            while (!connected) {

                int targetIndex = rand.nextInt(i);
                Room targetRoom = rooms.get(targetIndex);

                int nextDirectionIndex = rand.nextInt(directions.length);
                Room.Direction selectedDirection = directions[nextDirectionIndex];

                Room.Direction returnDirection = switch (selectedDirection) {
                    case NORTH -> Room.Direction.SOUTH;
                    case EAST -> Room.Direction.WEST;
                    case SOUTH -> Room.Direction.NORTH;
                    case WEST -> Room.Direction.EAST;
                };

                if (currentRoom.hasDirection(selectedDirection) &&
                        targetRoom.hasDirection(returnDirection)) {

                    currentRoom.addDirection(selectedDirection, targetRoom.getId());
                    targetRoom.addDirection(returnDirection, currentRoom.getId());

                    connected = true;
                }
            }
        }
        System.out.println("Connections Done");
    }

}

