public class AssignmentType {
  private int assignment_type_id;
  private String assignment_type;

  public AssignmentType(int id, String type){
    assignment_type_id = id;
    assignment_type = type;
  }

  public String toString(){
    return "assignment_type_id: " + assignment_type_id + ", assignment_type: " + assignment_type;
  }
}
