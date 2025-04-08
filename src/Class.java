import java.util.ArrayList;

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
  public static void printClasses (ArrayList<Class> classObjects) {
    for (Class currentClass : classObjects){
      System.out.println("INSERT INTO Class ( class_id, course_id, teacher_id, room_id, period ) VALUES ( " + currentClass.class_id + ", " + currentClass.course_id + ", " + currentClass.teacher_id + ", " + currentClass.room_id + ", " + currentClass.period + " );");
    }
  }

  public int getPeriod() {
    return period;
  }

  public int getClass_id() {
    return class_id;
  }

  public String toString(){
    return "class_id="+class_id+"|course_id="+course_id+"|teacher_id="+teacher_id+"|room_id="+room_id+"|period"+period;
  }
}
