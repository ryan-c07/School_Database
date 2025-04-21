import java.util.ArrayList;

public class Room {
    private int room_id;
    private String room_number;


    public Room(int id, String room){
        room_id = id;
        room_number = room;
    }

    public static void printRooms (ArrayList<Room> totalRooms){
        for (int i = 0; i < totalRooms.size(); i++) {
            Room currentRoom = totalRooms.get(i);
            System.out.println("INSERT INTO Room ( room_id, room_number ) VALUES ( " + currentRoom.room_id + ", '"
                    + currentRoom.room_number + "' );");
        }
    }

    public int getID() {
        return room_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String toString(){
        return "room_id: " + room_id + ", room_number: " + room_number;
    }
}
