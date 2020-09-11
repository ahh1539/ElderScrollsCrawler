package Dungeon;


public class Door {

    private boolean canPass;
    private Room[] rooms;

    public Door(boolean canpass, Room room1, Room room2) {
        this.canPass = canpass;
        rooms = new Room[2];
        rooms[0] = room1;
        rooms[1] = room2;

    }

    public Room[] getRooms() {
        return rooms;
    }

}
