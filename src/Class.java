public class Class {
  private int class_id;
  private int course_id;
  private int teacher_id;
  private int room_id;
  private int period;

  public Class(int classid, int courseid, int teacherid, int roomid, int p){
    class_id = classid;
    course_id = courseid;
    teacher_id = teacherid;
    room_id = roomid;
    period = p;
  }


  public String toString(){
    return "class_id: " + class_id + ", course_id: " + course_id + ", teacher_id: " + teacher_id+ ", room_id: " + room_id+ ", period: " + period;
  }
}
