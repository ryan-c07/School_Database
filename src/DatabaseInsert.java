import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DatabaseInsert {
    public static String[] departments = {"Chemistry", "Biology", "CTE", "English", "PE", "Mathematics", "Physics", "Social"};
    public static ArrayList<Teacher> teacherObjects = makeTeacherArray();
    public static ArrayList<Class> classObjects = makeClassArray();
    public static ArrayList<Course> courseObjects = makeCourseArray();
    public static ArrayList<Student> studentObjects = generateStudents();
    public static ArrayList<Roster> rosterObjects = makeRosterArray();

    public static void main(String[] args) {
        printEverything();
    }


    public static void printEverything(){
        ArrayList<Room> totalRooms = generateRooms();
        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Student ( student_id, name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
        ArrayList<Department> departmentObjects = new ArrayList<>();
        Department.printDepartments(departments, departmentObjects);

        Teacher.printTeachers(teacherObjects);
        Course.printCourses(courseObjects);
        Class.printClasses(classObjects);
        Roster.printRosters(rosterObjects);
        generateAssignments();
        generateGrades();
    }
    public static ArrayList<Student> generateStudents(){
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            students.add(new Student("Student", Integer.toString(i), (int) (Math.random() * (12 - 9 + 1) + 9), i));
        }
        return students;
    }
    public static ArrayList<Room> generateRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        int numRooms = 1;
        for (int f = 0; f != 9; f++){
            switch (f) {
                case 0:
                    for (int r = 1; r != 21; r++){
                        rooms.add(new Room(numRooms, "BN" + r));
                        numRooms++;
                        rooms.add(new Room(numRooms, "BS" + r));
                        numRooms++;
                        rooms.add(new Room(numRooms, "BE" + r));
                        numRooms++;
                        rooms.add(new Room(numRooms, "BW" + r));
                        numRooms++;
                    }
                    break;
                default:
                    for (int r = 1; r != 21; r++){
                        rooms.add(new Room(numRooms, f + "N" + r));
                        numRooms++;
                        rooms.add(new Room(numRooms, f + "S" + r));
                        numRooms++;
                        rooms.add(new Room(numRooms, f + "E" + r));
                        numRooms++;
                        rooms.add(new Room(numRooms, f + "W" + r));
                        numRooms++;
                    }
            }
        }
        return rooms;
    }
    public static ArrayList<Class> makeClassArray() {
        ArrayList<Class> classes = new ArrayList<>();
        ArrayList<Course> courses = makeCourseArray();
        int count = 1; // class ID
        ArrayList<Integer> numOfClassesPerCourse = new ArrayList<>();

        // fill number of offerings per course with random number
        for (int i = 0; i < courses.size(); i++ ) {
            int randomNumberOfOfferings = (int) (Math.random() * 5 + 1); // 1–5
            numOfClassesPerCourse.add(randomNumberOfOfferings);
        }
        int maxPerPeriod = HelperMethods.sumOfArray(numOfClassesPerCourse) / 10;

        for ( int period = 1; period < 11; period++ ) { // 10 periods
            ArrayList<Room> rooms = generateRooms();
            ArrayList<Teacher> tempTeachers = makeTeacherArray();
            int offeringsDuringPeriod = 0;
            for ( int j = 0; j < rooms.size(); j++ ) {
                if (tempTeachers.isEmpty()) {
                    break; // all teachers are booked for that period
                }

                if (HelperMethods.allZero(numOfClassesPerCourse)) {
                    break; // all course offerings are used
                }
                if (offeringsDuringPeriod == maxPerPeriod){
                    break; // spreading the periods out
                }
                Teacher randomTeacher = tempTeachers.get((int) (Math.random() * tempTeachers.size())); // get a random teacher
                tempTeachers.remove(randomTeacher);

                Room randomRoom = rooms.get((int) (Math.random() * rooms.size())); // get a random room
                rooms.remove(randomRoom);

                int idxRandomCourse = (int) (Math.random() * numOfClassesPerCourse.size()); // get a random course
                while ( numOfClassesPerCourse.get(idxRandomCourse) == 0 ) { // search for another course if no more offerings left
                    idxRandomCourse = (int) (Math.random() * numOfClassesPerCourse.size());
                }
                Course randomCourse = courses.get(idxRandomCourse);
                numOfClassesPerCourse.set(idxRandomCourse, numOfClassesPerCourse.get(idxRandomCourse) - 1);

                Class newClass = new Class(count, randomCourse.getCourse_id(), randomTeacher.getTeacher_id(), randomRoom.getRoom_id(), period);
                classes.add(newClass);
                count++;
                offeringsDuringPeriod++;
            }
        }
        return classes;
    }
    public static ArrayList<Teacher> makeTeacherArray(){
        ArrayList<Teacher> teacherObjects = new ArrayList<>();
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
                    teacherObjects.add(new Teacher(count, currentDepartmentId, firstName, lastName));
                }
                count++;
                isNotATeacher = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherObjects;
    }
    public static ArrayList<Course> makeCourseArray(){
        ArrayList<Course> courseObjects = new ArrayList<>();
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
                Course new_course = (new Course(course_id, name, new CourseType(course_type_id, course_type)));
                courseObjects.add(new_course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseObjects;
    }
    public static ArrayList<Roster> makeRosterArray(){
        ArrayList<Roster> rosters = new ArrayList<>();
        for ( Student student : studentObjects ){
            for (int i = 0; i < 10; i++) {
                int period = i+1;
                Class classObject = HelperMethods.getClass(classObjects, period);
                Roster roster = new Roster(student.getStudent_id(), classObject.getClass_id());
                rosters.add(roster);
            }
        }
        return rosters;
    }
    public static ArrayList<Assignment> makeAssignmentsArray(){
        ArrayList<Class> classes = makeClassArray();
        ArrayList<Assignment> assignments = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            Class tempClass = classes.get(i);
            for (int j = 0; j < 15; j++) {
                if (j < 12) { // MINOR ASSESSMENTS
                    Assignment newAssignment = new Assignment(j, "Assignment" + j, tempClass.getClass_id(), 1);
                    assignments.add(newAssignment);
                }
                else { // MAJOR ASSESSMENTS
                    Assignment newAssignment = new Assignment(j, "Assignment" + j, tempClass.getClass_id(), 2);
                    assignments.add(newAssignment);
                }
            }
        }
        return assignments;
    }
    public static void generateAssignments(){
        ArrayList<Class> classes = makeClassArray();
        for (int i = 0; i < classes.size(); i++) {
            Class tempClass = classes.get(i);
            for (int j = 0; j < 15; j++) {
                if (j < 12) { // MINOR ASSESSMENTS
                    System.out.println("INSERT INTO Assignment ( assignment_id, title, class_id, assignment_type_id ) VALUES ( " + j + ", 'Assignment" + j + "'" + ", " + tempClass.getClass_id() + ", 1 );");
                }
                else { // MAJOR ASSESSMENTS
                    System.out.println("INSERT INTO Assignment ( assignment_id, title, class_id, assignment_type_id ) VALUES ( " + j + ", 'Assignment" + j + "'" + ", " + tempClass.getClass_id() + ", 2 );");
                }
            }
        }
    }
    public static void generateGrades(){
        ArrayList<Assignment> assignments = makeAssignmentsArray();
        ArrayList<Roster> rosters = makeRosterArray();


        for (int i = 0; i < rosters.size(); i++) {
            Roster tempRoster = rosters.get(i);
            int student_id = tempRoster.getStudent_id();
            for (int j = 0; j < assignments.size(); j++) {
                Assignment tempAssignment = assignments.get(j);
                if (tempAssignment.getClass_id() == tempRoster.getClass_id()) {
                    int randomGrade = (int) (Math.random() * 26) + 75;
                    System.out.println("INSERT INTO Grade ( assignment_id, student_id, score ) VALUES ( " + tempAssignment.getAssignment_id() + ", " + student_id + "'" + ", " + randomGrade + " );");
                }
            }
        }
    }
}
