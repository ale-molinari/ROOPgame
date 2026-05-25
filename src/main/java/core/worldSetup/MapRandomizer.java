package core.worldSetup;
import java.util.Random;
import java.util.List;


public interface MapRandomizer {

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

                Room.Direction returnDirection = null;
                switch (selectedDirection) {
                    case NORTH:
                        returnDirection = Room.Direction.SOUTH;
                        break;
                    case EAST:
                        returnDirection = Room.Direction.WEST;
                        break;
                    case SOUTH:
                        returnDirection = Room.Direction.NORTH;
                        break;
                    case WEST:
                        returnDirection = Room.Direction.EAST;
                        break;
                }

                if (!currentRoom.hasDirection(selectedDirection) &&
                        !targetRoom.hasDirection(returnDirection)) {

                    currentRoom.addDirection(selectedDirection, targetRoom.getId());
                    targetRoom.addDirection(returnDirection, currentRoom.getId());

                    connected = true;
                    //*System.out.println("Room " + currentRoom.getId() + " has been added to room " + targetRoom.getId());
                }
            }
        }
        System.out.println("Connections Done");
    }

}

