import java.util.ArrayList;


public class Department {
    private int department_id; // PRIMARY KEY
    private String name;
    public Department(int department_id, String name) {
        this.department_id = department_id;
        this.name = name;
    }




    public static void printDepartments (String[] departments, ArrayList<Department> departmentObjects){
        for (int i = 0; i < departments.length; i++) {
            System.out.println("INSERT INTO Departments ( department_id , name ) VALUES ( " + i+1 + ", '" + departments[i] + "' );");
            departmentObjects.add(new Department(i, departments[i]));
        }
    }
}
