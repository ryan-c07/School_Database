import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;


public class DatabaseInsert {
    public static void main(String[] args) {
        // INSERT INTO Students ( StudentID, Name ) VALUES ( 5000 , 'Student200 ');
        ArrayList<Students> totalStudents = generateStudents();
        ArrayList<Rooms> totalRooms = generateRooms();


        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Students ( student_id, name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
        String[] departments = {"Biology", "Chemistry", "CTE, Computer Science & Engineering", "English",
                "Mathematics", "Physics", "Social Studies", "Special Education", "Visual & Performing Arts", "World Languages & ENL"};
        ArrayList<Departments> departmentObjects = new ArrayList<>();
        Departments.printDepartments(departments, departmentObjects);
        for (Students s : totalStudents){
            System.out.println(s);
        }

    }
    static ArrayList<Students> generateStudents(){
        ArrayList<Students> students = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            students.add(new Students("Student", Integer.toString(i), (int) (Math.random() * (12 - 9 + 1) + 9), i));
        }
        return students;
    }
    static ArrayList<Rooms> generateRooms(){
        ArrayList<Rooms> rooms = new ArrayList<>();
        int numRooms = 1;
        for (int f = 0; f != 9; f++){
            switch (f) {
                case 0:
                    for (int r = 1; r != 21; r++){
                        rooms.add(new Rooms(numRooms, "BN" + r));
                        numRooms++;
                        rooms.add(new Rooms(numRooms, "BS" + r));
                        numRooms++;
                        rooms.add(new Rooms(numRooms, "BE" + r));
                        numRooms++;
                        rooms.add(new Rooms(numRooms, "BW" + r));
                        numRooms++;
                    }
                    break;
                default:
                    for (int r = 1; r != 21; r++){
                        rooms.add(new Rooms(numRooms, f + "N" + r));
                        numRooms++;
                        rooms.add(new Rooms(numRooms, f + "S" + r));
                        numRooms++;
                        rooms.add(new Rooms(numRooms, f + "E" + r));
                        numRooms++;
                        rooms.add(new Rooms(numRooms, f + "W" + r));
                        numRooms++;
                    }
            }
        }
        return rooms;
    }
}