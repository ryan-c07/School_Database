public class Grades {
    private int assignment_id; // FOREIGN KEY
    private int student_id; // FOREIGN KEY
    private int score;

    public Grades(int a_id, int s_id, int s){
        assignment_id = a_id;
        student_id = s_id;
        score = s;
    }

    public String toString(){
        return "assignment_id: " + assignment_id + ", student_id: " + student_id + ", score: " + score;
    }
}
