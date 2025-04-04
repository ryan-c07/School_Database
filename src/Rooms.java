public class Rooms {
    private int room_id;
    private String room_number;


    public Rooms(int id, String room){
        room_id = id;
        room_number = room;
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
