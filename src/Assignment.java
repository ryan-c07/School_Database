public class Assignment {
  private int assignment_id;
  private int class_id;
  private String title;
  private String description;
  private int assignment_type_id;

  public Assignment(int assignment_id, String title, int class_id, int assignment_type_id) {
    this.assignment_id = assignment_id;
    this.class_id = class_id;
    this.title = title;
    this.assignment_type_id = assignment_type_id;
  }

  public int getAssignment_id() {
    return assignment_id;
  }

  public int getClass_id() {
    return class_id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public int getAssignment_type_id() {
    return assignment_type_id;
  }
}
