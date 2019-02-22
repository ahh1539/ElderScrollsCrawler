package Dungeon;

import java.util.ArrayList;

public class Dungeon {
    private int size = 3;
    int id = 0;
    //int counter = -1;
    //private ArrayList<Room> roomz;
    private Room[] rooms = new Room[9];

    public Dungeon(){
        makeDungeon(size);

    }

    public void makeDungeon(int size){
        for (int i = 0; i < size; i++){
            rooms[i] = new Room(id);
        }
    }



//    public ArrayList<Door> makeDoors(int i){
//        ArrayList<Door> doors = new ArrayList<>();
//
//        if (i == 0){
//            //southwest corner, START
//            id = 0;
//            doors.add(new Door(true, rooms[0][0], rooms[0][1]));
//            //doors.add(new Door(false));
//            //doors.add(new Door(false));
//            //doors.add(new Door(false));
//        }if (i == 0 && j== 1){
//            id = 1;
//            doors.add(new Door(true, rooms[0][1], rooms[0][2]));
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[0][0], rooms[0][1]));
//            //doors.add(new Door(false));
//        }if (i == 0 && j== 2){
//            //northeast corner
//            id = 2;
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[0][2], rooms[1][2]));
//            doors.add(new Door(true, rooms[0][1], rooms[0][2]));
//            //doors.add(new Door(false));
//        }if (i == 1 && j== 2){
//            id = 3;
//            //doors.add(new Door(false));
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[1][2], rooms[1][1]));
//            doors.add(new Door(true, rooms[0][2], rooms[1][2]));
//        }
//        if (i == 1 && j== 1){
//            id = 4;
//            doors.add(new Door(true, rooms[1][2], rooms[1][1]));
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[1][1], rooms[1][0]));
//            //doors.add(new Door(false));
//        }if (i == 1 && j== 0){
//            id = 5;
//            doors.add(new Door(true, rooms[1][1], rooms[1][0]));
//            doors.add(new Door(true, rooms[1][0], rooms[2][0]));
//            //doors.add(new Door(false));
//            //doors.add(new Door(false));
//        }if (i == 2 && j== 0){
//            id = 6;
//            doors.add(new Door(true, rooms[2][0], rooms[2][1]));
//            //doors.add(new Door(false));
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[1][0], rooms[2][0]));
//        }if (i == 2 && j== 1){
//            id = 7;
//            doors.add(new Door(true, rooms[2][1], rooms[2][2]));
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[2][0], rooms[2][1]));
//            //doors.add(new Door(false));
//        }if (i == 2 && j== 2){
//            id = 8;
//            //doors.add(new Door(true,));
//            //doors.add(new Door(false));
//            doors.add(new Door(true, rooms[2][1], rooms[2][2]));
//            //doors.add(new Door(false));
//        }
//        return doors;
//    }

    public Room[] getRooms() {
        return rooms;
    }
}



//        int max_size = size -1;
//        if (counter == size - 2){
//            counter = -1;
//        }
//
//        if (size + counter - max_size == 0){
//            id = 0;
//            counter++;
//        }
//        if (size + counter - max_size == 1){
//            id = 1;
//        }