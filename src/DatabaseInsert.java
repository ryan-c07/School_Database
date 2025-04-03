import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;


public class DatabaseInsert {
    public static String[] departments = {"Chemistry", "Biology", "CTE", "English", "PE", "Mathematics", "Physics", "Social"};
    public static ArrayList<Teachers> teachersObjects = MakeTeacherArray();

    public static void main(String[] args) {
        // INSERT INTO Students ( StudentID, Name ) VALUES ( 5000 , 'Student200 ');
        ArrayList<Students> totalStudents = generateStudents();
        ArrayList<Rooms> totalRooms = generateRooms();

        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Students ( student_id, name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
        ArrayList<Departments> departmentObjects = new ArrayList<>();
        Departments.printDepartments(departments, departmentObjects);


        Teachers.printTeachers(teachersObjects);
        for (Students s : totalStudents){
            System.out.println(s);
        }

        MakeCourseArray();

    }
    public static ArrayList<Students> generateStudents(){
        ArrayList<Students> students = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            students.add(new Students("Student", Integer.toString(i), (int) (Math.random() * (12 - 9 + 1) + 9), i));
        }
        return students;
    }
    public static ArrayList<Rooms> generateRooms(){
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
    public static ArrayList<Teachers> MakeTeacherArray(){
        ArrayList<Teachers> teacherObjects = new ArrayList<>();
        boolean isNotATeacher = false;
        int currentDepartmentId = 0;
        int count = 1;
        String filePath = "src/teacherData.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < departments.length; i++){
                    if (line.contains(departments[i])){
                        currentDepartmentId=i+1;
                        isNotATeacher = true;
                        count--;
                    }
                }
                String firstName = line.substring(0, line.lastIndexOf(" ") + 1).trim();
                String lastName = line.substring(line.lastIndexOf(" ") + 1);
                if (!isNotATeacher){
                    teacherObjects.add(new Teachers(count, currentDepartmentId, firstName, lastName));
                }
                count++;
                isNotATeacher = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherObjects;
    }

    public static ArrayList<Courses> MakeCourseArray(){
        ArrayList<Courses> courseObjects = new ArrayList<>();
        String filePath = "src/courseData.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int course_id = Integer.parseInt(line.substring(0, line.indexOf("|")));
                String name = line.substring(line.indexOf("|") + 1, line.lastIndexOf("|"));
                int course_type_id = Integer.parseInt(line.substring(line.lastIndexOf("|") + 1));
                String course_type = "AP";
                if (course_type_id == 2) {
                    course_type = "Regents";
                }
                else if (course_type_id == 3) {
                    course_type = "Elective";
                }
                Courses new_course = (new Courses(course_id, name, new CourseType(course_type_id, course_type)));
                courseObjects.add(new_course);
                System.out.println(new_course);
            }
            Courses.printCourses(courseObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseObjects;
    }


}