import java.util.ArrayList;

public class Roster {
    private int class_id, student_id;

    public Roster(int student_id, int class_id) {
        this.student_id = student_id;
        this.class_id = class_id;
    }

    public static void printRosters (ArrayList<Roster> rosterObjects) {
        for (Roster roster : rosterObjects){
            System.out.println("INSERT INTO Roster ( class_id, student_id ) VALUES ( " + roster.class_id + ", " + roster.student_id + " );");
        }
    }

    public int getClass_id() {
        return class_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "class_id=" + class_id +
                ", student_id=" + student_id +
                '}';
    }
}
